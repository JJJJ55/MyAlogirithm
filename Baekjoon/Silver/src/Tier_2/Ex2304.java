package Tier_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class Ex2304 {
	public static void main(String[] args) {
		Stack<int []> stack = new Stack<int[]>();
		int max = Integer.MIN_VALUE;
		int x = 0;
		int y = 0;
		int cnt = 0;
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		
		int map[][] = new int[1001][1001];
		
		int n =sc.nextInt();
		int arr[][] = new int[n][2];
		for(int i=0;i<n;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			if(max < arr[i][1]) {
				max = arr[i][1];
				x = arr[i][0];
				y = arr[i][1];
			}
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(Integer.compare(o1[0], o2[0])==1) {
					return -1;
				} else {
					return 1;
				}
			}
			
		});
		
		for(int i=0;i<n;i++) {
			stack.add(new int[] {arr[i][0],arr[i][1]});
		}
		
		while(!stack.isEmpty()) {
			int num[] = stack.pop();
			if(num[0]==x && num[1]==y && flag) {
				flag = false;
			}
			if(flag) {
				for(int i = num[0];i<x;i++) {
					for(int j=0;j<num[1];j++) {
						map[i][j]++;
					}
				}
			} else {
				for(int i = num[0];i>x;i--) {
					for(int j=0;j<num[1];j++) {
						map[i][j]++;
					}
				}
			}
		}
		
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				if(map[i][j]>0) {
					cnt++;
				}
			}
		}
		System.out.println(cnt+max);
	}
}
