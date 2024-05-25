package Tier_4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ex25192 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Set<String> set = new HashSet<String>();
		int n = sc.nextInt();
		int cnt = 0;
		
		sc.next();
		for(int i=1;i<n;i++) {
			String str= sc.next();
			if(str.equals("ENTER")) {
				cnt+=set.size();
				set.clear();
				continue;
			}
			set.add(str);
		}
		System.out.println(cnt+set.size());
		
	}
}
