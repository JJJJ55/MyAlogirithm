package Tier_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex12100 {
	static int arr[][],n;
	static int num[];
	static int max = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		num = new int[5];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		game(0);

		System.out.println(max);
	}
	
	static void game(int cnt) {
		if(cnt==5) {
			int test[][] = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					test[i][j] = arr[i][j];
				}
			}
			
			for(int i=0;i<5;i++) {
				switch (num[i]) {
				case 0:
					up(test);
					break;
				case 1:
					down(test);
					break;
				case 2:
					left(test);
					break;
				case 3:
					right(test);
					break;

				}
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(max<=test[i][j]) {
						max=test[i][j];
					}
				}
			}	
			
			return;
		}
		
		for(int i=0;i<4;i++) {
			num[cnt]=i;
			game(cnt+1);
		}
	}
	
	static void up(int [][]test) {
		for(int i=0;i<n;i++) {
			int tmp[] = new int[n];
			int idx = 0;
			for(int j=0;j<n;j++) {
				if(test[j][i]==0) {
					continue;
				}
				if(tmp[idx]==0) {
					tmp[idx] = test[j][i];
				} else if(tmp[idx]==test[j][i]){
					tmp[idx++]*=2;
				} else {
					tmp[++idx] = test[j][i];
				}
			}
			
			for(int j=0;j<n;j++) {
				test[j][i] = tmp[j];
			}
		}
	}
	
	static void down(int [][]test) {
		for(int i=0;i<n;i++) {
			int tmp[] = new int[n];
			int idx = n-1;
			for(int j=n-1;j>=0;j--) {
				if(test[j][i]==0) {
					continue;
				}
				if(tmp[idx]==0) {
					tmp[idx] = test[j][i];
				} else if(tmp[idx]==test[j][i]){
					tmp[idx--]*=2;
				} else {
					tmp[--idx] = test[j][i];
				}
			}
			
			for(int j=0;j<n;j++) {
				test[j][i] = tmp[j];
			}
		}
	}
	
	static void left(int [][]test) {
		for(int i=0;i<n;i++) {
			int tmp[] = new int[n];
			int idx = 0;
			for(int j=0;j<n;j++) {
				if(test[i][j]==0) {
					continue;
				}
				if(tmp[idx]==0) {
					tmp[idx] = test[i][j];
				} else if(tmp[idx]==test[i][j]){
					tmp[idx++]*=2;
				} else {
					tmp[++idx] = test[i][j];
				}
			}
			
			for(int j=0;j<n;j++) {
				test[i][j] = tmp[j];
			}
		}
	}
	static void right(int [][]test) {
		for(int i=0;i<n;i++) {
			int tmp[] = new int[n];
			int idx = n-1;
			for(int j=n-1;j>=0;j--) {
				if(test[i][j]==0) {
					continue;
				}
				if(tmp[idx]==0) {
					tmp[idx] = test[i][j];
				} else if(tmp[idx]==test[i][j]){
					tmp[idx--]*=2;
				} else {
					tmp[--idx] = test[i][j];
				}
			}
			
			for(int j=0;j<n;j++) {
				test[i][j] = tmp[j];
			}
		}
	}
}
