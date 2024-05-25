package Tier_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex10773 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Integer>stack = new Stack<Integer>();
		
		int T = Integer.parseInt(br.readLine());
		int sum = 0;
		
		for(int i=0;i<T;i++) {
			int n = Integer.parseInt(br.readLine());
			if(n!=0) {
				stack.push(n);
			} else {
				stack.pop();
			}
		}
		for(int i : stack) {
			sum+=i;
		}
		System.out.println(sum);
	}

}
