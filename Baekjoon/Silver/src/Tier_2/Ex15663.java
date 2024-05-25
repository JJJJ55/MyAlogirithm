package Tier_2;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Ex15663 {
	static int arr[],num[],n,m;
	static boolean visit[];
	static LinkedHashSet<String> set = new LinkedHashSet<String>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n];
		num = new int[m];
		visit = new boolean[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		func(0);
		
		for(String s : set) {
			System.out.println(s);
		}
	}
	
	static void func(int idx) {
		if(idx==m) {
			StringBuilder sb = new StringBuilder();
			for(int i: num) {
				sb.append(i+" ");
			}
			set.add(sb.toString());
			return;
		}
		for(int i=0;i<n;i++) {
			if(!visit[i]) {
				num[idx] = arr[i];
				visit[i] = true;
				func(idx+1);
				visit[i] = false;
			}
		}
	}
}
