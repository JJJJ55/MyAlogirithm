package Tier_5;

import java.util.Scanner;

public class Ex2023 {
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		dfs(0,n);
	}
	
	static void dfs(int idx, int n) {
		if(n==0) {
			System.out.println(idx);
		}
		for(int i=1;i<10;i++) {
			int tmp = 10*idx+i;
			if(n>0 && isPrime(tmp)) {
				dfs(tmp,n-1);
			}
		}
	}
	
	static boolean isPrime(int num) {
		if(num<2) return false;
		for(int i=2;i*i<=num;i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}
}
