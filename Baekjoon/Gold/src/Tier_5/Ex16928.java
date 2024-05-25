package Tier_5;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Ex16928 {
	static int arr[] = new int[101];
	static int ladder[][], snake[][], n,m;
	static int min = Integer.MAX_VALUE;
	static boolean visit[] = new boolean[101];
	
	static class pp{
		int i;
		int num;
		pp(int i, int num) {
			this.i = i;
			this.num = num;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		ladder = new int[n][2];
		snake = new int[m][2];
		for(int i=0;i<n;i++) {
			ladder[i][0] = sc.nextInt();
			ladder[i][1] = sc.nextInt();
		}
		
		for(int i=0;i<m;i++) {
			snake[i][0] = sc.nextInt();
			snake[i][1] = sc.nextInt();
		}
		
		bfs(1);
		System.out.println(min);
	}
	
	static void bfs(int i) {
		Queue<pp> q = new ArrayDeque<pp>();
		q.offer(new pp(i,0));
		visit[i] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0;s<size;s++) {
				pp num = q.poll();
				for(int j=0;j<n;j++) {
					if(num.i == ladder[j][0]) {
						num.i = ladder[j][1];
					}
				}
				for(int j=0;j<m;j++) {
					if(num.i == snake[j][0]) {
						num.i = snake[j][1];
					}
				}
				
				if(num.i==100) {
					min = Math.min(min, num.num);
				}
				
				int tmp;
				for(int d=1;d<=6;d++) {
					tmp = num.i+d;
					
					if(tmp>=1 && tmp<=100 && !visit[tmp]) {
						q.offer(new pp(tmp,num.num+1));
						visit[tmp] = true;
					}
				}
			}
		}
	}
}
