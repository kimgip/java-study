package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	public static final int PORT = 8080;
	private static List<Writer> writerPool;
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			
			writerPool = new ArrayList<Writer>();
			while (true) {
				socket = serverSocket.accept();
				new ChatServerThread(socket, writerPool).start();
			}
			
		} catch (IOException e) {
			log("error: "+e);
		} finally {
			try {
				if(serverSocket != null & serverSocket.isClosed()){
					serverSocket.close();
				}
				if(socket != null & !socket.isClosed()){
					socket.close();
				}
			} catch(IOException e) {
				log("error: "+e);
			}
		}
		
	}
	
	public static void log(String message) {
		System.out.println("[server] "+message);
	}

}
