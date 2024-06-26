package Tier_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1520 {
	static int arr[][],n,m,cnt;
	static int di[] = {-1,1,0,0};
	static int dj[] = {0,0,-1,1};
	static boolean visit[][];
	static int dp[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visit = new boolean[n][m];
		dp = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println(dfs(0,0));
	}
	
	static int dfs(int x,int y) {
		if(x==n-1 && y==m-1) {
			return 1;
		}
		
		if(dp[x][y]!=-1) {
			return dp[x][y];
		}
		
		dp[x][y] = 0; //지금 시점에서 끝점까지 갈 수 있는 경로 0으로 초기화
		
		for(int d=0;d<4;d++) {
			int ni = x+di[d];
			int nj = y+dj[d];
			if(ni>=0 && ni<n && nj>=0 && nj<m && arr[x][y]>arr[ni][nj]) {
				dp[x][y]+=dfs(ni,nj);
			}
		}
		return dp[x][y];
	}
}
