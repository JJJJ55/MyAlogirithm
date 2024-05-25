package Tier_2;

import java.util.Arrays;
import java.util.Scanner;

public class Ex6603 {
	static int arr[],num[],n;
	static boolean visit[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			n = sc.nextInt();
			if(n==0) break;
			
			arr = new int[n];
			num = new int[6];
			visit = new boolean[n];
			
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			
			func(0,0);
			System.out.println();
		}
	}
	
	static void func(int idx,int start) {
		if(idx==6) {
			for(int i=0;i<6;i++) {
				System.out.print(num[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=start;i<n;i++) {
			if(!visit[i]) {
				visit[i] = true;
				num[idx] = arr[i];
				func(idx+1,i);
				visit[i] = false;
			}
		}
	}
}
