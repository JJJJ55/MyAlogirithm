package Tier_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex13335 {
	static int n,w,l;
	static Queue<Integer> q = new ArrayDeque<Integer>();
	static Queue<Integer> bridge = new ArrayDeque<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			q.add(Integer.parseInt(st.nextToken()));
		}
		
		int time = 0;
		int weight = 0;
		
		for(int i=0;i<w;i++) {
			bridge.add(0);
		}
		while(!bridge.isEmpty()) {
			weight-=bridge.poll();
			if(!q.isEmpty()) {
				if(l>=weight+q.peek()) {
					weight+=q.peek();
					bridge.add(q.poll());
				} else {
					bridge.add(0);
				}
			}
			time++;
		}
		System.out.println(time);
		
	}
}
