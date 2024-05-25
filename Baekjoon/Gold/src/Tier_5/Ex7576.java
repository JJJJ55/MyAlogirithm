package Tier_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex7576 {
	static int arr[][],n,m,cnt=-1;
	static boolean visit[][];
	static int di[] = {0,0,-1,1};
	static int dj[] = {-1,1,0,0};
	
	static Queue<int[]> q = new ArrayDeque<int[]>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m][n];
		visit = new boolean[m][n];
		
		int si = 0;
		int sj = 0;
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					q.offer(new int[] {i,j});
					visit[i][j]=true;
				}
			}
		}
		
		bfs();
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]==0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(cnt);
	}
	
	static void bfs() {
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0;s<size;s++) {
				int info[] = q.poll();
				for(int d=0;d<4;d++) {
					int ni = info[0] + di[d];
					int nj = info[1] + dj[d];
					if(ni>=0 && ni<m && nj>=0 && nj<n && !visit[ni][nj] && arr[ni][nj]==0) {
						arr[ni][nj]=1;
						q.offer(new int[] {ni,nj});
						visit[ni][nj] = true;
					}
				}
			}
			cnt++;
		}
	}
}
