package Tier_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex2206 {
	static int arr[][], n,m;
	static int min = Integer.MAX_VALUE;
	static boolean visit[][][];
	static int di[] = {0,0,-1,1};
	static int dj[] = {-1,1,0,0};
	
	static class pp{
		int i,j,cnt;
		boolean flag;
		
		public pp(int i,int j, int cnt, boolean flag) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
			this.flag = flag;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][m+1];
		visit = new boolean[2][n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			char c[] = br.readLine().toCharArray();
			for(int j=1;j<=c.length;j++) {
				arr[i][j] = c[j-1]-'0';
			}
		}
		
		bfs(1,1);
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}
	
	static void bfs(int i, int j) {
		Queue<pp> q = new ArrayDeque<pp>();
		q.offer(new pp(i,j,1, true));
		visit[0][i][j] = true;
		visit[1][i][j] = true;
		
		while(!q.isEmpty()) {
			pp tmp = q.poll();
			for(int d=0;d<4;d++) {
				int ni = tmp.i + di[d];
				int nj = tmp.j + dj[d];
				
				if(tmp.i==n && tmp.j==m) {
					min = Math.min(min, tmp.cnt);
				}
				
				if(ni>=1 && ni<=n && nj>=1 && nj<=m && !visit[tmp.flag ? 0 : 1][ni][nj]) {
					if(arr[ni][nj]==1 && tmp.flag) {
						q.offer(new pp(ni,nj,tmp.cnt+1, !tmp.flag));
						visit[tmp.flag ? 0 : 1][ni][nj] = true;
					}else if(arr[ni][nj]==0) {
						q.offer(new pp(ni,nj,tmp.cnt+1, tmp.flag));
						visit[tmp.flag ? 0 : 1][ni][nj] = true;
					}
				}
			}
		}
	}
}
