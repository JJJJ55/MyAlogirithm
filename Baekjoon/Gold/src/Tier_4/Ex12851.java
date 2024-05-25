package Tier_4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;

public class Ex12851 {
	static int n, k;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static int min = Integer.MAX_VALUE/16,next,count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		if(n>=k) {
			System.out.println(n-k);
			System.out.println(1);
			return;
		}
		
		bfs();
		
		System.out.println(min);
		System.out.println(count);
		
		
	}
	
	static void bfs() {
		
		Queue<Integer> q = new ArrayDeque<Integer>();
		int arr[] = new int[100001];
		count = 0;
		q.offer(n);
		arr[n]=1;
		
		while(!q.isEmpty()) {
			int time = q.poll();
			if(min < arr[time]) {
				return;
			}
			for(int i=0;i<3;i++) {
				switch (i) {
				case 0:
					next = time+1;
					break;
				case 1:
					next = time-1;
					break;
				case 2:
					next = time*2;
					break;
				}
				
				if(next == k) {
					min = arr[time];
					count++;
				}
				
				if(next>=0 && next<=100000 && (arr[next]==0 || arr[next] == arr[time]+1)) {
					q.offer(next);
					arr[next] = arr[time] +1;
				}
			}
		}
	}
}
