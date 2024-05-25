package Tier_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Ex1927 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			int a = Integer.parseInt(br.readLine());
			if(a==0) {
				if(pq.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(pq.poll()).append("\n");
				}
			} else {
				pq.add(a);
			}
		}
		System.out.println(sb);
	}
}
