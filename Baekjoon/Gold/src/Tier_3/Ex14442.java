package Tier_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex14442 {
	static int arr[][],n,m,k;
	static boolean visit[][][];
	static int min = Integer.MAX_VALUE;
	static int di[] = {-1,1,0,0};
	static int dj[] = {0,0,-1,1};
	
	static class target{
		int i,j,k,time;

		public target(int i, int j, int k, int time) {
			super();
			this.i = i;
			this.j = j;
			this.k = k;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visit = new boolean[k+1][n][m];
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<m;j++) {
				arr[i][j] = s.charAt(j)-'0';
			}
		}
		
		bfs(0,0,0);
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);			
		}
	}
	
	static void bfs(int i, int j, int kk) {
		Queue<target> q = new ArrayDeque<target>();
		q.offer(new target(i,j,kk,1));
		visit[kk][i][j] = true;
		
		while(!q.isEmpty()) {
			target t = q.poll();
			
			if(t.i == n-1 && t.j ==m-1) {
				min = Math.min(min, t.time);
				continue;
			}
			
			for(int d=0;d<4;d++) {
				int ni = t.i+di[d];
				int nj = t.j+dj[d];
				
				if(ni>=0 && ni<n && nj>=0 && nj<m && !visit[t.k][ni][nj]) {
					if(arr[ni][nj]==1 && t.k<k) {
						q.offer(new target(ni,nj,t.k+1,t.time+1));
						visit[t.k+1][ni][nj] = true;
					}
					if(arr[ni][nj]==0) {
						q.offer(new target(ni,nj,t.k,t.time+1));
						visit[t.k][ni][nj] = true;
					}
				}
			}
			
		}
	}
}
