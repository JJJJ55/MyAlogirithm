package D2;

import java.util.Arrays;
import java.util.Scanner;

public class Ex1984 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0;t<T;t++) {
			int arr[] = new int[10];
			int sum = 0;
			for(int i=0;i<arr.length;i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			for(int i=1;i<arr.length-1;i++) {
				sum+=arr[i];
			}
			System.out.printf("#%d %.0f\n",t+1,(double)sum/8);
		}
	}
}
