package D2;

import java.util.Scanner;

public class Ex1288 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=0;t<T;t++) {
			String n = sc.next();
			int arr[] = new int[10];
			int idx = 0;
			int j = 2;
			String tmp = n;
			while(true) {
				for(int i=0;i<tmp.length();i++) {
					arr[tmp.charAt(i)-'0']++;
				}
				
				for(int i=0;i<arr.length;i++) {
					if(arr[i]>0) {
						idx++;
					}
				}
				if(idx==10) {
					System.out.printf("#%d %s\n",t+1,tmp);
					break;
				} else {
					idx = 0;
					tmp= String.valueOf(j*Integer.parseInt(n));
					j++;
				}
			}
		}
	}
}
