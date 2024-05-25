package Tier_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Ex1021 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> dq = new LinkedList<Integer>();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int arr[] = new int [m];
		
		for(int i=1;i<=n;i++) {
			dq.offer(i);
		}
		int left = 0;
		int right = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			
			if(dq.peek() == tmp) {
				dq.poll();
				continue;
			}
			int half = dq.size()/2;
			if(dq.indexOf(tmp) >= half+1) {
				while(!dq.isEmpty() && tmp!=dq.peek()) {
					dq.addFirst(dq.pollLast());
					left++;
				}
				dq.poll();
			} else {
				while(!dq.isEmpty() && tmp!=dq.peek()) {
					dq.addLast(dq.pollFirst());
					right++;
				}
				dq.poll();
			}
		}
		System.out.println(left+right);
	}
}
