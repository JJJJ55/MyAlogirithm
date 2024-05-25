package Tier_3;

import java.util.Scanner;

public class Ex2445 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = n; i > 1; i--) {
			for (int j = 0; j < n - i+1; j++) {
				System.out.print("*");
			}
			for (int j = 1; j < 2 * i - 1; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < n - i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=0;i<n*2;i++) {
			System.out.print("*");
		}
		System.out.println();
		for (int i = 2; i <=n; i++) {
			for (int j = 0; j < n - i+1; j++) {
				System.out.print("*");
			}
			for (int j = 1; j < 2 * i - 1; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < n - i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}


	}
}
