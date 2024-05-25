package Tier_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex21610 {
	static int n,m,arr[][];
	static int di[] = {0,-1,-1,-1,0,1,1,1};
	static int dj[] = {-1,-1,0,1,1,1,0,-1};
	static boolean visit[][];
	static List<c> list = new ArrayList<c>();
	static class c{
		int x;
		int y;
		public c(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		list.add(new c(n-1,1));
		list.add(new c(n-1,2));
		list.add(new c(n,1));
		list.add(new c(n,2));
		
		while(m-->0) {
			visit = new boolean[n+1][n+1];
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken())-1;
			int dis = Integer.parseInt(st.nextToken());
			
			for(int i=0;i<list.size();i++) { // 구름이동
				c cloud = list.get(i);
//				System.out.println(cloud.x+" "+cloud.y);
				int ni = cloud.x + (di[dir]*dis)%n;
				int nj = cloud.y + (dj[dir]*dis)%n;
				
				if(ni<1) {
					ni = n-Math.abs(ni);
				} else if(ni>n) {
					ni = ni-n;
				}
				
				if(nj<1) {
					nj = n-Math.abs(nj);
				} else if(nj>n) {
					nj = nj-n;
				}
				
				cloud.x = ni;
				cloud.y = nj;
//				System.out.println(cloud.x+" "+cloud.y);
				
				arr[ni][nj]++; // 구름 이동 후 비내림
				visit[ni][nj] = true; //비가 온 지역 체크
			}
			water(); // 물복사버그
			list.clear();
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(!visit[i][j] && arr[i][j]>=2) {
						list.add(new c(i,j));
						arr[i][j]-=2;
					}
				}
			}
		}
		int sum = 0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				sum+=arr[i][j];
			}
		}
		System.out.println(sum);
		
	}
	
	static void water() {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(visit[i][j]) {
					int cnt = 0;
					for(int d=1;d<8;d+=2) {
						int ni = i+di[d];
						int nj = j+dj[d];
						
						if(ni>=1 && ni<=n && nj>=1 && nj<=n && arr[ni][nj]!=0) {
							cnt++;
						}
					}
					arr[i][j]+=cnt;
				}
			}
		}
	}
}
