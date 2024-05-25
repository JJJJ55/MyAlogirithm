package Tier_2;

import java.util.Scanner;
import java.util.Stack;

public class Ex1874 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int m = 0;
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=1;i<=n;i++) {
			stack.push(i);
			sb.append("+").append("\n");
			while(!stack.isEmpty() && stack.peek() == arr[m]) {
				stack.pop();
				sb.append("-").append("\n");
				m++;
			}
			
		}
		
		if(stack.empty()) {
			System.out.println(sb);
		} else {
			System.out.println("NO");
		}
	}
}
