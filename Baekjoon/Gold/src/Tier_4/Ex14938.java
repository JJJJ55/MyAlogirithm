package Tier_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex14938 {
	static int n,m,r, item[],max;
	static List<map> list[];
	static int dist[];
	static class map implements Comparable<map>{
		int to;
		int dir;
		public map(int to, int dir) {
			super();
			this.to = to;
			this.dir = dir;
		}
		@Override
		public int compareTo(map o) {
			return this.dir - o.dir;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		list = new List[n+1];
		dist = new int[n+1];
		item = new int[n+1];
		for(int i=1;i<=n;i++) {
			list[i] = new ArrayList<map>();
			dist[i] = Integer.MAX_VALUE;
			item[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			list[from].add(new map(to,dis));
			list[to].add(new map(from,dis));
		}
		
		for(int i=1;i<=n;i++) {
			dik(i);
			int sum = 0;
			for(int j=1;j<=n;j++) {
				if(dist[j]!=Integer.MAX_VALUE) {
					sum+=item[j];
					dist[j] = Integer.MAX_VALUE;
				}
				max = Math.max(max, sum);
			}
		}

		System.out.println(max);
		
	}
	
	static void dik(int start) {
		PriorityQueue<map> q = new PriorityQueue<map>();
		boolean visit[] = new boolean[n+1];
		q.add(new map(start,0));
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			map cur = q.poll();
			if(!visit[cur.to]) {
				visit[cur.to] = true;
				for(map node : list[cur.to]) {
					if(!visit[node.to] && dist[node.to] > dist[cur.to]+node.dir
							&& dist[cur.to]+node.dir<=m) {
						dist[node.to] = dist[cur.to]+node.dir;
						q.add(new map(node.to, dist[node.to]));
					}
				}
			}
		}
	}
}
