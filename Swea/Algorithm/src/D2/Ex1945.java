package D2;

import java.util.Scanner;

public class Ex1945 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int t=0;t<T;t++) {
			int n = sc.nextInt();
			
			int a = 0;
			int b = 0;
			int c = 0;
			int d = 0;
			int e = 0;
			
			while(n!=1) {
				if(n%2==0) {
					a++;
					n/=2;
				}				
				if(n%3==0) {
					b++;
					n/=3;
				}				
				if(n%5==0) {
					c++;
					n/=5;
				}				
				if(n%7==0) {
					d++;
					n/=7;
				}				
				if(n%11==0) {
					e++;
					n/=11;
				}
			}
			System.out.printf("#%d %d %d %d %d %d\n",t+1,a,b,c,d,e);
		}
	}
}
