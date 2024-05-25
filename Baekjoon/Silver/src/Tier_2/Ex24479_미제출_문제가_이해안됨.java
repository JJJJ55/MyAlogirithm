package Tier_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex24479_미제출_문제가_이해안됨 {
	static int arr[][],num[], n,m,r, count;
	static List<Integer> list[];
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		list = new LinkedList[n+1];
		visit = new boolean[n+1];
		
		for(int i=1;i<=n;i++) {
			list[i] = new LinkedList<>();
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i=1;i<list.length;i++) {
			Collections.sort(list[i]);
		}
		
		num  = new int[n+1];
		num[r] = 1;
		visit[r] = true;
		count = 1;
//		dfs(r);
		System.out.println(0);
	}
	
//	static void dfs(int v) {
//		if(list[x].size()==0) return;
//		
//		for(int d=0;d<=list[i].size();d++) {
//			if(!visit[list[i].get(d)]) {
//				dfs(list[i].get(d));
//			}
//		}
//	}
}
