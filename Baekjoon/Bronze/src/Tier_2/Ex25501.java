package Tier_2;

import java.util.Scanner;

public class Ex25501 {
	static int cnt = 1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n =sc.nextInt();
		
		for(int i=0;i<n;i++) {
			cnt = 1;
			char c[] = sc.next().toCharArray();
			System.out.println(recursion(c, 0, c.length-1,cnt)+" "+cnt);
		}
	}
	static int recursion(char c[],int l, int r, int n) {
		if(l>=r) {
			cnt = n;
			return 1;
		}
		else if(c[l] != c[r]) {
			cnt = n;
			return 0;
		}
		else return recursion(c,l+1,r-1,n+1);
	}
}
