package Tier_3;

import java.util.Scanner;

public class Ex24060_미제출 {
	
	static int tmp[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int arr[] = new int[n];
		tmp = new int [n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
	}
	
	static void merge_sort(int arr[], int p, int r) {
		if(p<r) {
			int q = (p+r)/2;
			
			merge_sort(arr, p, q);
			merge_sort(arr, q+1, r);
			merge(arr,p,q,r);
		}
	}
	
	static void merge(int arr[], int p,int q,int r) {
		int i = p;
		int j = q+1;
		int t = r;
		
		while(i<=q && j<=r) {
			if(arr[i]<=arr[j]) {
				tmp[t++] = arr[i++];
			} else {
				tmp[t++] = arr[j++];
			}
		}
		
		while(i<=q) {
			tmp[t++] = arr[i++];
		}
		while(j<=r) {
			tmp[t++] = arr[j++];
		}
		i = p;
		t = 1;
		while(i<=r) {
			arr[i++] = tmp[t++];
		}
	}
}
