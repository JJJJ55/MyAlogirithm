package Tier_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex15688 {
	static class human implements Comparable<human>{
		int age,order;
		String name;
		
		public human(int age, String name,int order) {
			this.age = age;
			this.name = name;
			this.order = order;
		}

		@Override
		public int compareTo(human o) {
			if(this.age == o.age) {
				return this.order - o.order;
			} else {
				return this.age - o.age;
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		PriorityQueue<human> h = new PriorityQueue<human>();
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			h.add(new human(age,name,cnt++));
		}
		
		for(int i=0;i<n;i++) {
			human str = h.poll();
			sb.append(str.age+" "+str.name).append("\n");
		}
		System.out.println(sb);
	}
}
