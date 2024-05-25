package Tier_1;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Ex1697 {
	static int n, m, cnt=1;
	static boolean check[];
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		check = new boolean[100001];
		
		if(n==m) {
			System.out.println(0);
			return;
		}
		
		bfs(n);
		System.out.println(min);
	}
	
	static void bfs(int n) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(n);
		check[n]=true;;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0;s<size;s++) {
				int a = q.poll();
				for(int i=0;i<3;i++) {
					int nn = 0;
					if(i==0) {
						nn = a+1;
					} else if(i==1) {
						nn = a-1;
					} else {
						nn = a*2;
					}
					
					if(nn == m) {
						min = Math.min(min, cnt);
					}
					
					if(nn>=0 && nn<check.length && !check[nn]) {
						q.add(nn);
						check[nn]= true;
					}
				}
			}
			cnt++;
		}
	}
}
