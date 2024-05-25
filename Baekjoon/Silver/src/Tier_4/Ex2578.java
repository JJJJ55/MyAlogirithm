package Tier_4;

import java.util.Scanner;

public class Ex2578 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int check1 = 0;
		int check2 = 0;
		int check3 = 0;
		int check4 = 0;

		int bingo = 0;
		int arr[][] = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int t = 1; t <= 25; t++) {
			int n = sc.nextInt();
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (arr[i][j] == n) {
						arr[i][j] = 0;

						for (int a = 0; a < 5; a++) {
							if (arr[i][a] == 0) {
								check1++;
							}
							if (check1 == 5) {
								bingo++;
							}
							if (arr[a][j] == 0) {
								check2++;
							}
							if (check2 == 5) {
								bingo++;
							}
						}
						check1 = 0;
						check2 = 0;
						if (i == j) {
							for (int a = 0; a < 5; a++) {
								if (arr[a][a] == 0) {
									check3++;
								} else {
									check3 = 0;
									break;
								}
							}
							if (check3 == 5) {
								bingo++;
							} else {
								check3 = 0;
							}
						} 
						if (i + j == 4) {
							for (int a = 0; a < 5; a++) {
								if (arr[a][4 - a] == 0) {
									check4++;
								} else {
									check4 = 0;
									break;
								}
							}
							if (check4 == 5) {
								bingo++;
							} else {
								check4 = 0;
							}
						}
					}
				}
			}
			if (bingo >= 3) {
				System.out.println(t);
				return;
			}
		}
	}
}
