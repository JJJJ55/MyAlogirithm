package Tier_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex1504 {
	static int v,e;
	static List<Node>[] list;
	static int[] result;
	static boolean[] visit;
	static int INF;
	
	static class Node implements Comparable<Node>{
		int end, weight;
		
		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		INF = 200000000;
		
		st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		list = new List[v+1];
		result = new int[v+1];
		
		for(int i=1;i<=v;i++) {
			list[i] = new ArrayList<Node>();
		}
		
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to,weight));
			list[to].add(new Node(from,weight));
		}
		st = new StringTokenizer(br.readLine());
		
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int dis1 = 0;
		dis1 += dik(1,v1);
		dis1 += dik(v1,v2);
		dis1 += dik(v2, v);
		
		int dis2 = 0;
		dis2 += dik(1,v2);
		dis2 += dik(v2,v1);
		dis2 += dik(v1, v);
		
		int cnt = (dis1 >= INF && dis2 >= INF) ? -1 : Math.min(dis1, dis2);
		System.out.println(cnt);
	}
	
	static int dik(int from, int to) {
		visit = new boolean[v+1];
		Arrays.fill(result, INF);
		Arrays.fill(visit, false);
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(from,0));
		result[from] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(!visit[now.end]) {
				visit[now.end] = true;
				
				for(int i=0;i<list[now.end].size();i++) {
					Node next = list[now.end].get(i);
					if(!visit[next.end] && result[next.end] > result[now.end]) {
						result[next.end] = result[now.end] + next.weight;
						pq.add(new Node(next.end, result[next.end]));
					}
				}
			}
		}
		return result[to];
	}
}
