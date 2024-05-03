package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ChatClient {
	private static String serverIP;
	private static int port;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		serverIP = "127.0.0.1";
		port = ChatServer.PORT;
		if(args.length > 1) {
			serverIP = args[0];
			port = Integer.parseInt(args[1]);
		}
		Socket socket = new Socket();
		try {
			socket.connect(new InetSocketAddress(serverIP, port));
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
			
			System.out.print("닉네임>>");
			String nickname = scanner.nextLine();
			
			// join req
			pw.println("JOIN:"+nickname);
			
			// res
			String res = br.readLine();
			
			if(res != null) {
				// join res
				String[] tokens = res.split(":");
				if("JOIN".equals(tokens[0])) {
					log("join");
					System.out.println(nickname+"님 환영합니다.");
					
					// listener
					new ChatClientThread(br).start();
					// speaker
					while(true) {
						String msg = scanner.nextLine();
						
						if("quit".equals(msg)) {
							// quit req
							pw.println("QUIT");
							break;
						} else {
							// msg req
							pw.println("MSG:"+msg);
						}
					}
				}
			}

			
		} catch (SocketException e) {
			log("socket exception : closed server");
		} catch (IOException e) {
			log("error: "+e);
		} finally {
			try {
				if(socket != null & !socket.isClosed())
					socket.close();
			} catch (IOException e) {
				log("error: "+e);
			}
			
			scanner.close();
		}
	}
	
	public static void log(String message) {
		System.out.println("[client] "+ message);
	}

}