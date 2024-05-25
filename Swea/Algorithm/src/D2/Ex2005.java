package D2;

import java.util.Scanner;

public class Ex2005 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=0;t<T;t++) {
			int n = sc.nextInt();
			int arr[][] = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<=i;j++) {
					if(j==0 || i==j) {
						arr[i][j]=1;
					} else {
						arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
					}
				}
			}
			System.out.printf("#%d\n",t+1);
			for(int i=0;i<n;i++) {
				for(int j=0;j<=i;j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}