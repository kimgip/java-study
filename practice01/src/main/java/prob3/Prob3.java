package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("숫자를 입력하세요: ");
        int num = scanner.nextInt();
        
        scanner.close();

        int res = 0;
        int i = 1;
        if (num % 2 == 0) {
            i = 2;   
        }

        for (; i <= num; i += 2) {
            res += i;
        }

        System.out.println("결과 값 : "+res);
	}
}
