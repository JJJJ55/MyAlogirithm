package Tier_5;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Ex13549 {
	static int n,k;
	static boolean visit[] = new boolean[100001];
	static int dd[] = {-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		
		bfs(n);
	}
	
	static void bfs(int n) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {n,0});
		visit[n] = true;
		while(!q.isEmpty()) {
			int info[] = q.poll();
			
			if(info[0] == k) {
				System.out.println(info[1]);
				return;
			}
			
			int move = info[0]*2;
			if(move<visit.length && !visit[move]) {
				visit[move] = true;
				q.offer(new int[] {move,info[1]});
			}
			for(int d=0;d<2;d++) {
				int next = info[0]+dd[d];
				
				if(next>=0 && next<visit.length && !visit[next]) {
					visit[next] = true;
					q.offer(new int[] {next,info[1]+1});
				}
			}
		}
	}
}
