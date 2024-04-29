package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
		String s1 = "Hello " + "World" + " java " + 17;
		String s2 = new StringBuffer("Hello ")
					.append("World")
					.append(" java ")
					.append(17)
					.toString();
		
		String s3 = new StringBuilder("Hello ")
				.append("World")
				.append(" java ")
				.append(17)
				.toString();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		String s4 ="";
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < 1000000; i++) {
			// 매우 느림
			// lock과 unlock의 반복 때문
			// 언어가 불변 객체와 functional(순수함수)로 가고 있는 이유
//			s4 += "h";
//			s4 = new StringBuffer(s4).append("h").toString();
			
			// 빠름
			// 따라서 많은 반복을 하는 경우 StringBuffer 사용
			sb.append("h");
		}
		String s5 = sb.toString();
		
		// String method들...
		String s6 = "aBcABCabcAbc";
		System.out.println(s6.length());
		System.out.println(s6.charAt(2));
		System.out.println(s6.indexOf("abc"));
		System.out.println(s6.indexOf("abc", 7));
		System.out.println(s6.substring(3));
		System.out.println(s6.substring(3, 5));
		String s7 = "         ab       cd         ";
		String s8 = "efg,hij,klm,nop,qrs";
		
		String s9 = s7.concat(s8);
		System.out.println(s9);
		
		System.out.println("-----" + s7.trim() + "-----");
		System.out.println("-----" + s7.replaceAll(" ", "") + "-----");
		
		String[] tokens = s8.split(",");
		for (String s: tokens) {
			System.out.println(s);
		}
		
		String[] tokens2 = s8.split(" ");
		for (String s: tokens2) {
			System.out.println(s);
		}
		System.out.println("end");
	}

}
