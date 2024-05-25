package Tier_4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Ex28279 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Deque<Integer> dq = new ArrayDeque<Integer>();
		StringBuilder sb = new StringBuilder();
		
		int t = sc.nextInt();
		for(int i=0;i<t;i++) {
			int n = sc.nextInt();
			
			switch (n) {
			case 1: 
				dq.addFirst(sc.nextInt());
				break;
			case 2: 
				dq.addLast(sc.nextInt());
				break;
			case 3:
				sb.append(dq.isEmpty()?-1:dq.pollFirst()).append("\n");
				break;
			case 4:
				sb.append(dq.isEmpty()?-1:dq.pollLast()).append("\n");
				break;
			case 5: 
				sb.append(dq.size()).append("\n");
				break;
			case 6: 
				sb.append(dq.isEmpty()?1:0).append("\n");
				break;
			case 7:
				sb.append(dq.isEmpty()?-1:dq.peekFirst()).append("\n");
				break;
			case 8:
				sb.append(dq.isEmpty()?-1:dq.peekLast()).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}
}
