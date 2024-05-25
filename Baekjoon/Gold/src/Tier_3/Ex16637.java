package Tier_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ex16637 {
	static ArrayList<Integer> num = new ArrayList<Integer>();
	static ArrayList<Character> op = new ArrayList<Character>();
	static int n;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		char c[] = br.readLine().toCharArray();
		for(int i=0;i<n;i++) {
			if(i%2==0) {
				num.add(c[i]-'0');
			} else {
				op.add(c[i]);
			}
		}
		
		dfs(num.get(0),0);
		
		System.out.println(max);
		
	}
	
	static void dfs(int result,int idx) {
		if(idx>=op.size()) {
			max = Math.max(max, result);
			return;
		}
		
		int res1 = calc(result, num.get(idx+1),op.get(idx));
		dfs(res1,idx+1);
		
		if(idx+1 < op.size()) {
			int res2 = calc(num.get(idx+1),num.get(idx+2),op.get(idx+1));
			dfs(calc(result,res2,op.get(idx)),idx+2);
		}
	}
	
	static int calc(int n1, int n2, char op) {
		switch (op) {
		case '+':
			return n1+n2;
		case '*':
			return n1*n2;
		case '-':
			return n1-n2;
		}
		return -1;
	}
}
