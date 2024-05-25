package Tier_4;

import java.util.Scanner;

public class Ex1062 {
	static int n,k;
	static int max;
	static String arr[];
	static boolean visit[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		arr = new String[n];
		for(int i=0;i<n;i++) {
			String str = sc.next();
			str = str.replace("anta", "");
			str = str.replace("tica", "");
			arr[i] = str;
		}
		
		if(k<5) {
			System.out.println(0);
			return;
		} else if(k==26) {
			System.out.println(n);
			return;
		}
		
		visit = new boolean[26];
		visit['a'-'a'] = true;
		visit['c'-'a'] = true;
		visit['i'-'a'] = true;
		visit['n'-'a'] = true;
		visit['t'-'a'] = true;
		
		dfs(0,0);
		System.out.println(max);
	}
	
	static void dfs(int idx, int cnt) {
		if(idx==k-5) {
			int count = 0;
			for(int i=0;i<n;i++) {
				boolean flag = true;
				for(int j=0;j<arr[i].length();j++) {
					if (!visit[arr[i].charAt(j)-'a']){
						flag = false;
						break;
					}
				}
				if(flag) {
					count++;
				}
			}
			max = Math.max(max, count);
			return;
		}
		for(int i=cnt;i<26;i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(idx+1,i);
				visit[i] = false;
			}
		}
	}
}
