package Tier_4;
import java.util.Scanner;

public class Ex2567 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[][] = new int[101][101];
		int di[] = {-1,1,0,0};
		int dj[] = {0,0,-1,1};
		int cnt = 0;
		
		int n = sc.nextInt();
		
		for(int t=0;t<n;t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			for(int i=a;i<a+10;i++) {
				for(int j=b;j<b+10;j++) {
					arr[i][j] = 1;
				}
			}
		}
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(arr[i][j]>0) {
					for(int d=0;d<4;d++) {
						int ni = i+di[d];
						int nj = j+dj[d];
						if(ni>=0 && ni<=100 && nj>=0 && nj<=100 && arr[ni][nj]==0) {
							cnt++;
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}
}