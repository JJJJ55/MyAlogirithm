package Tier_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex13023 {
	static int n,m;
	static ArrayList<Integer> list[];
	static boolean v[];
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n];
		v = new boolean[n];
		for(int i=0;i<n;i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i=0;i<n;i++) {
			if(ans==0) {
				dfs(i,1);
			}
		}
		System.out.println(ans);
	}
	
	static void dfs(int start, int dep) {
		if(dep==5) {
			ans=1;
			return;
		}
		v[start] = true;
		for(int i: list[start]) {
			int next = i;
			if(!v[next]) {
				dfs(next,dep+1);
			}
		}
		v[start] = false;
	}
}
