package Tier_2;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Ex15666 {
	static int arr[],num[],n,m;
	static LinkedHashSet<String> set = new LinkedHashSet<String>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n];
		num = new int[m];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		func(0,0);
		
//		for(String s : set) {
//			System.out.println(s);
//		}
		System.out.println(sb);
	}
	
	static void func(int idx,int start) {
		if(idx==m) {
			for(int i: num) {
				sb.append(i+" ");
			}
			sb.append("\n");
//			set.add(sb.toString());
			return;
		}
		int pre = 0;
		for(int i=start;i<n;i++) {
			if(pre != arr[i]) {
				pre = arr[i];
				num[idx] = pre;
				func(idx+1,i);
			}
		}
	}
}
