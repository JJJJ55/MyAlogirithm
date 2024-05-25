package Tier_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex20057 {
	static int arr[][], n;
	static int di[] = { 0, 1, 0, -1 };
	static int dj[] = { -1, 0, 1, 0 };
	static int dc[] = { 1, 1, 2, 2 };
	static int[][] dsx = { { -1, 1, -2, -1, 1, 2, -1, 1, 0 }, { -1, -1, 0, 0, 0, 0, 1, 1, 2 }, 
			{ 1, -1, 2, 1, -1, -2, 1, -1, 0 }, { 1, 1, 0, 0, 0, 0, -1, -1, -2 } };
	static int[][] dsy = { { 1, 1, 0, 0, 0, 0, -1, -1, -2 }, { -1, 1, -2, -1, 1, 2, -1, 1, 0 },
			{ -1, -1, 0, 0, 0, 0, 1, 1, 2 }, { 1, -1, 2, 1, -1, -2, 1, -1, 0 } };
	static int[] sandRatio = { 1, 1, 2, 7, 7, 2, 10, 10, 5 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = sand(n/2,n/2);
		System.out.println(ans);

	}
	
	static int sand(int x, int y) {
		int total = 0;
		int nx = x;
		int ny = y;
		
		while(true) {
			for(int d=0;d<4;d++) {
				for(int m=0;m<dc[d];m++) {
					int ni = nx+di[d];
					int nj = ny+dj[d];
					
					if(ni<0 || ni>=n || nj<0 || nj>=n) {
						return total;
					}
					
					int sand = arr[ni][nj];
					arr[ni][nj] = 0;
					int spreadTotal = 0;
					
					for(int s=0;s<9;s++) {
						int si = ni + dsx[d][s];
						int sj = nj + dsy[d][s];
						
						int spreadAmount = (sand*sandRatio[s])/100;
						if(si<0 || si>=n || sj<0 || sj>=n) {
							total+=spreadAmount;
						} else {
							arr[si][sj]+=spreadAmount;
						}
						spreadTotal+=spreadAmount;
					}
					int ai = ni+di[d];
					int aj = nj+dj[d];
					int aAmount = sand-spreadTotal;
					if(ai<0 || ai>=n || aj<0 || aj>=n) {
						total+=aAmount;
					} else {
						arr[ai][aj]+=aAmount;
					}
					
					nx = ni;
					ny = nj;
				}
			}
			for(int idx = 0; idx<4;idx++) {
				dc[idx]+=2;
			}
		}
	}
}
