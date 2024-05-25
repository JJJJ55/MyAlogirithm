package Tier_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Ex11559 {
	static char arr[][], color[] = {'R','G','B','P','Y'};
	static boolean visit[][], flag;
	static int di[] = {-1,1,0,0};
	static int dj[] = {0,0,-1,1};
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new char[12][6];
		
		for(int i=0;i<arr.length;i++) {
			char c[] = br.readLine().toCharArray();
			for(int j=0;j<arr[0].length;j++) {
				arr[i][j] = c[j];
			}
		}
		
		game();
		
		System.out.println(cnt);
	}
	
	static void game() {
		while(true) {
//			down();
			flag  = false;
			visit = new boolean[12][6];
			for(int d=0;d<color.length;d++) {
				char c = color[d];
				for(int i=0;i<12;i++) {
					for(int j=0;j<6;j++) {
						if(arr[i][j]==c && !visit[i][j]) {
							bfs(i,j,c);
						}
					}
				}
			}
			
			if(flag) {
				cnt++;
				down();
//				print();
			} else {
				break;
			}
		}
	}
	
	static void bfs(int i, int j,char c) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		List<int[]> list = new ArrayList<int[]>();
		q.offer(new int[] {i,j});
		visit[i][j] = true;
		
		while(!q.isEmpty()) {
			int info[] = q.poll();
			list.add(info);
			
			for(int d=0;d<4;d++) {
				int ni = info[0]+di[d];
				int nj = info[1]+dj[d];
				
				if(ni>=0 && ni<12 && nj>=0 &&nj<6&& !visit[ni][nj] && arr[ni][nj]==c) {
					q.offer(new int[] {ni,nj});
					visit[ni][nj] = true;
				}
			}
		}
		
		if(list.size()>=4) {
			for(int x=0;x<list.size();x++) {
				int si = list.get(x)[0];
				int sj = list.get(x)[1];
				
				arr[si][sj] = '.';
			}
//			cnt++;
			flag = true;
		}
	}
	
	static void down() {
		for(int i=0;i<6;i++) {
			int idx = 0;
			char tmp[] = new char[12];
			for(int j=11;j>=0;j--) {
				if(arr[j][i]!='.') {
					tmp[idx++] = arr[j][i];
					arr[j][i]='.';
				}
			}
			for(int j=0;j<idx;j++) {
				arr[11-j][i] = tmp[j];
			}
		}
	}
	
	static void print() {
		for(int i=0;i<12;i++) {
			for(int j=0;j<6;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println("=====");
	}
}
