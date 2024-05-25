package Tier_4;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Ex14226 {
	static class node{
		int board;
		int total;
		int time;
		public node(int board, int total, int time) {
			super();
			this.board = board;
			this.total = total;
			this.time = time;
		}
	}
	static boolean[][] visit = new boolean[1001][1001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int s = sc.nextInt();
		
		bfs(s);
	}
	
	static void bfs(int s) {
		Queue<node> q = new ArrayDeque<node>();
		q.offer(new node(0,1,0));
		visit[0][1] = true;
		
		while(!q.isEmpty()) {
			node cur = q.poll();
			
			if(cur.total == s) {
				System.out.println(cur.time);
				return;
			}
			
			q.offer(new node(cur.total,cur.total,cur.time+1));
			
			if(cur.board !=0 && cur.total+cur.board <=s 
					&& !visit[cur.board][cur.total+cur.board]) {
				q.offer(new node(cur.board,cur.total+cur.board,cur.time+1));
				visit[cur.board][cur.total+cur.board] = true;
			}
			
			if(cur.total-1 >=1 && !visit[cur.board][cur.total-1]) {
				q.offer(new node(cur.board,cur.total-1,cur.time+1));
				visit[cur.board][cur.total-1] = true;
			}
		}
	}
}
