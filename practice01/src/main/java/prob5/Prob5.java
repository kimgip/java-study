package prob5;

public class Prob5 {

	public static void main(String[] args) {
		int cnt, r, num;
        for (int i = 3; i < 100; i++) {
        	cnt = 0;
        	num = i;
            while (num > 0) {
            	r = num % 10;
            	if (r > 0 & r % 3 == 0) {
            		cnt++;
            	}
            	num /= 10;
            }
            if (cnt > 0) {
                System.out.print(i + " ");
                
                for (int j = 0; j < cnt; j++) {
                    System.out.print("짝");
                }
                System.out.println();
            }
        }
	}
}
