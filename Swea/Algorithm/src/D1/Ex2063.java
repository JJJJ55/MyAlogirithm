package D1;

import java.util.Arrays;
import java.util.Scanner;

public class Ex2063 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		System.out.printf("%d\n",arr[n/2]);
		
	}

}
