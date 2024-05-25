package Tier_4;

import java.util.Scanner;

public class Ex4134 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=0;i<T;i++) {
			long n = sc.nextLong();
			if(n==0 || n==1 || n==2) {
				System.out.println(2);
				continue;
			}
			while(true) {
				int result = 0;
				for(long j=2;j<=Math.sqrt((double)n);j++) {
					if(n%j==0) {
						result++;
						break;
					} 
				}
				if(result ==0) {
					System.out.println(n);
					break;
				}
				n++;
			}
		}
	}

}
