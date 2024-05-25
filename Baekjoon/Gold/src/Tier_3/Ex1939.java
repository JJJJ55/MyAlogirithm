package Tier_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex1939 {
	static int n,m,f1,f2;
	static int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
	static List<data> list[];
	static class data{
		int to;
		int cost;
		public data(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new List[n+1];
		for(int i=1;i<=n;i++) {
			list[i] = new ArrayList<data>();
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list[from].add(new data(to,cost));
			list[to].add(new data(from,cost));
			
			low = Math.min(low, cost);
			high = Math.max(high, cost);
			
		}
		st = new StringTokenizer(br.readLine());
		f1 = Integer.parseInt(st.nextToken());
		f2 = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		while(low<=high) {
			int middle = (low+high)/2;
			if(bfs(middle)) {
				low = middle+1;
				ans = middle;
			} else {
				high = middle-1;
			}
		}
		System.out.println(ans);
	}
	
	static boolean bfs(int w) {
		Queue<data> q = new ArrayDeque<data>();
		boolean visit[] = new boolean[n+1];
		q.add(new data(f1,0));
		while(!q.isEmpty()) {
			data d = q.poll();
			
			if(d.to == f2) {
				return true;
			}
			for(data next : list[d.to]) {
				if(w<=next.cost && !visit[next.to]) {
					visit[next.to] = true;
					q.add(next);
				}
			}
		}
		return false;
	}
}
