package Tier_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex5567 {
	static int arr[][],n,m;
	static int count;
	static boolean visit[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		arr = new int[n+1][n+1];
		visit = new boolean[n+1];
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = arr[b][a] = 1;
		}
		
		bfs(1);
		
		System.out.println(count);
	}
	
	static void bfs(int tmp) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(tmp);
		visit[tmp] = true;
		int dep = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0;s<size;s++) {
				int temp = q.poll();
				for(int i=1;i<=n;i++) {
					if(arr[temp][i]==1 && !visit[i]) {
						q.offer(i);
						visit[i]=true;
						count++;
					}
				}
			}
			dep++;
			if(dep==2) {
				return;
			}
		}
	}
}
