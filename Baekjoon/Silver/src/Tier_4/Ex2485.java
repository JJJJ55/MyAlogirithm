package Tier_4;

import java.util.Scanner;

public class Ex2485 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		int arr[] = new int[T];
		int side[] = new int[T-1];
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
		for(int i=0;i<side.length;i++) {
			side[i] = Math.abs(arr[i]-arr[i+1]);
		}
		
		int ans = side[0];
		for(int i=1;i<side.length;i++) {
			ans = gcd(ans,side[i]);
		}
		int a = arr[0];
		int count = 1;
		while(a!=arr[arr.length-1]) {
			count++;
			a+=ans;
		}
		
		System.out.println(count-arr.length);
	}
	
	static int gcd(int a, int b) {
		while(b!=0) {
			 int r=a%b;
			 a=b;
			 b=r;
		 }
		return a;
	}

}
