package D2;

import java.util.Scanner;

public class Ex1204 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int score[] = new int[101];
			int max = 0;
			int num = 0;
			for (int j = 0; j < 1000; j++) {
				score[sc.nextInt()]++;
			}
			for (int j = 100; j > 0; j--) {
				if (score[j] > max) {
					max = score[j];
					num = j;
				}
			}

			System.out.println("#" + (i + 1) + " " + num);
		}
	}
}
