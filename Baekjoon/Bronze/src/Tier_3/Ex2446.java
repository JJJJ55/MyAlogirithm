package Tier_3;

import java.util.Scanner;

public class Ex2446 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i=n;i>0;i--) {
			for(int j=0;j<n-i;j++) {
				System.out.print(" ");
			}
			for(int j=0;j<2*i-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=2;i<=n;i++) {
			for(int j=0;j<n-i;j++) {
				System.out.print(" ");
			}
			for(int j=0;j<2*i-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
