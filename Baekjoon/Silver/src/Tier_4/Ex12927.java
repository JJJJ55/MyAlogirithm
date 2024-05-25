package Tier_4;

import java.util.Scanner;

public class Ex12927 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		int count = 1;
		char c[] = new char[str.length()];
		int n = 0;
		
		for(int i=0;i<str.length();i++) {
			c[i]=str.charAt(i);
		}

		while(true) {
			for(int i=0;i<c.length;i++) {
				if(c[i]=='Y') {
					n = i+1;
					break;
				}
			}
			
			if(n==0) {
				System.out.println(0);
				return;
			}
			
			for(int i=n;i<=str.length();i++) {
				if(i%n==0) {
					if(c[i-1]=='Y') {
						c[i-1]='N';
					} else {
						c[i-1]='Y';
					}
				}
			}
			int point = 0;
			for(int i=0;i<c.length;i++) {
				if(c[i]=='N') {
					point++;
				}
			}
			if(point == str.length()) {
				System.out.println(count);
				return;
			} else {
				count++;
			}
		}
	}
}
