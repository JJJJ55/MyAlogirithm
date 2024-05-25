package Tier_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex9466 {
	static int arr[], n, cnt;
	static boolean visit[],finish[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=0;t<TC;t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n+1];
			visit = new boolean[n+1];
			finish = new boolean[n+1];
			cnt = 0;
			st = new StringTokenizer(br.readLine());
			
			for(int i=1;i<=n;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			for(int i=1;i<=n;i++) {
				if(!finish[i]) {
					dfs(i);
				}
			}
			System.out.println(n-cnt);
		}
	}
	
	static void dfs(int tmp) {
		if(visit[tmp]) {
			finish[tmp] = true;
			cnt++;
		} else {
			visit[tmp] = true;
		}
		
		if(!finish[arr[tmp]]) {
			dfs(arr[tmp]);
		}
		visit[tmp] = false;
		finish[tmp] = true;
	}
}
