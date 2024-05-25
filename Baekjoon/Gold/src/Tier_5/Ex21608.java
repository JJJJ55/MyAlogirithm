package Tier_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex21608 {
	static int map[][],arr[][],n;
	static int di[] = {-1,1,0,0};
	static int dj[] = {0,0,-1,1};
	
	static class p implements Comparable<p>{
		int x,y,like,blank;

		public p(int x, int y, int like, int blank) {
			super();
			this.x = x;
			this.y = y;
			this.like = like;
			this.blank = blank;
		}

		@Override
		public int compareTo(p o) {
			if(this.like == o.like) {
				if(this.blank == o.blank) {
					if(this.x == o.x) {
						return this.y - o.y;
					}
					return this.x - o.x;
				}
				return o.blank - this.blank;
			}
			return o.like - this.like;
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n*n][5];
		map = new int[n+1][n+1];
		
		for(int i=0;i<n*n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int a=0;a<n*n;a++) {
			PriorityQueue<p> pq = new PriorityQueue<p>();
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(map[i][j]==0) {
						int b = 0;
						int l = 0;
						for(int d=0;d<4;d++) {
							int ni = i+di[d];
							int nj = j+dj[d];
							if(ni<1 || nj<1 || ni>n || nj>n) continue;
							for(int z=1;z<5;z++) {
								if(map[ni][nj] == arr[a][z]) {
									l++;
									break;
								}
							}
							if(map[ni][nj]==0) {
								b++;
							}
						}
						pq.add(new p(i,j,l,b));
					}
				}
			}
			p now = pq.poll();
			map[now.x][now.y] = arr[a][0];
		}
		int sum = 0;
//		for(int i=1;i<=n;i++) {
//			for(int j=1;j<=n;j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				int idx = 0;
				for(int a=0;a<arr.length;a++) {
					if(arr[a][0]==map[i][j]) {
						idx = a;
						break;
					}
				}
				int cnt = 0;
				for(int d=0;d<4;d++) {
					int ni = i+di[d];
					int nj = j+dj[d];
					if(ni<1 || nj<1 || ni>n || nj>n) continue;
					for(int z=1;z<5;z++) {
						if(map[ni][nj] == arr[idx][z]) {
							cnt++;
							break;
						}
					}
				}
				switch (cnt) {
				case 1:
					sum+=1;
					break;
				case 2:
					sum+=10;
					break;
				case 3:
					sum+=100;
					break;
				case 4:
					sum+=1000;
					break;
				}
			}
		}
		
		System.out.println(sum);
	}
}
