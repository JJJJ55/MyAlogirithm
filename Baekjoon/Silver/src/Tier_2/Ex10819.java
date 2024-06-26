package Tier_2;

import java.util.Arrays;
import java.util.Scanner;

public class Ex10819 {
	static int arr[],n,max;
	static int num[];
	static boolean visit[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		num = new int[n];
		visit = new boolean[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		dfs(0);
		
		System.out.println(max);
	}
	
	static void dfs(int idx) {
		if(idx==n) {
//			System.out.println(Arrays.toString(num));
			int sum = 0;
			for(int i=0;i<n-1;i++) {
				sum+=Math.abs(arr[num[i]]-arr[num[i+1]]);
			}
			max = Math.max(max, sum);
			return;
		}
		for(int i=0;i<n;i++	) {
			if(!visit[i]) {
				visit[i] = true;
				num[idx] = i;
				dfs(idx+1);
				visit[i] =false;
			}
		}
	}
}
