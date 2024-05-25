package Tier_4;

import java.util.Scanner;

public class Ex1976 {
	static int n,m;
	static int parent[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		parent = new int[n+1];
		
		make();
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				int tmp = sc.nextInt();
				if(tmp==1) {
					union(i,j);
				}
			}
		}
		
		int start = find(sc.nextInt());
		for(int i=2;i<=m;i++) {
			int end = sc.nextInt();
			
			if(start!=find(end)) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
		
	}
	
	static void make() {
		for(int i=1;i<=n;i++) {
			parent[i] = i;
		}
	}
	
	static int find(int a) {
		if(parent[a]==a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}
	
	static void union(int a, int b) {
		int i = find(a);
		int j = find(b);
		
		if(i!=j) {
			if (i<j){
				parent[i] = j;
			} else {
				parent[j] = i;
			}
		}
	}
}