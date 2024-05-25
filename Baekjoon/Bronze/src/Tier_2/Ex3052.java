package Tier_2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ex3052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i=0;i<10;i++) {
			int n = sc.nextInt();
			set.add(n%42);
		}
		System.out.println(set.size());
	}
}
