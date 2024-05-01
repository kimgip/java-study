package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			while(true) {
				System.out.print("> ");
				String hostName = scanner.nextLine();
				
				hostName = hostName.strip();
				if("exit".equals(hostName)) {
					break;
				}
				
				InetAddress[] inetAddresses = InetAddress.getAllByName(hostName);
				for(InetAddress inetAddress : inetAddresses) {
					System.out.println(inetAddress.getHostName()+" : "+inetAddress.getHostAddress());
				}
			}
		} catch (UnknownHostException e) {
			System.out.println("unknown host name");
		} finally {
			scanner.close();
		}
	}

}
