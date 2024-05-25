package D2;

import java.util.Scanner;

public class Ex1989 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0;t<T;t++) {
			int n = 1;
			String str = sc.next();
			char c[] = str.toCharArray();
			
			for(int j=0;j<c.length/2;j++) {
				if(!(c[j]==c[c.length-1-j])) {
					n=0;
					break;
				}
			}
			System.out.printf("#%d %d\n",t+1,n);
		}
	}
}
