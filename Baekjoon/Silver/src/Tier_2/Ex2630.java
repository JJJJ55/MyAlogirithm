package Tier_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2630 {
	static int arr[][], n,w,b;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		func(0,0,n);
		System.out.println(w);
		System.out.println(b);
	}
	
	static void func(int r, int c, int n) {
		if(check(r, c, n)) {
			if(arr[r][c]==0) {
				w++;
			} else {
				b++;
			}
			return;
		}
		
		int size = n/2;
		
		func(r,c,size);
		func(r,c+size,size);
		func(r+size,c,size);
		func(r+size,c+size,size);
	}
	
	static boolean check(int r, int c, int size) {
		int color = arr[r][c];
		
		for(int i=r;i<r+size;i++) {
			for(int j=c;j<c+size;j++) {
				if(arr[i][j]!=color) {
					return false;
				}
			}
		}
		
		return true;
	}
}
