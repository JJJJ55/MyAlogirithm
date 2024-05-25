package D2;

import java.util.Scanner;

public class Ex1940 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int t=0;t<T;t++) {
			int n = sc.nextInt();
			
			int sum = 0;
			int tmp1 = 0;
			
			for(int i=0;i<n;i++) {
				int n1 = sc.nextInt();
				switch (n1) {
				case 0: 
					sum+=tmp1;
					break;
				case 1: 
					int a = sc.nextInt();
					tmp1 += a;
					sum+=tmp1;
					break;
				case 2: 
					int b = sc.nextInt();
					tmp1 += -b;
					if(tmp1<0) {
						tmp1 = 0;
					}
					sum+=tmp1;

					break;
				}
			}
			System.out.printf("#%d %d\n",t+1,sum);
		}
	}
}
