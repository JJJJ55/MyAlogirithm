package Tier_1;

import java.util.Scanner;

public class Ex1629 {
	static int c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		c = sc.nextInt();
		
		long result = func(a,b);
		System.out.println(result);
	}
	
	static long func(int a, int b) {
		if(b==1) {
			return a % c;
		}
		
		long tmp = func(a,b/2);
		
		if(b%2==1) {
			return (tmp*tmp % c) * a % c;
		}
		return tmp*tmp % c;
	}
}
