package Tier_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex1325서버이상해 {
	static int n,m,max;
	static List<Integer> list[];
	static int num[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new List[n+1];
		num = new int[n+1];
		for(int i=1;i<=n;i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[to].add(from);
		}
		
		for(int i=1;i<=n;i++) {
			int cnt = bfs(i);
			num[i] = cnt;
			max = Math.max(max, cnt);
		}
		
		for(int i=1;i<=n;i++) {
			if(num[i]==max) {
				System.out.print(i+" ");
			}
		}
		
	}
	
	static int bfs(int i) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		boolean visit[] = new boolean[n+1];
		q.add(i);
		visit[i] = true;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int com = q.poll();
			for(int c : list[com]) {
				if(!visit[c]) {
					cnt++;
					visit[c] = true;
					q.add(c);
				}
			}
		}
		
		return cnt;
	}
}
