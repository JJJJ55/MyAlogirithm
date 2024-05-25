package Tier_5;

import java.util.Scanner;

public class Ex27433 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextInt();
		
		System.out.println(func(n));
	}
	static long func(long n) {
		if(n==0 || n==1) {
			return 1;
		}
		return n * func(n-1);
	}
}
