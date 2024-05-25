package D2;

import java.util.Scanner;

public class Ex12712 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int max = 0;
		int sum = 0;
		for (int t = 0; t < T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			// 십자가
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sum += arr[i][j];
					for (int x = 1; x < m; x++) {
						if (j + x < n) {
							sum += arr[i][j + x];
						}
						if (j - x >= 0) {
							sum += arr[i][j - x];
						}
						if (i + x < n) {
							sum += arr[i + x][j];
						}
						if (i - x >= 0) {
							sum += arr[i - x][j];
						}
					}
					if (max < sum) {
						max = sum;
					}
					sum = 0;
				}
			}
			// X자
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sum += arr[i][j];
					for (int x = 1; x < m; x++) {
						if ((j + x < n) && (i + x < n)) {
							sum += arr[i + x][j + x];
						} 
						if ((j - x >= 0) && (i - x >= 0)) {
							sum += arr[i - x][j - x];
						}
						if ((i + x < n) && (j - x >= 0)) {
							sum += arr[i + x][j - x];
						}
						if ((i - x >= 0) && (j + x <n)) {
							sum += arr[i - x][j + x];
						}
					}
					if (max < sum) {
						max = sum;
					}
					sum = 0;
				}
			}
			System.out.printf("#%d %d\n",t+1,max);
			max = 0;
		}
	}
}
