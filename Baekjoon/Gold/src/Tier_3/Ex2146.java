package Tier_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex2146 {
	static int arr[][], n,che=1,time;
	static boolean visit[][];
	static int di[] = {-1,1,0,0};
	static int dj[] = {0,0,-1,1};
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		visit = new boolean[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]==1 && !visit[i][j]) {
					check(i,j);
					che++;
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]!=0) {
					bfs(i,j,arr[i][j]);
				}
			}
		}
		
		System.out.println(min);
	}
	
	static void print() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static void check(int i,int j) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		visit[i][j] = true;
		q.offer(new int[] {i,j});
		arr[i][j]=che;
		
		while(!q.isEmpty()) {
			int info[] = q.poll();
			for(int d=0;d<4;d++) {
				int ni = info[0]+di[d];
				int nj = info[1]+dj[d];
				
				if(ni>=0 && ni<n && nj>=0 && nj<n && !visit[ni][nj] && arr[ni][nj]==1) {
					q.offer(new int[] {ni,nj});
					visit[ni][nj] = true;
					arr[ni][nj] = che;
				}
			}
		}
	}
	
	static void bfs(int i, int j,int tmp) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		visit = new boolean[n][n];
		visit[i][j] = true;
		q.offer(new int[] {i,j});
		time = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0;s<size;s++) {
				int info[] = q.poll();
				
				if(arr[info[0]][info[1]]!=0 && arr[info[0]][info[1]]!=tmp) {
					if(min>time-1) {
//						System.out.println(i+" "+j+" "+(time-1));
						min = time-1;
						continue;
					} else {
						continue;
					}
				}
				
				for(int d=0;d<4;d++) {
					int ni = info[0]+di[d];
					int nj = info[1]+dj[d];
					
					if(ni>=0 && ni<n && nj>=0 && nj<n && !visit[ni][nj] && arr[ni][nj]!=tmp) {
						q.offer(new int[] {ni,nj});
						visit[ni][nj] = true;
					}
				}
			}
			time++;
		}
	}
}
