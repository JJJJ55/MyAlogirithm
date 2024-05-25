package Tier_5;

import java.io.IOException;
import java.util.Scanner;

public class Ex5522 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int total = 0; // 총점
		for (int i = 1; i <= 5; i++) {
			total += sc.nextInt();
		}
		System.out.print(total);
	}
}
