package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class ChatServerThread extends Thread {
	private String nickName;
	private Socket socket;
	private List<Writer> writerPool;
	
	public ChatServerThread(Socket socket, List<Writer> writerPool) {
		this.socket = socket;
		this.writerPool = writerPool;
	}

	@Override
	public void run() {
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
			
			InetSocketAddress inetSocketAddress = ( InetSocketAddress )socket.getRemoteSocketAddress();
			ChatServer.log( "connected from " + inetSocketAddress.getAddress().getHostAddress() + ":" + inetSocketAddress.getPort() );
			
			while(true) {
				String request = br.readLine();
				if (request == null) {
					ChatServer.log("closed by client");
					doQuit(pw);
					break;
				}
			
				// protocol 분석
				String[] tokens = request.split(":"); // 추가 미션: base64 encoding 이용
				
				switch (tokens[0]) {
				case "JOIN":
					doJoin(tokens[1], pw);
					break;
				case "MSG":
					doMessage(tokens[1]);
					break;
				case "QUIT":
					doQuit(pw);
					System.out.println("try to remove.");
					break;
				default:
					ChatServer.log("error: unknown request("+tokens[0]+")");
				}
			}
		}  catch (SocketException e) {
//			log("Socket Exception: "+e);
			ChatServer.log("closed by client");
			doQuit(pw);
		} catch(IOException e) {
			ChatServer.log("error: "+e);
		}
	}

	private void doQuit(Writer w) {
		removeWriter(w);
		
		broadcast(nickName +"님이 퇴장하였습니다.");
	}

	private void removeWriter(Writer w) {
		writerPool.remove(w);
	}

	private void doMessage(String message) {
		broadcast(nickName+":"+message);
	}

	private void doJoin(String nickName, PrintWriter pw) {
		this.nickName = nickName;
		
		broadcast(this.nickName+"님이 입장하셨습니다.");
		
		// writer pool에 저장
		addWriter(pw);
		
		// ack
		pw.println("JOIN:OK");
		pw.flush();
	}

	private void addWriter(PrintWriter pw) {
		synchronized (writerPool) {
			writerPool.add(pw);
		}
	}
	
	private void broadcast(String data) {
		for(Writer w: writerPool) {
			PrintWriter pw = (PrintWriter)w;
			pw.println(data);
			pw.flush();
		}
	}
	
}
