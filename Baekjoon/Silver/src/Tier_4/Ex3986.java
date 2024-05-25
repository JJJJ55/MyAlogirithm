package Tier_4;

import java.util.Scanner;
import java.util.Stack;

public class Ex3986 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int cnt = 0;
		for(int i=0;i<n;i++) {
			String str = sc.next();
			Stack<Character>stack = new Stack<Character>();
			for(int j=0;j<str.length();j++) {
				if(stack.isEmpty()) {
					stack.add(str.charAt(j));
				} else {
					if(str.charAt(j)=='A') {
						if(stack.peek()=='A') {
							stack.pop();
						} else {
							stack.add(str.charAt(j));
						}
					} else {
						if(stack.peek()=='B') {
							stack.pop();
						} else {
							stack.add(str.charAt(j));
						}
					}
				}
			}
			if(stack.isEmpty()) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
