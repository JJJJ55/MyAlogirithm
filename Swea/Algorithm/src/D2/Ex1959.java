package D2;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex1959 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		int sum = 0;
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		for (int i = 0; i < T; i++) {
			int max = 0;
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			for (int j = 0; j < n1; j++) {
				list1.add(sc.nextInt());
			}
			for (int j = 0; j < n2; j++) {
				list2.add(sc.nextInt());
			}

			if (list1.size() >= list2.size()) {
				int a = list1.size() - list2.size();
				for (int j = 0; j <= a; j++) {
					for (int x = 0; x < list2.size(); x++) {
						sum += list1.get(x + j) * list2.get(x);
					}
					if (max < sum) {
						max = sum;
					}
					sum = 0;
				}
			} else if (list1.size() < list2.size()) {
				int a = list2.size() - list1.size();
				for (int j = 0; j <= a; j++) {
					for (int x = 0; x < list1.size(); x++) {
						sum += list1.get(x) * list2.get(x + j);
					}
					if (max < sum) {
						max = sum;
					}
					sum = 0;
				}
			}
			System.out.println("#" + (i + 1) + " " + max);
			list1.clear();
			list2.clear();
		}
	}

}
