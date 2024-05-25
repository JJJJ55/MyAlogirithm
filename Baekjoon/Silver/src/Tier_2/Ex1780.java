package Tier_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1780 {
	static int a,b,c;
	static int arr[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		func(0,0,n);
		System.out.println(c);
		System.out.println(a);
		System.out.println(b);
	}
	
	static void func(int i, int j, int n) {
		if(check(i,j,n)) {
			if(arr[i][j]==0) {
				a++;
			} else if(arr[i][j]==1) {
				b++;
			} else {
				c++;
			}
			return;
		}
		
		int tmp = n/3;
		func(i,j,tmp);
		func(i,j+tmp,tmp);
		func(i,j+tmp+tmp,tmp);
		
		func(i+tmp,j,tmp);
		func(i+tmp,j+tmp,tmp);
		func(i+tmp,j+tmp+tmp,tmp);
		
		func(i+tmp+tmp,j,tmp);
		func(i+tmp+tmp,j+tmp,tmp);
		func(i+tmp+tmp,j+tmp+tmp,tmp);
	}
	
	static boolean check(int i, int j, int n) {
		int num = arr[i][j];
		for(int ni=i;ni<i+n;ni++	) {
			for(int nj=j;nj<j+n;nj++) {
				if(arr[ni][nj]!=num) {
					return false;
				}
			}
		}
		return true;
	}
}
