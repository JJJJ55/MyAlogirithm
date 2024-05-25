package Tier_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ex28278 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Stack<Integer> stack = new Stack<Integer>();

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String num = br.readLine();
			st = new StringTokenizer(num);

			switch (st.nextToken()) {
			case "1": {
				stack.push(Integer.parseInt(st.nextToken()));
				break;
			}
			case "2": {
				if (stack.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(stack.pop()).append("\n");
				}
				break;
			}
			case "3": {
				sb.append(stack.size()).append("\n");
				break;
			}
			case "4": {
				if (stack.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
				break;
			}
			case "5": {
				if (stack.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(stack.peek()).append("\n");
				}
				break;
			}
			}

		}
		System.out.println(sb.toString());

	}
}
