package Tier_3;

import java.util.Scanner;

public class Ex2523 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			for(int j=0;j<i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=1;i<=n-1;i++) {
			for(int j=i;j<n;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
