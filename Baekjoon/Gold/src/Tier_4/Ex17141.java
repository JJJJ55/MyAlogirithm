package Tier_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex17141 {
	static int arr[][],ori[][],n,m,cnt;
	static boolean visit[];
	static int di[] = {-1,1,0,0};
	static int dj[] = {0,0,-1,1};
	static int min = Integer.MAX_VALUE;
	static Queue<int[]> q;
	
	static ArrayList<int[]> list = new ArrayList<int[]>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][n];
		ori = new int[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==2) {
					list.add(new int[] {i,j});
				} else if(arr[i][j]==0) {
					cnt++;
				}
			}
		}
		
		
		cnt = cnt + list.size()-m;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				ori[i][j] = arr[i][j];
			}
		}
		
		visit = new boolean[list.size()];
		
		comb(0,0);
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}
	
	static void comb(int idx, int cnt) {
		if(cnt==m) {
			q = new ArrayDeque<int[]>();
			for(int i=0;i<visit.length;i++) {
				if(!visit[i]) {
					arr[list.get(i)[0]][list.get(i)[1]] = 0;
				} else {
					q.offer(new int[] {list.get(i)[0],list.get(i)[1]});
				}
			}
			
			bfs();
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					arr[i][j] = ori[i][j];
				}
			}
			return;
		}
		if(idx==list.size()) {
			return;
		}
		visit[idx] = true;
		comb(idx+1,cnt+1);
		visit[idx] = false;
		comb(idx+1, cnt);
	}
	
	static void bfs() {
		int time = 0;
		int count = cnt;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0;s<size;s++) {
				int info[] = q.poll();
				for(int d=0;d<4;d++) {
					int ni = info[0]+di[d];
					int nj = info[1]+dj[d];
					
					if(ni>=0 && ni<n && nj>=0 && nj<n && arr[ni][nj]==0) {
						arr[ni][nj] = 2;
						q.offer(new int[] {ni,nj});
						count--;
					}
				}
			}
			time++;
		}
		if(count==0) {
			min = Math.min(min, time-1);
		}
	}
	
	static void print() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
