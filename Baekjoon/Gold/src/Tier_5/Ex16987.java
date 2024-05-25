package Tier_5;

import java.util.Arrays;
import java.util.Scanner;

public class Ex16987 {
	static int arr[][],n,max = Integer.MIN_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		arr = new int[n][2];
		for(int i=0;i<n;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			
		}
		
		
		func(0,0);
		System.out.println(max);
	}
	
	static void func(int idx, int cnt) {
		if(max<cnt) max = cnt;
		
		if(idx==n) return;
		if(arr[idx][0]<=0) {
			func(idx+1,cnt);
		} else {
			for(int i=0;i<n;i++) {
				if(idx==i || arr[i][0]<=0) continue;
				arr[idx][0] -=arr[i][1];
				arr[i][0] -= arr[idx][1];
				
				int count = cnt;
				
				if(arr[idx][0]<=0) count++;
				if(arr[i][0]<=0) count++;
				func(idx+1,count);
				
				arr[idx][0] +=arr[i][1];
				arr[i][0] += arr[idx][1];
			}
		}
	}
}
