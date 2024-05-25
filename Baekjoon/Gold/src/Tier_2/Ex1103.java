package Tier_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1103 {
	static int n,m,arr[][],dp[][],max;
	static boolean visit[][], flag;
	static int di[] = {-1,1,0,0};
	static int dj[] = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		dp = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			char c[] = br.readLine().toCharArray();
			for(int j=0;j<m;j++) {
				if(c[j]=='H') {
					arr[i][j] = 10;
				} else {
					arr[i][j] = c[j]-'0';
				}
			}
		}
		visit[0][0] = true;
		dfs(0,0,1);
		if(flag) {
			System.out.println(-1);
		}else {
			System.out.println(max);			
		}
		
	}
	
	static void dfs(int i, int j, int move) {
		if(move>max) {
			max = move;
		}
		dp[i][j] = move;
		for(int d=0;d<4;d++) {
			int ni = i+di[d] * (arr[i][j]);
			int nj = j+dj[d] * (arr[i][j]);
			
			if(ni>=0 && ni<n && nj>=0 && nj<m && arr[ni][nj]!=10) {
				if(visit[ni][nj]) {
					flag = true;
					return;
				}
				if(dp[ni][nj]>move) continue;
				visit[ni][nj] = true;
				dfs(ni,nj,move+1);
				visit[ni][nj] = false;
			}
		}
	}
}
