package Tier_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ex2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int arr[] = new int[9];
		ArrayList<Integer> list = new ArrayList<Integer>();
		int sum = 0;
		for(int i=0;i<9;i++) {
			arr[i] = sc.nextInt();
			sum+=arr[i];
		}
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(sum-(arr[i]+arr[j])==100) {
					for(int x = 0;x<arr.length;x++) {
						if(arr[x]==arr[i] || arr[x]==arr[j]) continue;
						list.add(arr[x]);
					}
					Collections.sort(list);
					for(int a=0;a<list.size();a++) {
						System.out.println(list.get(a));
					}
					return;
				}
			}
		}

	}
}
