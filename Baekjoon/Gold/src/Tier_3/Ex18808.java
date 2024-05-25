package Tier_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex18808 {
	static int arr[][],n,m,k,r,c;
	static int num[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		
		for(int t=0;t<k;t++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			num = new int[r][c];
			
			for(int x=0;x<r;x++) {
				st = new StringTokenizer(br.readLine());
				for(int y=0;y<c;y++) {
					num[x][y] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int d=0;d<4;d++) {
				if(put()) {
					break;
				} else {
					rotation();
				}
			}
		}
		
		int cnt = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==1) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
	}
	static boolean put() {
		for(int i=0;i<=n-r;i++) {
			for(int j=0;j<=m-c;j++) {
				if(check(i,j)) {
					return true;
				}
			}
		}
		return false;
	}
	
	static boolean check(int a, int b) {
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(arr[a+i][b+j]==1 && num[i][j]==1) {
					return false;
				}
			}
		}
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(num[i][j]==1) {
					arr[a+i][b+j] = 1;
				}
			}
		}
		return true;
	}
	
	static void rotation() {
		int tmp[][] = new int[r][c];
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				tmp[i][j] = num[i][j];
			}
		}
		
		num = new int[c][r];
		
		for(int i=0;i<c;i++	) {
			for(int j=0;j<r;j++) {
				num[i][j] = tmp[r-j-1][i];
			}
		}
		
		int temp = r;
		r=c;
		c=temp;
	}
}
