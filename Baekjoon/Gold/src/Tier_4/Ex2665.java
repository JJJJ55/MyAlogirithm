package Tier_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Ex2665 {
	static int n,arr[][];
	static int dist[][];
	static int di[] = {-1,1,0,0};
	static int dj[] = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		dist = new int[n][n];
		for(int i=0;i<n;i++) {
			char c[] = br.readLine().toCharArray();
			for(int j=0;j<n;j++) {
				dist[i][j] = Integer.MAX_VALUE;
				arr[i][j] = c[j]-'0';
			}
		}
		
		dik();
		System.out.println(dist[n-1][n-1]);
	}
	
	static void dik() {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] {0,0});
		dist[0][0] = 0;
		
		while(!q.isEmpty()) {
			int[] info = q.poll();
			
			if(info[0]==n-1 && info[1]==n-1) {
				continue;
			}
			for(int d=0;d<4;d++) {
				int ni = info[0]+di[d];
				int nj = info[1]+dj[d];
				
				if(ni>=0 && ni<n && nj>=0 && nj<n) {
					if(arr[ni][nj]==0 && dist[ni][nj] > dist[info[0]][info[1]]+1) {
						dist[ni][nj] = dist[info[0]][info[1]]+1;
						q.add(new int[] {ni,nj});
					} else if(arr[ni][nj] == 1 && dist[ni][nj] > dist[info[0]][info[1]]) {
						dist[ni][nj] = dist[info[0]][info[1]];
						q.add(new int[] {ni,nj});
					}
				}
			}
		}
	}
}
