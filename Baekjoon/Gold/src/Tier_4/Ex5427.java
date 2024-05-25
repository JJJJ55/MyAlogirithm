package Tier_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex5427 {
	static char arr[][];
	static int r,c,cnt;
	static int min;;
	static int di[] = {-1,1,0,0};
	static int dj[] = {0,0,-1,1};
	static Queue<int[]> h;
	static Queue<int[]> f;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=0;t<TC;t++) {
			h = new ArrayDeque<int[]>();
			f = new ArrayDeque<int[]>();
			min = Integer.MAX_VALUE;
			cnt = 0;
			st = new StringTokenizer(br.readLine());
			c = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			
			arr = new char[r][c];
			
			for(int i=0;i<r;i++) {
				String str = br.readLine();
				for(int j=0;j<c;j++) {
					arr[i][j] = str.charAt(j);
					if(arr[i][j]=='@') {
						h.add(new int[] {i,j});
					} else if(arr[i][j]=='*') {
						f.add(new int[] {i,j});
					}
				}
			}
			
			bfs();
			if(min == Integer.MAX_VALUE) {
				System.out.println("IMPOSSIBLE");
			} else {
				System.out.println(min);			
			}
		}
	}
	
	static void bfs() {
		cnt++;
		while(!h.isEmpty()) {
			int size = h.size();
			int size2 = f.size();
			for(int s=0;s<size;s++) {
				
				int human[] = h.poll();
				
//				print();
//				System.out.println();
				if(arr[human[0]][human[1]]!='@') {
					continue;
				}
				
				if(human[0]==0 || human[0]==r-1 || human[1]==0 || human[1]==c-1) {
					min = Math.min(min, cnt);
					continue;
				}
				
				for(int d=0;d<4;d++	) {
					int hi = human[0]+di[d];
					int hj = human[1]+dj[d];
					
					
					if(hi>=0 && hi<r && hj>=0 && hj<c && arr[hi][hj]=='.') {
						h.offer(new int[] {hi,hj});
						arr[hi][hj] = '@';
					}
				}
			}
			for(int ss=0;ss<size2;ss++) {
				int fire[] = f.poll();
				
				for(int d=0;d<4;d++	) {
					int fi = fire[0]+di[d];
					int fj = fire[1]+dj[d];
					if(fi>=0 && fi<r && fj>=0 && fj<c && (arr[fi][fj]=='.' || arr[fi][fj]=='@')) {
						f.offer(new int[] {fi,fj});
						arr[fi][fj] = '*';
					}
				}
			}
			cnt++;
		}
	}
	
	static void print() {
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}
