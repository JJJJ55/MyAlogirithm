package Tier_3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Ex2346 {
	public static void main(String[] args) {
		Deque<int[]>dq = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for(int i=0;i<t;i++) {
			int arr[] = {i+1,sc.nextInt()};
			dq.add(arr);
		}
		
		for(int i=1;i<t;i++) {
			int arr[] = dq.pollFirst();
			int n = arr[1];
			sb.append(arr[0]+" ");
			if(n>0) {
				for(int j=1;j<n;j++) {
					dq.offerLast(dq.pollFirst());
				}
			} else {
				for(int j=0;j<n*(-1);j++) {
					dq.offerFirst(dq.pollLast());
				}
			}
		}
		sb.append(dq.pop()[0]);
		System.out.println(sb);
	}
}
