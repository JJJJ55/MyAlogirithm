package Tier_1;

import java.util.Scanner;

public class Ex24416 {
	static long cnt1, cnt2;
	static long memo[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		memo = new long[n+1];
		
		fib1(n);
		fib2(n);
		System.out.println(cnt1+1+" "+cnt2);
	}
	
	static long fib1(int n) {
		if(n==1 || n==2) {
			return 1;
		} else {
			cnt1++;
			return fib1(n-1) + fib1(n-2);
		}
	}
	
	static long fib2(int n) {
		memo[1] = memo[2] = 1;
		for(int i=3;i<=n;i++) {
			cnt2++;
			memo[i] = memo[i-1]+memo[i-2];
		}
		return memo[n];
	}
}
