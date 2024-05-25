package Tier_4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Ex13913 {
	static int n,k;
	static int di[] = {-1,1};
	static int parent[];
	static boolean visit[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		parent = new int[100001];
		visit = new boolean[100001];
		
		bfs(n,0);
		
		Stack<Integer>stack = new Stack<Integer>();
		stack.add(k);
		int index = k;
		
		while(index!=n) {
			stack.add(parent[index]);
			index = parent[index];
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}
	
	static void bfs(int i, int cnt) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {i,cnt});
		visit[i] = true;
		
		while(!q.isEmpty()) {
			int info[] = q.poll();
			
			if(info[0] == k) {
				System.out.println(info[1]);
				return;
			}
			
			int ni = info[0]*2;
			if(ni<100001 && !visit[ni]) {
				q.offer(new int[] {ni,info[1]+1});
				parent[ni] = info[0];
				visit[ni] = true;	
			}
			for(int d=0;d<2;d++) {
				int nni = info[0]+di[d];
				if(nni>=0 && nni<100001 && !visit[nni]) {
					q.offer(new int[] {nni,info[1]+1});
					parent[nni] = info[0];
					visit[nni] = true;
				}
			}
		}
	}
}
