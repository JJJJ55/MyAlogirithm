package Tier_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int end;
	int weight;
	
	public Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}
}

public class Ex1753 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int k = Integer.parseInt(st.nextToken());
		
		boolean visit[] = new boolean[v+1];
		int result[] = new int[v+1];
		List<Node>[] list = new List[v+1];
		
		for(int i=1;i<=v;i++) {
			list[i] = new ArrayList<Node>();
			result[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to,weight));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		result[k] = 0;
		pq.add(new Node(k,0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(!visit[now.end]) visit[now.end] = true;
			for(int i=0;i<list[now.end].size();i++) {
				Node next = list[now.end].get(i);
				if(!visit[next.end] && now.weight+next.weight < result[next.end]) {
					result[next.end] = now.weight+next.weight;
					pq.add(new Node(next.end, result[next.end]));
				}
			}
		}
		
		for(int i=1;i<=v;i++) {
			if(result[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(result[i]);
			}
		}
		
	}
}
