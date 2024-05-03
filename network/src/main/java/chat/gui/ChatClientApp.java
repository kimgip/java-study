package chat.gui;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientApp {
	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);

		while( true ) {
			
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();
			
			if (!name.isEmpty()) {
				break;
			}
			
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		
		scanner.close();
		
		String serverIP = "127.0.0.1";
		int port = 8080;
		
		Socket socket = new Socket();
		if(args.length > 1) {
			serverIP = args[0];
			port = Integer.parseInt(args[1]);
		}
			
		try {
			socket.connect(new InetSocketAddress(serverIP, port));
			new ChatWindow(name).show(socket);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
