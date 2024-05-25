package Tier_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1043 {
	static int n,m;
	static boolean[] know;
	static boolean[][] connect;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		know = new boolean[n+1];
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());

		for(int i=0;i<t;i++) {
			know[Integer.parseInt(st.nextToken())] = true;
		}
		connect = new boolean[n+1][n+1];
		int[][] party = new int[m][];
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int pnt = Integer.parseInt(st.nextToken());
			party[i] = new int[pnt];
			party[i][0] = Integer.parseInt(st.nextToken());
			for(int j=1;j<pnt;j++) {
				party[i][j] = Integer.parseInt(st.nextToken());
				connect[party[i][j-1]][party[i][j]] = connect[party[i][j]][party[i][j-1]] = true;
			}
		}
		
		for(int i=1;i<=n;i++) {
			if(know[i]) {
				dfs(i);
			}
		}
		int ans = 0;
		for(int i=0;i<m;i++) {
			if(!know[party[i][0]]) {
				ans++;
			}
		}
		System.out.println(ans);
	}
	
	static void dfs(int x) {
		for(int i=1;i<=n;i++) {
			if(connect[x][i] && !know[i]) {
				know[i] = true;
				dfs(i);
			}
		}
	}
}
