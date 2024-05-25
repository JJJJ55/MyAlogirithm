package Tier_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex2589 {
	static char arr[][];
	static int n,m,max;
	static int di[] = {-1,1,0,0};
	static int dj[] = {0,0,-1,1};
	
	static class p{
		int i;
		int j;
		int cnt;
		public p(int i, int j, int cnt) {
			super();
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new char[n][m];
		
		for(int i=0;i<n;i++) {
			char c[] = br.readLine().toCharArray();
			for(int j=0;j<m;j++) {
				arr[i][j] = c[j];
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]=='L') {
					bfs(i,j);
				}
			}
		}
		System.out.println(max);
		
	}
	
	static void bfs(int i, int j) {
		Queue<p> q = new ArrayDeque<p>();
		boolean visit[][] = new boolean[n][m];
		q.add(new p(i,j,0));
		visit[i][j] = true;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0;s<size;s++) {
				p info = q.poll();
				for(int d=0;d<4;d++) {
					int ni = info.i+di[d];
					int nj = info.j+dj[d];
					if(ni>=0 && ni<n && nj>=0 && nj<m && !visit[ni][nj] && arr[ni][nj]=='L') {
						visit[ni][nj] = true;
						q.add(new p (ni,nj,info.cnt+1));
						max = Math.max(info.cnt+1, max);
					}
				}
			}
		}
	}
}
