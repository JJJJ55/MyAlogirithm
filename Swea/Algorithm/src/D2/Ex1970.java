package D2;

import java.util.Scanner;

public class Ex1970 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int money[] = {50000,10000,5000,1000,500,100,50,10};
		for(int t=0;t<T;t++) {
			int n =sc.nextInt();
			
			System.out.printf("#%d\n",t+1);
			for(int j=0;j<money.length;j++) {
				System.out.printf("%d ",n/money[j]);
				n%=money[j];
			}
			System.out.println();
		}
	}
}
