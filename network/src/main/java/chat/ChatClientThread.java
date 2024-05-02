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
			while(true) {
				String data = br.readLine();
				System.out.println(data);
			}
		} catch (IOException e) {
			ChatClient.log("error: "+e);
		}
	}

}
