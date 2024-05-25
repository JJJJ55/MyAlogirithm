package Tier_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex10282 {
	static int n,d,c;
	static int cnt, time;
	static List<com> list[];
	static int dist[];
	
	static class com implements Comparable<com>{
		int to;
		int time;
		public com(int to, int time) {
			super();
			this.to = to;
			this.time = time;
		}
		@Override
		public int compareTo(com o) {
			return this.time - o.time;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=0;t<TC;t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			list = new List[n+1];
			dist = new int[n+1];
			for(int i=1;i<=n;i++) {
				dist[i] = Integer.MAX_VALUE;
				list[i] = new ArrayList<com>();
			}
			
			for(int i=0;i<d;i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				list[to].add(new com(from,time));
//				list[from].add(new com(to,time));
			}
			
			cnt = 0;
			time = 0;
			dik(c);
			for(int i=1;i<=n;i++) {
				if(dist[i]!=Integer.MAX_VALUE) {
					cnt++;
					time = Math.max(time, dist[i]);
				}
			}
			System.out.println(cnt+" "+time);
		}
	}
	
	static void dik(int start) {
		PriorityQueue<com> q = new PriorityQueue<com>();
		boolean visit[] = new boolean[n+1];
		q.add(new com(start,0));
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			com cur = q.poll();
			if(!visit[cur.to]) {
				visit[cur.to] = true;
				for(com next : list[cur.to]) {
					if(!visit[next.to] && dist[next.to] > dist[cur.to]+next.time) {
						dist[next.to] = dist[cur.to]+next.time;
						q.add(new com(next.to,dist[next.to]));
					}
				}
			}
		}
	}
}
