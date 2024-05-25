package Tier_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex2583 {
	static int arr[][], n,m,k;
	static boolean visit[][];
	static int di[] = {-1,1,0,0};
	static int dj[] = {0,0,-1,1};
	static ArrayList<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			int si = Integer.parseInt(st.nextToken());
			int sj = Integer.parseInt(st.nextToken());
			int ei = Integer.parseInt(st.nextToken());
			int ej = Integer.parseInt(st.nextToken());
			
			for(int a=si;a<ei;a++) {
				for(int b=sj;b<ej;b++) {
					arr[b][a]++;
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==0 && !visit[i][j]) {
					bfs(i,j);
				}
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for(int i : list) {
			System.out.print(i+" ");
		}

	}
	
	static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {i,j});
		visit[i][j] = true;
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int info[] = q.poll();
			
			for(int d=0;d<4;d++) {
				int ni = info[0]+di[d];
				int nj = info[1]+dj[d];
				
				if(ni>=0 && ni<n && nj>=0 && nj<m && !visit[ni][nj] && arr[ni][nj]==0) {
					q.offer(new int[] {ni,nj});
					visit[ni][nj] = true;
					cnt++;
				}
			}
		}
		list.add(cnt);
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
