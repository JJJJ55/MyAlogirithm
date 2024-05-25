package Tier_3;

import java.util.Scanner;
import java.util.Stack;

public class Ex12789 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Stack<Integer>stack1 = new Stack<Integer>();
		Stack<Integer>stack2 = new Stack<Integer>();
		int[] arr = new int[n];
		int num = 1;
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=n-1;i>=0;i--) {
			stack1.push(arr[i]);
		}
		while(num<=n) {
			if(!stack1.empty() && stack1.peek().equals(num)) {
				stack1.pop();
				num++;
			} else if(!stack2.empty() && stack2.peek().equals(num)) {
				stack2.pop();
				num++;
			} else {
				if(stack1.empty() && stack2.peek()!=num) {
					System.out.println("Sad");
					return;
				}
				stack2.push(stack1.pop());
			}

		}
		System.out.println("Nice");
	}
}
