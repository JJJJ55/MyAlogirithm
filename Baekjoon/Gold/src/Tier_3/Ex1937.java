package Tier_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1937 {
	static int n, arr[][],dp[][],max;
	static int di[] = {-1,1,0,0};
	static int dj[] = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		dp = new int[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				max = Math.max(max, dfs(i,j));
			}
		}
		System.out.println(max);
	}
	
	static int dfs(int i, int j) {
		if(dp[i][j]!=0) {
			return dp[i][j];
		}
		dp[i][j] = 1;
		
		for(int d=0;d<4;d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(ni>=0 && ni<n && nj>=0 && nj<n && arr[ni][nj]>arr[i][j]) {
				dp[i][j] = Math.max(dp[i][j], dfs(ni,nj)+1);
			}
		}
		return dp[i][j];
	}
}
