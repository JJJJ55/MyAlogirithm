package Tier_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex2573 {
	static int arr[][],n,m,cnt,time;
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
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			cnt = 0;
			visit = new boolean[n][m];
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(arr[i][j]!=0) {
						melt(i,j);
						visit[i][j] = true;
					}
				}
			}
//			print();
//			System.out.println();
			visit = new boolean[n][m];
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(arr[i][j]!=0 && !visit[i][j]) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			if(cnt>=2) {
				time++;
				break;
			} else if(cnt==0){
				System.out.println(0);
				return;
			} else {
				time++;
			}
		}
		System.out.println(time);
	}
	
	static void melt(int i, int j) {
		int sea = 0;
		for(int d=0;d<4;d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			
			if(ni>=0 && ni<n && nj>=0 && nj<m && !visit[ni][nj] && arr[ni][nj]==0) {
				sea++;
			}
		}
		if(arr[i][j]-sea>=0) {
			arr[i][j] -= sea; 
		} else {
			arr[i][j] = 0;
		}
	}
	
	static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {i,j});
		visit[i][j] = true;
		
		while(!q.isEmpty()) {
			int info[] = q.poll();
			for(int d=0;d<4;d++) {
				int ni = info[0]+di[d];
				int nj = info[1]+dj[d];
				
				if(ni>=0 && ni<n && nj>=0 && nj<m && !visit[ni][nj] && arr[ni][nj]!=0) {
					q.offer(new int[] {ni,nj});
					visit[ni][nj] = true;
				}
			}
		}
	}
	
	static void print() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(arr[i][j]+" ");
				
			}
			System.out.println();
		}
	}
}
