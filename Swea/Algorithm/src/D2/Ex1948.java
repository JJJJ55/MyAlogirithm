package D2;

import java.util.Scanner;

public class Ex1948 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int m[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		for (int t = 0; t < T; t++) {
			int m1 = sc.nextInt()-1;
			int d1 = sc.nextInt();
			int m2 = sc.nextInt()-1;
			int d2 = sc.nextInt();
			
			int sum1 = 0;
			int sum2 = 0;
			
			for(int i=0;i<m1;i++) {
				sum1+=m[i];
			}
			for(int i=0;i<m2;i++) {
				sum2+=m[i];
			}
			System.out.printf("#%d %d\n",t+1,(sum2+d2)-(sum1+d1)+1);
		}
	}
}
