package Tier_5;

import java.util.Scanner;

public class Ex2447 {
	static int n;
	static char arr[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		arr = new char[n][n];
		
		func(0,0,n,false);
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void func(int x, int y, int idx, boolean flag) {
		if(flag) {
			for(int i=x;i<x+idx;i++) {
				for(int j=y;j<y+idx;j++) {
					arr[i][j]=' ';
				}
			}
			return;
		}
		if(idx==1) {
			arr[x][y]='*';
			return;
		}
		
		int size = idx/3;
		int count = 0;
		for(int i=x;i<x+idx;i+=size) {
			for(int j=y;j<y+idx;j+=size) {
				count++;
				if(count == 5) {
					func(i,j,size,true);
				} else {
					func(i,j,size,false);
				}
			}
		}
	}
}
