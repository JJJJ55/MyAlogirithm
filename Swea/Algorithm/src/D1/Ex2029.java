package D1;

import java.util.Scanner;

public class Ex2029 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0;t<T;t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.printf("#%d %d %d\n",t+1,a/b,a%b);
		}
	}
}
