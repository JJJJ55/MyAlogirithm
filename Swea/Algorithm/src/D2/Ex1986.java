package D2;

import java.util.Scanner;

public class Ex1986 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=0;t<T;t++) {
			int n = sc.nextInt();
			
			int sum = 0;
			for(int i=1;i<=n;i++) {
				if(i%2==0) {
					sum-=i;
				} else {
					sum+=i;
				}
			}
			System.out.printf("#%d %d\n",t+1,sum);
		}
	}
}
