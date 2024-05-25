package Tier_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Ex2668 {
	static int n,arr[];
	static boolean visit[];
	static ArrayList<Integer> ans = new ArrayList<Integer>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		visit = new boolean[n+1];
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=1;i<=n;i++) {
			dfs(i,i);
		}
		
		Collections.sort(ans);
		System.out.println(ans.size());
		for(int i : ans) {
			System.out.println(i);
		}
		
	}
	
	static void dfs(int x, int start) {
		if(arr[x]==start) {
			ans.add(x);
			return;
		}
		if(!visit[arr[x]]) {
			visit[arr[x]] = true;
			dfs(arr[x],start);
			visit[arr[x]] = false;
		}
	}
}
