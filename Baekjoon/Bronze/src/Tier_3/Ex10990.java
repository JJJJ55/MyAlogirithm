package Tier_3;

import java.util.Scanner;

public class Ex10990 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			for(int j=0;j<n-i;j++) {
				System.out.print(" ");
			}
			System.out.print("*");
			if(i!=1) {
				for(int j=i-1;j<i;j++) {	
					for(int z=0;z<2*(i-1)-1;z++) {
						System.out.print(" ");
					}
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}
