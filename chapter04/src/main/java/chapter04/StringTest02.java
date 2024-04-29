package chapter04;

public class StringTest02 {

	public static void main(String[] args) {
		// immutability(불변성)
		
		String s1 = "abc";
		String s2 = "def";
		String s3 = s2;
		
		// 새로운 객체를 생성해서 리턴하는 메서드들
		s2 = s1.toUpperCase();
		String s4 = s2.concat("??");
		String s5 = "!".concat(s2).concat("@");
				
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.err.println(s5);
		
		System.out.println(equalsHello("hello"));
		System.out.println(equalsHello(null));
	}

	private static boolean equalsHello(String string) {
		return "hello".equals(string); // string.equals("hello") 라면, 변수에 null값이 들어왔을 때 곤란.
	}

}
