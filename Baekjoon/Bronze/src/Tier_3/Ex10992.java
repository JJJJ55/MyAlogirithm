package Tier_3;

import java.util.Scanner;

public class Ex10992 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			if(i==n-1) {
				for(int j=0;j<2*(i+1)-1;j++) {
					System.out.print("*");
				}
				break;
			}
			for(int j=n-1;j>i;j--) {
				System.out.print(" ");
			}
			System.out.print("*");
			
			for(int j=0;j<2*i-1;j++) {
				System.out.print(" ");
			}
			if(i>=1) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
