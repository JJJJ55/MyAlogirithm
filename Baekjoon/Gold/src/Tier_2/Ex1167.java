package Tier_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex1167 {
	static int v,max,far;
	static List<data> list[];
	static boolean visit[];
	static class data{
		int to;
		int cost;
		public data(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		v = Integer.parseInt(br.readLine());
		
		list = new List[v+1];
		for(int i=1;i<=v;i++) {
			list[i] = new ArrayList<data>();
		}
		
		for(int i=0;i<v;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				int to = Integer.parseInt(st.nextToken());				
				if(to == -1) {
					break;
				}
				int cost = Integer.parseInt(st.nextToken());
				list[from].add(new data(to,cost));
			}
		}
		visit = new boolean[v+1];
		dfs(1,0);
		
		visit = new boolean[v+1];
		dfs(far,0);
		
		System.out.println(max);
	}
	
	static void dfs(int idx, int cnt) {
		if(max<cnt) {
			max = cnt;
			far = idx;
		}
		
		visit[idx] = true;
		for(data node : list[idx]) {
			if(!visit[node.to]) {
				dfs(node.to,cnt+node.cost);
			}
		}
	}
}
