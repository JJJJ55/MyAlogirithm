package Tier_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex17779 {
	static int arr[][],test[][],n,sum,result = Integer.MAX_VALUE;
	static boolean flag[][];
	static int di[] = {1,1,1,1};
	static int dj[] = {-1,1,1,-1};
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				sum+=arr[i][j];
			}
		}

		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				for(int d1=1;d1<=n;d1++) {
					for(int d2=1;d2<=n;d2++) {
						test = new int[n+1][n+1];
						if(i+d1+d2>n) continue;
						if((j-d1<1) || (j+d2>n)) continue;
						play(i,j,d1,d2);
					}
				}
			}
		}
//		test = new int[n+1][n+1];
//		play(3,3,1,1);
		System.out.println(result);
	}
	
	static void play(int i, int j, int d1, int d2) {
		int cnt[] = new int[5];
		flag = new boolean[n+1][n+1];
		
		for(int x=0;x<=d1;x++) {
			flag[i+x][j-x] = true;
			flag[i+d2+x][j+d2-x] = true;
		}
		
		for(int x=0;x<=d2;x++) {
			flag[i+x][j+x] = true;
			flag[i+d1+x][j-d1+x] = true;
		}
		
		
		int nj = 0;
		//1
		for(int x=1;x<i+d1;x++) {
			for(int y=1;y<=j;y++) {
				if(flag[x][y]) break;
				test[x][y] = 1;
				cnt[1]+=arr[x][y];
			}
		}
		
		//2
		for(int x=1;x<=i+d2;x++) {
			for(int y=n;y>j;y--) {
				if(flag[x][y]) break;
				test[x][y] = 2;
				cnt[2]+=arr[x][y];
			}
		}
		
		//3
		for(int x=i+d1;x<=n;x++) {
			for(int y=1;y<j-d1+d2;y++){
				if(flag[x][y]) break;
				test[x][y] = 3;
				cnt[3]+=arr[x][y];
			}
		}
		
		//4
		for(int x=i+d2+1;x<=n;x++) {
			for(int y=n;y>=j-d1+d2;y--) {
				if(flag[x][y]) break;
				test[x][y] = 4;
				cnt[4]+=arr[x][y];
			}
		}

//		print();
		cnt[0] = sum-cnt[1]-cnt[2]-cnt[3]-cnt[4];
//		System.out.println(Arrays.toString(cnt));
		Arrays.sort(cnt);
		result = Math.min(result, cnt[4]-cnt[0]);
	}
	
	
	static void print() {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				System.out.print(test[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	// 3이 왜 이상하게 나와
}
