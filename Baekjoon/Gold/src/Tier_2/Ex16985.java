package Tier_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex16985 {
	static int arr[][][] = new int[5][5][5];
	static int test[][][],num[],rotation[], min = Integer.MAX_VALUE;
	static boolean visit[][][], flag[];
	static int di[] = {-1,1,0,0,0,0};
	static int dj[] = {0,0,-1,1,0,0};
	static int dk[] = {0,0,0,0,-1,1};
	
	static class Node{
		int i,j,z,cnt;

		public Node(int i, int j, int z, int cnt) {
			super();
			this.i = i;
			this.j = j;
			this.z = z;
			this.cnt = cnt;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int k=0;k<5;k++) {
			for(int i=0;i<5;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<5;j++) {
					arr[k][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		num = new int[5];
		flag = new boolean[5];
		rotation = new int[5];
		perm(0);
		
		
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
	
	static void perm(int idx) {
		if(idx==5) {
			test = new int[5][5][5];
			for(int i=0;i<num.length;i++) {
				turn(0);
			}
			return;
		}
		
		for(int i=0;i<5;i++	) {
			if(!flag[i]) {
				flag[i] = true;
				num[idx] = i;
				perm(idx+1);
				flag[i] = false;
			}
		}
	}
	
	static void turn(int idx) {
		if(idx == 5) {
			for(int i=0;i<num.length;i++) {
				int pan = num[i];
				int d = rotation[pan];
				for(int r=0;r<5;r++	) {
					for(int c=0;c<5;c++) {
						if(d ==0) {
							test[i][r][c] = arr[pan][r][c];
						}
						if(d ==1) {
							test[i][c][4-r] = arr[pan][r][c];
						}
						if(d ==2) {
							test[i][4-r][4-c] = arr[pan][r][c];
						}
						if(d ==3) {
							test[i][4-c][r] = arr[pan][r][c];
						}
					}
				}
			}
			if(test[0][0][0] == 1 && test[4][4][4] == 1) {
				bfs();
			}
			return;
		}
		
		for(int d=0;d<4;d++) {
			rotation[idx] = d;
			turn(idx+1);
		}
	}
	
	static void bfs() {
		Queue<Node> q = new ArrayDeque<Node>();
		visit = new boolean[5][5][5];
		q.offer(new Node(0,0,0,0));
		visit[0][0][0] = true;
		while(!q.isEmpty()) {
			Node now = q.poll();
			if(now.i == 4 && now.j == 4 && now.z == 4) {
				min = Math.min(min, now.cnt);
				if(min == 12) {
					System.out.println(12);
					System.exit(0);
				}
				break;
			}
			for(int d=0;d<6;d++) {
				int ni = now.i+di[d];
				int nj = now.j+dj[d];
				int nz = now.z+dk[d];
				if(ni<0 || nj<0 || nz<0 || ni>=5 || nj>=5 || nz>=5 || visit[nz][ni][nj] || test[nz][ni][nj] == 0) {
					continue;
				}
//				if(ni>=0 && nj>=0 && nz>=0 & ni<5 && nj<5 && nz<5
//						&& !visit[nz][ni][nj] && test[nz][ni][nj] == 1) {
//					visit[nz][ni][nj] = true;
//					q.offer(new Node(ni,nj,nz,now.cnt+1));
//				}
				visit[nz][ni][nj] = true;
				q.offer(new Node(ni,nj,nz,now.cnt+1));
					
			}
		}
	}
	
	static void print() {
		for(int k=0;k<5;k++) {
			for(int i=0;i<5;i++) {
				for(int j=0;j<5;j++) {
					System.out.print(arr[j][i][k]+" ");
				}
			}
		}
	}
}
