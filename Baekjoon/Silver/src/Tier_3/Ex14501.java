package Tier_3;

import java.util.Scanner;

public class Ex14501 {
	static int n, arr[][],cnt=Integer.MIN_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		arr = new int[n][2];
		for(int i=0;i<n;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		dfs(0,0);
		
		System.out.println(cnt);
	}
	
	static void dfs(int idx, int sum) {
		if(idx>=n) {
			cnt = Math.max(cnt, sum);
			return;
		}
		
		int day = arr[idx][0];
		int price = arr[idx][1];
		if(idx+day<=n) {
			dfs(idx+day,sum+price);			
		}
		dfs(idx+1, sum);
	}
}
