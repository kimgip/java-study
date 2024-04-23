package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };
		
		System.out.print("금액: ");
		int n = scanner.nextInt();
		int d;
        for (int coin : MONEYS) {
            if (n == 0) {
                break;
            }
            d = n / coin;
            n = n % coin;
            System.out.println(coin + "원:" + d +"개");
        }
		
		scanner.close();
 	}
}