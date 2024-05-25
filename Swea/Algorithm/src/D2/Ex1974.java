package D2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ex1974 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int arr[][] = new int[9][9];

		for (int i = 0; i < T; i++) {
			int count = 1;
			Set<Integer> set1 = new HashSet<Integer>();
			Set<Integer> set2 = new HashSet<Integer>();
			Set<Integer> set3 = new HashSet<Integer>();
			for (int x = 0; x < 9; x++) {
				for (int y = 0; y < 9; y++) {
					arr[x][y] = sc.nextInt();
				}
			}

			for (int x = 0; x < 9; x++) {
				for (int y = 0; y < 9; y++) {
					set1.add(arr[x][y]);

				}
				if (set1.size() != 9) {
					count = 0;
					System.out.println("#" + (i + 1) + " " + count);
					break;
				}
				set1.clear();
			}
			if (count == 0)
				continue;
			for (int x = 0; x < 9; x++) {
				for (int y = 0; y < 9; y++) {
					set2.add(arr[y][x]);
				}
				if (set2.size() != 9) {
					count = 0;
					System.out.println("#" + (i + 1) + " " + count);
					break;
				}
				set2.clear();
			}
			if (count == 0)
				continue;
			for (int x = 0; x < 9; x += 3) {
				for (int y = 0; y < 9; y += 3) {
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							set3.add(arr[a + x][b + y]);
						}
					}
					if (set3.size() != 9) {
						count = 0;
						System.out.println("#" + (i + 1) + " " + count);
						break;
					}
					set3.clear();
				}
				if (count == 0)
					break;
			}
			if(count==1) System.out.println("#" + (i + 1) + " " + count);
		}
	}
}
