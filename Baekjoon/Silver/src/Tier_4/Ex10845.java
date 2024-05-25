package Tier_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex10845 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> q = new ArrayDeque<Integer>();
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push":
				q.add(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(q.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(q.poll()).append("\n");
				}
				break;
			case "size":
				sb.append(q.size()).append("\n");
				break;
			case "empty":
				if(q.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
				break;
			case "front":
				if(q.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(q.peek()).append("\n");
				}
				break;
			case "back":
				if(q.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(q.peekLast()).append("\n");
				}
				break;
			}
		}
		System.out.println(sb);
	}
}
