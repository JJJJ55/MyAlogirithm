package Tier_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex18405 {
	static int n,k,arr[][];
	static int s,x,y;
	static int di[] = {-1,1,0,0};
	static int dj[] = {0,0,-1,1};
	
	static Queue<int[]> q[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n][n];
		q = new Queue[k+1];
		for(int i=1;i<=k;i++) {
			q[i] = new ArrayDeque<int[]>();
		}
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]!=0) {
					q[arr[i][j]].add(new int[] {i,j});
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken())-1;
		y = Integer.parseInt(st.nextToken())-1;
		
		while(s-->0) {
			for(int i=1;i<=k;i++) {
				bfs(i);
			}
//			print();
		}
		
		System.out.println(arr[x][y]);
	}
	
	static void bfs(int tmp) {
		int size = q[tmp].size();
		for(int s=0;s<size;s++) {
			int info[] = q[tmp].poll();
			
			for(int d=0;d<4;d++) {
				int ni = info[0]+di[d];
				int nj = info[1]+dj[d];
				
				if(ni>=0 && ni<n && nj>=0 && nj<n && arr[ni][nj]==0) {
					arr[ni][nj]=tmp;
					q[tmp].add(new int[] {ni,nj});
				}
			}
		}
	}
	static void print() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("======");
	}
}
