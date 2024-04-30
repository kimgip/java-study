package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class PhoneList01 {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			/* exception에 로직을 쓰지 말 것.
			 * 오직 로그, 사과, 종료 세가지만 할 것(catch는 메모리 차지가 너무 크기 때문)*/
			File file = new File("./phone.txt");
			if(!file.exists()) {
				System.out.println("file not found");
				return;
			}
			
			System.out.println("=== 파일정보 ===");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.lastModified()); // 1971년때부터 측정한 ms
			System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified())));
			
			System.out.println("=== 전화번호 ===");
			
			// 1. 기반스트림
			FileInputStream fis = new FileInputStream(file);
			
			// 2. 보조스트림02(byte|byte|byte -> char)
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			
			// 3. 보조스트림03(char|char|char|\n -> "charcharchar")
			br = new BufferedReader(isr);
			
			// 4. 처리
			String line = null;
			while((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "\t ");
				
				int index = 0;
				while((st.hasMoreElements())) {
					String token = st.nextToken();
					
					if(index == 0) { // 이름
						System.out.print(token+":");
					} else if(index == 1) { // 전화번호1
						System.out.print(token+"-");
					} else if(index == 2) { // 전화번호2
						System.out.print(token+"-");
					} else if(index == 3) { // 전화번호3
						System.out.println(token);
					}
					index++;
				}
			}
		} catch (FileNotFoundException e) {
			// file을 활용한 로직을 짰기 때문에 필요없는 코드.
			// 부모 클래스인 IOException을 사용하는 것도 하나의 방법.
		} catch (UnsupportedEncodingException e) {
			System.out.println("error:"+ e);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
