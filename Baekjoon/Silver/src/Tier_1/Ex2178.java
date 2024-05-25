package Tier_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex2178 {
	static int arr[][],n,m,cnt=1;
	static int min = Integer.MAX_VALUE;
	static boolean visit[][];
	static int di[] = {0,0,-1,1};
	static int dj[] = {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			char c[] = br.readLine().toCharArray();
			for(int j=0;j<c.length;j++) {
				arr[i][j] = c[j]-'0';
			}
		}
		
		bfs(0,0);
		System.out.println(min);
		
	}
	
	static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {i,j});
		visit[i][j] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s = 0;s<size;s++) {
				int info[] = q.poll();
				
				for(int d=0;d<4;d++) {
					int ni = info[0]+di[d];
					int nj = info[1]+dj[d];
					
					if(ni>=0 && ni<n && nj>=0 && nj<m && !visit[ni][nj] && arr[ni][nj]==1) {
						if(ni==n-1 && nj==m-1) {
							cnt++;
							min = Math.min(min, cnt);
						}
						q.offer(new int[] {ni,nj});
						visit[ni][nj] = true;
					}
				}
			}
			cnt++;
		}
	}
}
