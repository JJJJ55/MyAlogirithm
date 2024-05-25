package Tier_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex11724 {
	static int arr[][],n,m;
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][n+1];
		visit = new boolean[n+1];
		int count = 0;
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b]=arr[b][a]=1;
		}
		
		for(int i=1;i<=n;i++) {
			if(!visit[i]) {
				dfs(i);
				count++;
			}
		}
		System.out.println(count);
	}
	
	public static void dfs(int tmp) {
		if(visit[tmp]) {
			return;
		}
		
		visit[tmp] = true;
		for(int i=1;i<=n;i++) {
			if(arr[tmp][i]==1) {
				dfs(i);
			}
		}
	}
}
