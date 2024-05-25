package Tier_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex11650 {
	static class func implements Comparable<func>{
		int x,y;
		
		public func(int x,int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(func o) {
			if(this.x == o.x) {
				return this.y - o.y;
			} else {
				return this.x - o.x;
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		PriorityQueue<func> f = new PriorityQueue<func>();
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			f.add(new func(x,y));
		}
		
		for(int i=0;i<n;i++) {
			func arr = f.poll();
			sb.append(arr.x+" "+arr.y).append("\n");
		}
		System.out.println(sb);
	}
}
