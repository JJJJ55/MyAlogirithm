package Tier_5;

import java.util.Scanner;

public class EX1475 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[10];
		char c[] = sc.next().toCharArray();
		
		for(int i=0;i<c.length;i++) {
			arr[c[i]-'0']++;
		}
		int max = (arr[6]+arr[9])/2+(arr[6]+arr[9])%2;
		for(int i=0;i<arr.length;i++) {
			if(i!=6 && i!=9) max = Math.max(max, arr[i]);
		}
		System.out.println(max);
	}
}
