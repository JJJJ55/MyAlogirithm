package D2;

import java.util.Scanner;

public class Ex1859 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=0;t<T;t++) {
			int n = sc.nextInt();
			int[]arr = new int[n];
			long sum = 0;
			
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			int max = arr[arr.length-1];
			
			for(int i=arr.length-2;i>=0;i--) {
				if(arr[i]>=max) {
					max = arr[i];
				} else {
					sum+=(max-arr[i]);
				}
			}
			System.out.printf("#%d %d\n",t+1,sum);
		}
	}

}
