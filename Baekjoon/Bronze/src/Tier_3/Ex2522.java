package Tier_3;

import java.util.Scanner;

public class Ex2522 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i=1;i<=2*n-1;i++) {
			if(i<=n) {
				for(int j=0;j<n-i;j++) {
					System.out.print(" ");
				}
				for(int j=0;j<i;j++) {
					System.out.print("*");
				}
				System.out.println();
			} else {
				for(int j=0;j<i-n;j++) {
					System.out.print(" ");
				}
				for(int j=i-n;j<n;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}
}
