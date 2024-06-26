package Tier_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex2458 {
	static int n,m,ans;
	static List<Integer> list[],list2[];
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new List[n+1];
		list2 = new List[n+1];
		
		for(int i=1;i<=n;i++) {
			list[i] = new ArrayList<Integer>();
			list2[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list2[to].add(from);
			
		}
		
		for(int i=1;i<=n;i++) {
			int cnt = bfs1(i);
			cnt+=bfs2(i);
			if(cnt==n-1) {
				ans++;
			}
		}
		System.out.println(ans);
	}
	static int bfs1(int i) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		boolean visit[] = new boolean[n+1];
		q.add(i);
		visit[i] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			int info = q.poll();
			for(int x : list[info]) {
				if(!visit[x]) {
					visit[x] = true;
					q.add(x);
					cnt++;
				}
			}
		}
		return cnt;
	}
	static int bfs2(int i) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		boolean visit[] = new boolean[n+1];
		q.add(i);
		visit[i] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			int info = q.poll();
			for(int x : list2[info]) {
				if(!visit[x]) {
					visit[x] = true;
					q.add(x);
					cnt++;
				}
			}
		}
		return cnt;
	}
}
