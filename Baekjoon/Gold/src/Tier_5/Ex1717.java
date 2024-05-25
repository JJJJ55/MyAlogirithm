package Tier_5;

import java.util.Scanner;

public class Ex1717 {
	static int arr[];
	static int n,m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n+1];
		
		make();
		
		for(int i=0;i<m;i++) {
			int command = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(command==0) {
				union(a,b);
			} else {
				if(check(a, b)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}
	
	static void make() {
		for(int i=1;i<=n;i++) {
			arr[i] = i;
		}
	}
	
	static int find(int a) {
		if (a == arr[a]) {
			return a;
		}
		
		return arr[a] = find(arr[a]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) {
			if(a<b) {
				arr[b] = a;
			} else {
				arr[a] = b;
			}
		}
	}
	
	static boolean check(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a==b) {
			return true;
		} else {
			return false;
		}
	}
}
