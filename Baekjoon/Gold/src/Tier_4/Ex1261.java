package Tier_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex1261 {
	static int arr[][],n,m;
	static int di[] = {-1,1,0,0};
	static int dj[] = {0,0,-1,1};
	static int dist[][];
	
	static class miro implements Comparable<miro>{
		int i;
		int j;
		int cnt;
		public miro(int i, int j, int cnt) {
			super();
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(miro o) {
			return this.cnt - o.cnt;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m][n];
		dist = new int[m][n];
		
		for(int i=0;i<m;i++) {
			char c[] = br.readLine().toCharArray();
			for(int j=0;j<n;j++) {
				arr[i][j] = c[j]-'0';
			}
		}
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		bfs(0,0);
		
		System.out.println(dist[m-1][n-1]);
	}
	
	static void bfs(int i, int j) {
		PriorityQueue<miro> q = new PriorityQueue<miro>();
		dist[i][j] = 0;
		q.add(new miro(i,j,0));
		while(!q.isEmpty()) {
			miro mi = q.poll();
			for(int d=0;d<4;d++) {
				int ni = mi.i+di[d];
				int nj = mi.j+dj[d];
				int cnt = mi.cnt;
				if(ni>=0 && ni<m && nj>=0 && nj<n) {
					if(arr[ni][nj]==1) {
						cnt++;
					}
					if(dist[ni][nj] > cnt) {
						dist[ni][nj] = cnt;
						q.offer(new miro(ni,nj,cnt));
					}
				}
			}
		}
	}
}
