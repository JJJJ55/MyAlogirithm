package Tier_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex14940 {
	static int n,m,arr[][],ans[][];
	static int si,sj;
	static int di[] = {-1,1,0,0};
	static int dj[] = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		ans = new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==2) {
					si = i;
					sj = j;
				}
			}
		}
		
		bfs(si,sj);
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]!=0 && ans[i][j]==0) {
					ans[i][j] = -1;
				}
			}
		}
		ans[si][sj] = 0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		boolean visit[][] = new boolean[n][m];
		q.add(new int[] {i,j});
		visit[i][j] = true;
		int time = 1;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0;s<size;s++) {
				int info[] = q.poll();
				
				for(int d=0;d<4;d++) {
					int ni = info[0]+di[d];
					int nj = info[1]+dj[d];
					if(ni>=0 &&  ni<n && nj>=0 && nj<m && !visit[ni][nj] && arr[ni][nj]==1) {
						visit[ni][nj] = true;
						ans[ni][nj] = time;
						q.add(new int[] {ni,nj});
					}
				}
			}
			time++;
		}
	}
}
