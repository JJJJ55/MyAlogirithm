package Tier_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex1926 {
	static int arr[][],n,m,cnt;
	static int max = 0;
	static boolean visit[][];
	static int di[] = {-1,1,0,0};
	static int dj[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==1 && !visit[i][j]) {
					bfs(i,j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max);
	}
	
	static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {i,j});
		visit[i][j] = true;
		int count = 0;
		
		while(!q.isEmpty()) {
			int info[] = q.poll();
			count++;
			for(int d=0;d<4;d++) {
				int ni = info[0]+di[d];
				int nj = info[1]+dj[d];
				
				if(ni>=0 && ni<n && nj>=0 && nj<m && !visit[ni][nj] && arr[ni][nj]==1) {
					q.offer(new int[] {ni,nj});
					visit[ni][nj] = true;
				}
			}
			
		}
		max = Math.max(max, count);
	}
}
