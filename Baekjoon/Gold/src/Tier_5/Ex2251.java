package Tier_5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;

public class Ex2251 {
	static int a,b,c;
	static int num[] = new int[3];
	static ArrayList<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		
		bfs();
		
		Collections.sort(list);
		for(int i : list) {
			System.out.print(i+" ");
		}
	}
	static void bfs() {
		Queue<int[]> q = new ArrayDeque<int[]>();
		boolean [][][] visit = new boolean[a+1][b+1][c+1];
		q.add(new int[] {0,0,c});
		
		while(!q.isEmpty()) {
			int info[] = q.poll();
			if(visit[info[0]][info[1]][info[2]]) {
				continue;
			}
			if(info[0]==0) {
				list.add(info[2]);
			}
			visit[info[0]][info[1]][info[2]] = true;
			
			if(info[0]+info[1]<=a) { // b a
				q.add(new int[] {info[0]+info[1],0,info[2]});
			} else {
				q.add(new int[] {a,info[0]+info[1]-a,info[2]});
			}
			
			if(info[0]+info[2]<=a) { // c a
				q.add(new int[] {info[0]+info[2],info[1],0});
			} else {
				q.add(new int[] {a,info[1],info[0]+info[2]-a});
			}
			
			if(info[0]+info[1]<=b) { // a b
				q.add(new int[] {0,info[0]+info[1],info[2]});
			} else {
				q.add(new int[] {info[0]+info[1]-b,b,info[2]});
			}
			
			if(info[1]+info[2]<=b) { // c b
				q.add(new int[] {info[0],info[1]+info[2],0});
			} else {
				q.add(new int[] {info[0],b,info[1]+info[2]-b});
			}
			
			if(info[0]+info[2]<=c) { // a c
				q.add(new int[] {0,info[1],info[0]+info[2]});
			} else {
				q.add(new int[] {info[0]+info[2]-c,info[1],c});
			}
			
			if(info[1]+info[2]<=c) { // b c
				q.add(new int[] {info[0],0,info[1]+info[2]});
			} else {
				q.add(new int[] {info[0],info[1]+info[2]-c,c});
			}
			
 		}
			
	}
}
