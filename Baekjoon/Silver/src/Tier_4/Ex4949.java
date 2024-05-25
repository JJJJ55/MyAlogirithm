package Tier_4;

import java.util.Scanner;
import java.util.Stack;

public class Ex4949 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(true) {
			Stack<Character> stack = new Stack<Character>();
			String s = sc.nextLine();
			if(s.equals(".")) {
				break;
			}
			for(int i=0;i<s.length();i++) {
				char c = s.charAt(i);
				if(c=='(' || c=='[') {
					stack.push(c);
				} else if(c==')') {
					if(stack.empty() || stack.peek()!='(') {
						stack.add(c);
					} else {
						stack.pop();
					}
				} else if(c==']') {
					if(stack.empty() || stack.peek()!='[') {
						stack.add(c);
					} else {
						stack.pop();
					}
				}
			}
			if(stack.empty()) {
				sb.append("yes").append("\n");
			} else {
				sb.append("no").append("\n");
			}
		}
		System.out.println(sb);
	}
}
