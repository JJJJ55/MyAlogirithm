package Tier_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex11725 {
	static int n;
	static List<Integer> list[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		list = new List[n+1];
		int num[] = new int[n+1];
		for(int i=1;i<=n;i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=1;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		boolean visit[] = new boolean[n+1];
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.add(1);
		visit[1] = true;
		while(!q.isEmpty()) {
			int t = q.poll();
//			for(int node : list.get(t)) {
//				if(!visit[node]) {
//					visit[node] = true;
//					q.add(node);
//					num[node] = t;
//				}
//			}
			for(int i=0;i<list[t].size();i++) {
				int a = list[t].get(i);
				if(!visit[a]) {
					visit[a] = true;
					q.add(a);
					num[a] = t;
				}
			}
		}
		for(int i=2;i<=n;i++) {
			System.out.println(num[i]);
		}
	}
}
