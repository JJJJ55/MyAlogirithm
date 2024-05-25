package D2;

import java.util.Scanner;

public class Ex1961 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		int sum = 0;
		
		for (int t = 0; t < T; t++) {
			int n = sc.nextInt();
			int arr[][] = new int[n][n];
			
			for(int i = 0;i<n;i++) {
				for(int j=0;j<n;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			System.out.printf("#%d\n",t+1);
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(arr[n-j-1][i]);
				}
				System.out.print(" ");
				
				for(int j=n-1;j>=0;j--) {
					System.out.print(arr[n-i-1][j]);
				}
				System.out.print(" ");
				for(int j=0;j<n;j++) {
					System.out.print(arr[j][n-i-1]);
				}
				System.out.println();
			}
		}
	}
}
