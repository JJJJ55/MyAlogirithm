package Tier_4;

import java.util.Scanner;

public class Ex2448 {
	static int n;
	static char arr[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		n = sc.nextInt();
		arr = new char[n][2*n-1];
		for(int i=0;i<n;i++) {
			for(int j=0;j<2*n-1;j++) {
				arr[i][j]=' ';
			}
		}
		func(0,n-1,n);
		
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n*2-1;j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void func(int x, int y, int idx) {
		if(idx==3) {
			arr[x][y] = '*';
			arr[x+1][y-1] = arr[x+1][y+1] = '*';
			arr[x+2][y-2] = arr[x+2][y-1] = arr[x+2][y] = arr[x+2][y+1] = arr[x+2][y+2] = '*';
			return;
		}
		func(x,y,idx/2);
		func(x+idx/2,y-idx/2,idx/2);
		func(x+idx/2,y+idx/2,idx/2);
		
	}
}
