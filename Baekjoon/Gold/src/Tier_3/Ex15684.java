package Tier_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex15684 {
	static int n,m,h,min = Integer.MAX_VALUE;
	static int arr[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		arr = new int[h+2][n+2];
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = 1;
		}
		
		for(int i=0;i<=3;i++) {
			dfs(0,i,1);
		}
		
		System.out.println(-1);
	}
	
	static void dfs(int cnt, int max, int col) {
		if(cnt>max || cnt >4) {
			return;
		}
		if(check()) {
			System.out.println(cnt);
			System.exit(0);
			return;
		}
		
		for(int i=col;i<=h;i++) {
			for(int j=1;j<=n;j++) {
				if(arr[i][j]==0 && arr[i][j-1]==0 && arr[i][j+1] ==0) {
					arr[i][j] = 1;
					dfs(cnt+1,max,i);
					arr[i][j] = 0;
				}
			}
		}
	}
	
	static boolean check() { //사다리 게임 실행해서 검사
		for(int i=1;i<n;i++) {
			int line = i;
			int col = 1;
			while(true) {
				if(col==h+1) {
					break;
				}
				if(arr[col][line]==1) {
					line++;
				} else if(arr[col][line-1]==1) {
					line--;
				}
				col++;
			}
			if(line!=i) {
				return false;
			}
		}
		return true;
	}
}
