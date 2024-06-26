package Tier_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex1707 {
	static int v,e;
	static List<Integer> list[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=0;t<TC;t++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			
			list = new List[v+1];
			for(int i=1;i<=v;i++) {
				list[i] = new ArrayList<Integer>();
			}
			
			for(int i=0;i<e;i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				list[from].add(to);
				list[to].add(from);
			}
			int color[] = new int[v+1];
			boolean ok = true;
			
			for(int i=1;i<=v;i++) {
				if(color[i] == 0) {
					dfs(color,i,1);
				}
			}
			
			for(int i=1;i<=v;i++) {
				for(int j : list[i]) {
					if(color[i] == color[j]) {
						ok = false;
					}
				}
			}
			
			if(ok) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
	
	static void dfs(int[] color, int x, int c) {
		color[x] = c;
		for(int y : list[x]) {
			if(color[y] == 0) {
				dfs(color,y,3-c);
			}
		}
	}
}
