package Tier_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex16235 {
	static int arr[][],a[][],n,m,k;
	static int di[] = {-1,1,0,0,-1,-1,1,1};
	static int dj[] = {0,0,-1,1,-1,1,-1,1};
	
	static Deque<tree> on = new LinkedList<tree>();
	static Queue<tree> off;
	static class tree{
		int x,y,age;

		public tree(int x, int y, int age) {
			super();
			this.x = x;
			this.y = y;
			this.age = age;
		}
		@Override
		public String toString() {
			return "tree [x=" + x + ", y=" + y + ", age=" + age + "]";
		}
//		@Override
//		public int compareTo(tree o) {
//			return this.age - o.age;
//		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][n+1];
		a = new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				arr[i][j] = 5;
			}
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			on.add(new tree(x,y,age));
		}
		
		
		for(int i=0;i<k;i++) { // 플레이
			off = new LinkedList<tree>();
			//봄
			for(int s=0;s<on.size();s++) {
				tree t = on.poll();
//				System.out.println(t.toString());
				if(arr[t.x][t.y]>=t.age) {
					arr[t.x][t.y]-=t.age;
					t.age++;
					on.add(t);
				} else {
					off.add(t);
					s--;
				}
			}
			
			//여름
			for(tree t : off) {
				arr[t.x][t.y]+=t.age/2; 
			}
			
			//가을

			LinkedList<tree> temp = new LinkedList<tree>();
			
			for(tree t: on) {
				if(t.age%5==0) {
					temp.add(t);
				}
			}
			
			while(!temp.isEmpty()) {
				tree t = temp.poll();
				for(int d=0;d<8;d++) {
					int ni = t.x+di[d];
					int nj = t.y+dj[d];
					if(ni>=1 && ni<=n && nj>=1 && nj<=n) {
						on.addFirst(new tree(ni,nj,1));
					}
				}
			}

//			System.out.println(i+"년 차 "+on.toString());
			
			//겨울
			for(int x=1;x<=n;x++) {
				for(int y=1;y<=n;y++) {
					arr[x][y] += a[x][y];
				}
			}
		}
		System.out.println(on.size());
	}
}
