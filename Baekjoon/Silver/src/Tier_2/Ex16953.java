package Tier_2;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Ex16953 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextInt();
		long b = sc.nextInt();
		long ans = 0;
		Queue<Long> q = new ArrayDeque<Long>();
		q.add( a);
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0;s<size;s++) {
				long num = q.poll();
				if(num>b) continue;
				if(num==b) {
					System.out.println(ans+1);
					return;
				}
				q.add(num*2);
				q.add((num*10)+1);
			}
			ans++;
		}
		System.out.println(-1);
	}
}