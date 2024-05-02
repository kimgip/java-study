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
		
		serverIP = "192.168.0.90";
		port = ChatServer.PORT;
		if(args.length > 1) {
			serverIP = args[0];
			port = Integer.parseInt(args[1]);
		}
		Socket socket = new Socket();
		try {
			socket.connect(new InetSocketAddress(serverIP, port));
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			System.out.print("닉네임>>");
			String nickname = scanner.nextLine();
			pw.println("JOIN:"+nickname);
			pw.flush();
			
			while(true) {
				String[] tokens = br.readLine().split(":");
				if("JOIN".equals(tokens[0])) {
					System.out.println(nickname+"님 채팅방에 오신 것을 환영합니다.");
					break;
				}
			}
			
			new ChatClientThread(br).start();
			
			while(true) {
				String msg = scanner.nextLine();
				
				if("quit".equals(msg)) {
					pw.println("QUIT");
					pw.flush();
					break;
				} else {
					pw.println("MSG:"+msg);
					pw.flush();
				}
			}
			
		} catch (SocketException e) {
//			log("socket error: "+e);
			log("disconnected");
		} catch (IOException e) {
			log("error: "+e);
		} finally {
			try {
				if(socket != null & !socket.isClosed())
					socket.close();
			} catch (SocketException e) {
				log("disconnected");
			} catch (IOException e) {
				log("error: "+e);
			}
			
			scanner.close();
		}
	}
	
	public static void log(String message) {
		System.out.println("[client] "+message);
	}

}
