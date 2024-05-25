package Tier_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex20056 {
	static int n,m,k;
	static int di[] = {-1,-1,0,1,1,1,0,-1};
	static int dj[] = {0,1,1,1,0,-1,-1,-1};
	static List<fire> arr[][];
	static boolean check;
	static class fire{
		int m;
		int d;
		int s;
		boolean flag;
		public fire(int m, int d, int s, boolean flag) {
			super();
			this.m = m;
			this.d = d;
			this.s = s;
			this.flag = flag;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new List[n+1][n+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				arr[i][j] = new ArrayList<fire>();
			}
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			arr[x][y].add(new fire(m,d,s,false));
			
		}
		check = true;
		while(k-->0) {
//			System.out.println("r");
			for(int i=1;i<=n;i++) { // 이동
				for(int j=1;j<=n;j++) {
					for(int z=0;z<arr[i][j].size();z++) {
						fire f = arr[i][j].get(z);
						if(f.flag!=check) {
							f.flag = check;
						} else {
//							System.out.println("넘어가");
							continue;
						}
//						System.out.println(i+" sum아님 "+j);
						int ni = i +(di[f.d]*f.s)%n;
						int nj = j +(dj[f.d]*f.s)%n;
						
						if(ni<1) {
							ni = n-Math.abs(ni);
						} else if(ni>n){
							ni = ni-n;
						}
						if(nj<1) {
							nj = n-Math.abs(nj);
						} else if(nj>n){
							nj = nj-n;
						}
						arr[i][j].remove(z);
						z--;
						arr[ni][nj].add(f);
					}
				}
			}
			
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(arr[i][j].size()>=2) {
						sum(i,j);
					}
				}
			}
			check = !check;
		}
		int sum = 0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				for(int z=0;z<arr[i][j].size();z++) {
					sum+=arr[i][j].get(z).m;
				}
			}
		}
		System.out.println(sum);
	}
	
	static void sum(int x,int y) {
//		System.out.println(x+" "+y);
		int cnt = arr[x][y].size();
		int msum = 0;
		int ssum = 0;
		boolean flag1 = true; //짝수체크
		boolean flag2 = true; //홀수체크
		for(int i=0;i<arr[x][y].size();i++) {
			fire f = arr[x][y].get(i);
			if(f.d%2!=0) {
				flag1 = false;
			} else {
				flag2 = false;
			}
			msum+=f.m;
			ssum+=f.s;
		}
		
		int mavg = msum/5;
		int savg = ssum/cnt;
		
		arr[x][y].clear();
		if(mavg!=0 && (flag1 || flag2)) {
			arr[x][y].add(new fire(mavg,0,savg,check));
			arr[x][y].add(new fire(mavg,2,savg,check));
			arr[x][y].add(new fire(mavg,4,savg,check));
			arr[x][y].add(new fire(mavg,6,savg,check));
		} else if(mavg!=0) {
			arr[x][y].add(new fire(mavg,1,savg,check));
			arr[x][y].add(new fire(mavg,3,savg,check));
			arr[x][y].add(new fire(mavg,5,savg,check));
			arr[x][y].add(new fire(mavg,7,savg,check));
		}
	}
}
