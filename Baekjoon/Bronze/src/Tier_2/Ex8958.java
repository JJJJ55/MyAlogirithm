package Tier_2;

import java.util.Scanner;

public class Ex8958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();

		for(int T=0;T<t;T++) {
			int sum = 0;
			int ans = 0;
			String str = sc.next();
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)=='O') {
					ans++;
					sum+=ans;
				} else {
					ans = 0;
				}
			}
			System.out.println(sum);
		}
	}
}
