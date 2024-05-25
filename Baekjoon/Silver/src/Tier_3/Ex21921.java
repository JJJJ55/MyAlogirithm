package Tier_3;

import java.util.Scanner;

public class Ex21921 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int x = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = 0;
		for(int i=0;i<x;i++	) {
			max+=arr[i];
		}
		int sum = max;
		int cnt = 1;
		for(int si=0,ei=x;ei<n;) {
			sum-=arr[si++];
			sum+=arr[ei++];
			if(max<sum) {
				max = sum;
				cnt=1;
			} else if(max==sum) {
				cnt++;
			}
		}
		
		if(max==0) {
			System.out.println("SAD");
		}else {
			System.out.println(max+"\n"+cnt);
		}
	}
}
