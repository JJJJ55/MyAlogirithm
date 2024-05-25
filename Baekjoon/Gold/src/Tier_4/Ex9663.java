package Tier_4;

import java.util.Scanner;

public class Ex9663 {
	static int arr[],n,cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		arr = new int[n];
		
		dfs(0);
		System.out.println(cnt);
		
	}
	static void dfs(int idx) {
		if(idx == n) {
			cnt++;
			return;
		}
		for(int i=0;i<n;i++) {
			arr[idx] = i;
			if(check(idx)) {
				dfs(idx+1);
			}
		}
	}
	
	static boolean check(int tmp) {
		for(int i=0;i<tmp;i++) {
			if(arr[tmp]==arr[i]) {
				return false;
			}
			else if(Math.abs(i-tmp) == Math.abs(arr[i]-arr[tmp])) {
				return false;
			}
		}
		return true;
	}
}
