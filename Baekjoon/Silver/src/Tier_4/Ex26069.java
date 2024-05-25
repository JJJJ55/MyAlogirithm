package Tier_4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ex26069 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Set<String> set = new HashSet<String>();	
		set.add("ChongChong");
		
		int n =sc.nextInt();
		
		for(int i=0;i<n;i++) {
			String a = sc.next();
			String b = sc.next();
			
			if(set.contains(a)||set.contains(b)) {
				set.add(a);
				set.add(b);
			}
		}
		System.out.println(set.size());
	}
}
