package Tier_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex7562 {
	static int arr[][],n,cnt;
	static int min;
	static boolean visit[][];
    static int[] di = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dj = {2, 1, -1, -2, -2, -1, 1, 2};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0;t<tc;t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			visit = new boolean[n][n];
			min = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			int si = Integer.parseInt(st.nextToken());
			int sj = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 9;
			
			if(arr[si][sj] == 9 ) {
				System.out.println(0);
			} else {
				bfs(si,sj);
				System.out.println(min);	
			}
		}
	}
	static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {i,j});
		visit[i][j] = true;
		cnt = 1;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0;s<size;s++) {
				int info[] = q.poll();
				for(int d=0;d<8;d++) {
					int ni = info[0]+di[d];
					int nj = info[1]+dj[d];
					
					if(ni>=0 && ni<n && nj>=0 && nj<n && !visit[ni][nj]) {
						if(arr[ni][nj]==9) {
							min = Math.min(min, cnt);
						} else {
							q.offer(new int[] {ni,nj});
							visit[ni][nj] = true;
						}
						
					}
				}
			}
			cnt++;
		}
	}
}
