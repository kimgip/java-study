package chat.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Base64;

import chat.ChatClient;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	
	private String name;
	private PrintWriter printWriter;
	private BufferedReader bufferedReader;

	public ChatWindow(String name) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.name = name;
	}

	public void show(Socket socket) {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if(keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish(socket);
			}
		});
		frame.setVisible(true);
		frame.pack();
		
		// IOSTream 받아오기
		// ChatClientThread 생성
		try {
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			printWriter.println("JOIN:"+name);
			String joinResponse = bufferedReader.readLine();
			String[] tokens = joinResponse.split(":");
			if("JOIN".equals(tokens[0]) & "OK".equals(tokens[1])) {
				new chatClientThread().start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void sendMessage() {
		String message = null;
		try {
			message = Base64.getEncoder().encodeToString(textField.getText().getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if("".equals(message))
			return;
		printWriter.println("MSG:"+message);
		
		textField.setText("");
		textField.requestFocus();
	}
	
	private void updateTextAread(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	
	private void finish(Socket socket) {
		// quit protocol 구현
		printWriter.println("QUIT");
		
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// exit java application
		System.exit(0);
	}

	private class chatClientThread extends Thread {		
		public chatClientThread() {}
		
		public void run() {

			try {
				String message = null;
				while(true) {
					String response = bufferedReader.readLine();
					String[] tokens = response.split(":");
					
					if ("QUIT".equals(tokens[0]) & "OK".equals(tokens[1])) {
						break;
					}
					
					if ("MSG".equals(tokens[0])) {
						message = tokens[1] + ": " + new String(Base64.getDecoder().decode(tokens[2]), "utf-8");
					}
					
					if ("NOTICE".equals(tokens[0])) {
						message = tokens[1];
					}
					
					updateTextAread(message);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
				
		}
	}
}
