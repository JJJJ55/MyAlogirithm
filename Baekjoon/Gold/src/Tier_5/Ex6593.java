package Tier_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex6593 {
	static char arr[][][];
	static int l,r,c,time;
	static boolean visit[][][];
	static int di[] = {-1,1,0,0,0,0};
	static int dj[] = {0,0,-1,1,0,0};
	static int dk[] = {0,0,0,0,-1,1};
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			if(l==0 && r==0 && c==0) {
				break;
			}
			
			arr = new char[l][r][c];
			visit = new boolean[l][r][c];
			min  = Integer.MAX_VALUE;
			time = 0;
			
			int si = 0;
			int sj = 0;
			int sk = 0;
			
			for(int k=0;k<l;k++) {
				for(int i = 0;i<r;i++) {
					String str = br.readLine();
					for(int j=0;j<c;j++) {
						arr[k][i][j] = str.charAt(j);
						if(arr[k][i][j]=='S') {
							sk=k;
							si=i;
							sj=j;
						}
					}
				}
				br.readLine();
			}
			
			bfs(sk,si,sj);
			
			if(min==Integer.MAX_VALUE) {
				System.out.println("Trapped!");
			} else {
				System.out.printf("Escaped in %d minute(s).\n",min);
			}
		}
		
	}
	static void bfs(int k,int i, int j) {
		Queue<int []> q = new ArrayDeque<int []>();
		q.offer(new int[] {k,i,j});
		visit[k][i][j] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0;s<size;s++) {
				int info[] = q.poll();
				
				if(arr[info[0]][info[1]][info[2]]=='E') {
					min = Math.min(min, time);
					continue;
				}
				
				for(int d=0;d<6;d++) {
					int nk = info[0]+dk[d];
					int ni = info[1]+di[d];
					int nj = info[2]+dj[d];
					
					if(ni>=0 && ni<r && nj>=0 && nj<c && nk>=0 && nk<l
							&& !visit[nk][ni][nj] && arr[nk][ni][nj]!='#') {
						q.offer(new int[] {nk,ni,nj});
						visit[nk][ni][nj] = true;
					}
				}
			}
			time++;
		}
	}
	
	
	
	
	static void print() {
		for(int k=0;k<l;k++) {
			for(int i = 0;i<r;i++) {
				for(int j=0;j<c;j++) {
					System.out.print(arr[k][i][j]);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
