package D2;

import java.util.Scanner;

public class Ex1976 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0;t<T;t++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int m1 = sc.nextInt();
			int m2 = sc.nextInt();
			
			int s1 = n1+m1;
			int s2 = n2+m2;
			
			if(s1>12) {
				s1=s1%12;
			}
			
			if(s2>=60) {
				s1+=s2/60;
				s2=s2%60;
			}
			System.out.printf("#%d %d %d\n",t+1,s1,s2);
		}
	}
}
