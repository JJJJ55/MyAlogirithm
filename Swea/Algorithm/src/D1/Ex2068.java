package D1;

import java.util.Arrays;
import java.util.Scanner;

public class Ex2068 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1;t<=T;t++) {
			int arr[] = new int[10];
			for(int i=0;i<arr.length;i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			
			System.out.printf("#%d %d\n",t,arr[9]);
		}
	}

}
