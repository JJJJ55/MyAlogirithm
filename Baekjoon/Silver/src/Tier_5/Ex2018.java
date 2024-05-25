package Tier_5;

import java.util.Scanner;

public class Ex2018 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int sum = 1;
		int cnt = 1;
		for(int si=1, ei=1;si<=n/2;) {
			if(sum<n) {
				sum+=++ei;
			}else if(sum>n) {
				sum-=si++;
			} else {
				cnt++;
				sum-=si++;
			}
			
		}
		System.out.println(cnt);
		
		
	}
}
