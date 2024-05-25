package Tier_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex18352 {
	static int n,m,k,x;
	static List<Integer> list[];
	static int dist[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		list = new List[n+1];
		dist = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			list[i] = new ArrayList<Integer>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
		}
		
		dik(x);
//		System.out.println(Arrays.toString(dist));
		for(int i =1;i<=n;i++) {
			if(dist[i]==k) {
				sb.append(i+"\n");
			}
		}
		
		System.out.println(sb.length()==0 ? -1 : sb);
	}
	
	static void dik(int x) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		boolean visit[] = new boolean[n+1];
		dist[x] = 0;
		q.offer(x);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(!visit[cur]) {
				visit[cur] = true;
				for(int a : list[cur]) {
					if(!visit[a] && dist[a] > dist[cur]+1) {
						dist[a] = dist[cur]+1;
						q.add(a);
					}
				}
			}
		}
	}
}
