package Tier_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Ex17837 {
	static int arr[][],n,k,time,stack;
	static int di[] = {0,0,-1,1};
	static int dj[] = {1,-1,0,0};
	static List<Integer> list[][];
	static target t[];
	
	static class target{
		int x;
		int y;
		int dir;
		int up = 0;
		public target(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][n+1];
		list = new List[n+1][n+1];
		t = new target[k+1];
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				list[i][j] = new ArrayList<Integer>();
			}
		}
		
		for(int i=1;i<=k;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken())-1;
			t[i] = new target(x,y,dir);
			list[x][y].add(i);
		}
		
		while(true) {
			time++;
			if(time>1000) {
				System.out.println(-1);
				return;
			}
			
			for(int i=1;i<=k;i++) {
				target now = t[i];
				
				int ni = now.x+di[now.dir];
				int nj = now.y+dj[now.dir];
				
				if(ni>=1 && ni<=n && nj>=1 && nj<=n) {
					if(arr[ni][nj]==0) { //흰색
						int idx = list[now.x][now.y].indexOf(i);
						
						list[ni][nj].addAll(list[now.x][now.y].subList(idx, list[now.x][now.y].size()));
						list[now.x][now.y] = list[now.x][now.y].subList(0, idx);
						now.x = ni;
						now.y = nj;
						
						for(int a : list[ni][nj]) {
							t[a].x = ni;
							t[a].y = nj;
						}
					} else if(arr[ni][nj]==1) { //빨간색
						int idx = list[now.x][now.y].indexOf(i);
						List<Integer> sub = list[now.x][now.y].subList(idx, list[now.x][now.y].size());
						Collections.reverse(sub);
						
						list[ni][nj].addAll(sub);
						list[now.x][now.y] = list[now.x][now.y].subList(0, idx);
						
						for(int a : list[ni][nj]) {
							t[a].x = ni;
							t[a].y = nj;
						}
					} else { //파란색
						int dir = reverse(now.dir);
						t[i].dir = dir;
						
						int r = now.x+di[dir];
						int c = now.y+dj[dir];
						if(r>=1 && r<=n && c>=1 && c<=n && arr[r][c]!=2) {
							i--;
						}
					}
					if(list[ni][nj].size()>3) {
						System.out.println(time);
						return;
					}
				} else {
					int dir = reverse(now.dir);
					t[i].dir = dir;
					
					int r = now.x+di[dir];
					int c = now.y+dj[dir];
					if(r>=1 && r<=n && c>=1 && c<=n && arr[r][c]!=2) {
						i--;
					}
				}
			}
		}
	}
	
	static int reverse(int idx) {
		int dir =0;
		switch (idx) {
		case 0:
			dir = 1;
			break;
		case 1:
			dir = 0;
			break;
		case 2:
			dir = 3;
			break;
		case 3:
			dir = 2;
			break;
		}
		return dir;
	}
}
