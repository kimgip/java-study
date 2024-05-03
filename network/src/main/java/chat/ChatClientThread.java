package chat;

import java.io.BufferedReader;
import java.io.IOException;

public class ChatClientThread extends Thread {
	private BufferedReader br;
	
	public ChatClientThread(BufferedReader br) {
		this.br = br;
	}
	
	@Override
	public void run() {
		try {
			String message = null;
			while(true) {
				String flag = br.readLine();
				
				if ("QUIT".equals(flag)) {
					ChatClient.log("quit");
					break;
				}
				
				if ("MSG".equals(flag)) {
					String sender = br.readLine();
					message = sender + ": " + br.readLine();
				}
				
				if ("NOTICE".equals(flag)) {
					message = br.readLine();
				}
				
				System.out.println(message);
			}
		} catch (IOException e) {
			ChatClient.log("error: "+e);
		}
	}

}
