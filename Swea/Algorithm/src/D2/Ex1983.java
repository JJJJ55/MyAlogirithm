package D2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ex1983 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s[] = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
		
		int t = sc.nextInt();
		for(int i=0;i<t;i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			Double arr[] = new Double[n];
			
			for(int j=0;j<n;j++) {
				arr[j] = (sc.nextInt()*0.35)+(sc.nextInt()*0.45)+(sc.nextInt()*0.2);
			}
			double num = arr[k-1];
			Arrays.sort(arr, Collections.reverseOrder());
			
			for(int j=0;j<n;j++) {
				if(arr[j]==num) {
					System.out.printf("#%d %s\n",i+1,s[j/(n/10)]);
					break;
				}
			}
		}
	}
}
