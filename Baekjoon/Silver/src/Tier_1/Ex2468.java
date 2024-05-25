package Tier_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex2468 {
	static int arr[][],n,cnt;
	static int di[] = {-1,1,0,0};
	static int dj[] = {0,0,-1,1};
	static boolean visit[][];
	static int max = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int t=0;t<=100;t++) {
			visit = new boolean[n][n];
			cnt = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(arr[i][j]>t && !visit[i][j]) {
						bfs(i,j,t);
						cnt++;
					}
				}
			}
			if(cnt==0) break;
			max = Math.max(max, cnt);
		}
		System.out.println(max);
		
	}
	
	static void bfs(int i, int j,int t) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {i,j});
		visit[i][j] = true;
		
		while(!q.isEmpty()) {
			int info[] = q.poll();
			for(int d=0;d<4;d++) {
				int ni = info[0]+di[d];
				int nj = info[1]+dj[d];
				
				if(ni>=0 && ni<n && nj>=0 &&nj<n && !visit[ni][nj] && arr[ni][nj]>t) {
					q.offer(new int[] {ni,nj});
					visit[ni][nj] = true;
				}
			}
		}
	}
}
