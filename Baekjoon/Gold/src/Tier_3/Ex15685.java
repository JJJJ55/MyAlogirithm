package Tier_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex15685 {
	static int arr[],n;
	static int x,y,d,g;
	static int di[] = {0,-1,0,1};
	static int dj[] = {1,0,-1,0};
	static dot dt[];
	static boolean map[][] = new boolean[101][101];
	
	static class dot{
		int x;
		int y;
		int d;
		int g;
		public dot(int x, int y, int d, int g) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.g = g;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dt = new dot[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			
			dt[i] = new dot(y,x,d,g);
			play(dt[i]);
		}
		
		System.out.println(check());
	}
	
	static void play(dot dt) {
		int gen = dt.g;
		ArrayList<Integer> list = new ArrayList<>();
		map[dt.x][dt.y] = true;
		map[dt.x+di[dt.d]][dt.y+dj[dt.d]] = true;
		list.add(dt.d);
		
		int x = dt.x+di[dt.d];
		int y = dt.y+dj[dt.d];
		
		int dir = 0;
		while(gen-->0) {
			for(int i=list.size()-1;i>=0;i--) {
				dir = (list.get(i)+1)%4;
				x = x+di[dir];
				y = y+dj[dir];
				
				map[x][y] = true;
				list.add(dir);
			}
		}
	}
	
	static int check() {
		int count = 0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) {
					count++;
				}
			}
		}
		
		return count;
	}
}
