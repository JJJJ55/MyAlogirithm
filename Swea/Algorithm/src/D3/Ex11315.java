package D3;

import java.util.Scanner;

public class Ex11315 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int di[] = {-1,1,0,0,-1,1,-1,1};
		int dj[] = {0,0,-1,1,-1,1,1,-1};
		
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			int n = sc.nextInt();
			int arr[][] = new int[n][n];
			String answer = "NO";
			
			for(int i=0;i<n;i++) {
				String str = sc.next();
				for(int j=0;j<n;j++) {
					if(str.charAt(j)=='o') {
						arr[i][j]=1;
					}
				}
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(arr[i][j]==1) {
						for(int z=0;z<8;z++) {
							for(int idx = 0;idx<5;idx++) {
								int ni = i+di[z]*idx;
								int nj = j+dj[z]*idx;
								
								if(ni>=0 && ni<n && nj>=0 && nj<n) {
									if(arr[ni][nj]==0) {
										break;
									}
								} else {
									break;
								}
								if(idx==4) {
									answer="YES";
								}
							}

						}
					}
				}
			}
			System.out.printf("#%d %s\n",t+1,answer);
		}
	}
}
