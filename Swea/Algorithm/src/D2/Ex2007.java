package D2;

import java.util.Scanner;

public class Ex2007 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int i=0;i<t;i++) {
			String str = sc.next();
			for(int j=1;j<=str.length();j++) {
				String s1 = str.substring(0, j);
				String s2 = str.substring(j, j+j);
				
				if(s1.equals(s2)) {
					System.out.printf("#%d %d\n",i+1,j);
					break;
				}
			}
		}
	}
}
