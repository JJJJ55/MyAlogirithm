package Tier_4;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Ex1715 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Long> q = new PriorityQueue<Long>();
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			q.add(sc.nextLong());
		}
		
		long sum = 0;
		while(q.size()>1) {
			long n1 = q.poll();
			long n2 = q.poll();
			sum+=n1+n2;
			q.add(n1+n2);
		}
		System.out.println(sum);
	}
}
