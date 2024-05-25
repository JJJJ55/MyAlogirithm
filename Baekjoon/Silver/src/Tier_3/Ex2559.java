package Tier_3;

import java.util.Scanner;

public class Ex2559 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int sum = 0;

		int arr[] = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			arr[i] = sc.nextInt();
			if(i<=k) {
				sum+=arr[i];
			}
		}
		int max = sum;
		for(int s=1,e=k+1;e<=n;) {
			sum-=arr[s];
			sum+=arr[e];
			s++;
			e++;
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}
