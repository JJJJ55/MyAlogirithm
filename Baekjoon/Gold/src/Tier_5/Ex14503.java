package Tier_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex14503 {
	static int arr[][],n,m,cnt,si,sj,dir;
	static int di[] = {-1,0,1,0};
	static int dj[] = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		
		st = new StringTokenizer(br.readLine());
		
		si = Integer.parseInt(st.nextToken());
		sj = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			if(arr[si][sj]==1) {
				break;
			}
			if(arr[si][sj]!=9) { // 현재칸이 청소가 안되있으면?
				arr[si][sj] = 9; // 청소하기
				cnt++; //청소한 횟수 증가
				int count = 0; //주변을 탐색하여 청소된 칸 개수세기
//				print();
//				System.out.println(si+" "+sj);
				for(int d=0;d<4;d++) {
					int ni = si+di[d];
					int nj = sj+dj[d];
					if(ni>=0 && ni<n && nj>=0 && nj<m && arr[ni][nj]==0) {
						count++;
					}
				}
				if(count==0) { // 주변 4곳이 모두 청소됐으면 지금 방향을 유지한채 후진
					int ni = si-di[dir];
					int nj = sj-dj[dir];
					if(ni<0 || ni>=n || nj<0 || nj>=m || arr[ni][nj]==1) { //범위를 벗어나거나 벽이면 작동을 멈춤
						break;
					} else { // 후진할 수 있으면 후진
						si = ni;
						sj = nj;
					}
				} else { // 주변 4곳 중 청소안된 곳이 하나라도 있으면?
					for(int d=0;d<4;d++) {
						dir = dir-1<0 ? 3 : dir-1; // 반시계로 90도 회전						
						int ni = si+di[dir];
						int nj = sj+dj[dir];
						if(ni>=0 && ni<n && nj>=0 && nj<m && arr[ni][nj]==0) { // 청소안된 곳이면 이동
							si = ni;
							sj = nj;
							break;
						}
					}
				}
			} else {
				int i = si;
				int j = sj;
				int origin = dir;
				for(int d=0;d<4;d++) {
					dir = dir-1<0 ? 3 : dir-1; // 반시계로 90도 회전						
					int ni = si+di[dir];
					int nj = sj+dj[dir];
					if(ni>=0 && ni<n && nj>=0 && nj<m && arr[ni][nj]==0) { // 청소안된 곳이면 이동
						si = ni;
						sj = nj;
						break;
					}
				}
				if(i==si && j==sj) {
					si-=di[origin];
					sj-=dj[origin];
					dir = origin;
				}
			}
		}
		
		
		System.out.println(cnt);
	}
	
	static void print() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("====");
	}
}
