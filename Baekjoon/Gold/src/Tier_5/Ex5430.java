package Tier_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Ex5430 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> dq = new ArrayDeque<Integer>();
		int TC = Integer.parseInt(br.readLine());
		
		start : for(int t=0;t<TC;t++) {
			String str = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String num = br.readLine();
			for(String s : num.substring(1, num.length()-1).split(",")) {
				if(s.equals("")) break;
				dq.add(Integer.parseInt(s));
			}
			boolean flag = true;
			for(int i=0;i<str.length();i++) {
				switch (str.charAt(i)) {
				case 'R':
					flag = !flag;
					break;
				case 'D':
					if(flag) {
						if(dq.isEmpty()) {
							sb.append("error").append("\n");
							continue start;
						} else {
							dq.pollFirst();
						}
					} else {
						if(dq.isEmpty()) {
							sb.append("error").append("\n");
							continue start;
						} else {
							dq.pollLast();
						}
					}
					break;
				}
			}
			
			if(dq.isEmpty()) {
				sb.append("[]").append("\n");
				continue;
			}
			
			sb.append("[");
			for(int i=0;i<dq.size()-1;i++) {
				if(flag) {
					sb.append(dq.pollFirst()+",");
					i--;
				} else {
					sb.append(dq.pollLast()+",");
					i--;
				}
			}
			sb.append(dq.poll()+"]").append("\n");
		}
		System.out.println(sb);
	}
}
