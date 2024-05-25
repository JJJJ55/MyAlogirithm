package Tier_5;

import java.util.Scanner;

public class Ex11729 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sb.append((int)Math.pow(2, n)-1).append("\n");
		func(n,1,2,3);
		
		System.out.println(sb);
	}
	static void func(int n, int start, int mid, int to) {
		if(n==1) {
			sb.append(start+" "+to).append("\n");
			return;
		}
		
		func(n-1, start, to, mid);
		
		sb.append(start+" "+to).append("\n");
		
		func(n-1,mid,start,to);
	}
}
