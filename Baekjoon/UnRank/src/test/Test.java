package test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test {
	static int n, m;
	static int arr[];
	static boolean visit[];
	static int num[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		arr = new int[n];
		visit = new boolean[n];
		num = new int[m];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		perm(0);

		System.out.println(sb);
	}

	static void perm(int idx) {
		if (idx == m) {
			for (int i : num) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			
			num[idx] = arr[i];
			perm(idx + 1);

		}
	}
}
