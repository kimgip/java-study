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
				String response = br.readLine();
				String[] tokens = response.split(":");
				
				if ("QUIT".equals(tokens[0]) & "OK".equals(tokens[1])) {
					ChatClient.log("quit");
					break;
				}
				
				if ("MSG".equals(tokens[0])) {
					message = tokens[1] + ": " + tokens[2];
				}
				
				if ("NOTICE".equals(tokens[0])) {
					message = tokens[1];
				}
				
				System.out.println(message);
			}
		} catch (IOException e) {
			ChatClient.log("error: "+e);
		}
	}

}
