package Tier_2;

import java.util.Scanner;

public class Ex17103 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		boolean[] num = new boolean[1000001];
		num[0]=num[1]=true;
		for(int i=2;i<=1000000;i++) {
			if(num[i]) continue;
			for(int j=i*2;j<=1000000;j+=i) {
				num[j] = true;
			}
		}
		
		for(int i=0;i<T;i++) {
			int n = sc.nextInt();
			int count = 0;
			for(int j=2;j<=n/2;j++) {
				if(!num[j] && !num[n-j]) {
					count++;
				}
			}
			System.out.println(count);
		}
	}

}
