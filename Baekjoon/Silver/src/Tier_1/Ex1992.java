package Tier_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1992 {
	static int arr[][], n, w, b;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			char c[] = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				arr[i][j] = c[j]-'0';
			}
		}

		func(0, 0, n);
		System.out.println(sb);
	}

	static void func(int r, int c, int n) {
		if (check(r, c, n)) {
			if (arr[r][c] == 0) {
				sb.append(0);
			} else {
				sb.append(1);
			}
			return;
		}
		sb.append("(");

		int size = n / 2;

		func(r, c, size);
		func(r, c + size, size);
		func(r + size, c, size);
		func(r + size, c + size, size);
		sb.append(")");
	}

	static boolean check(int r, int c, int size) {
		int num = arr[r][c];

		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (arr[i][j] != num) {
					return false;
				}
			}
		}

		return true;
	}
}
