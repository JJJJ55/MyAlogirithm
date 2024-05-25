package Tier_3;

import java.util.Arrays;
import java.util.Scanner;

public class Ex3273 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int x = sc.nextInt();
		
		int sum = 0;
		int cnt = 0;
		for(int si = 0,ei=arr.length-1;si<ei;) {
			sum = arr[si]+arr[ei];
			if(sum<x) {
				si++;
			} else if(sum>x) {
				ei--;
			} else if(sum==x) {
				si++;
				ei--;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
