package Tier_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class BJ1406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Character> list = new LinkedList<Character>();
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i));
		}
		int n = Integer.parseInt(br.readLine());
		ListIterator<Character>iter = list.listIterator();
		while(iter.hasNext()) {
			iter.next();
		}
		
		for (int i = 0; i < n; i++) {
			String ss = br.readLine();
			char s = ss.charAt(0);
			switch (s) {
			case 'L': {
				if (iter.hasPrevious())
					iter.previous();
				break;
			}
			case 'D': {
				if (iter.hasNext())
					iter.next();
				break;
			}
			case 'B': {
				if (iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
				break;
			}
			case 'P': {
				char c = ss.charAt(2);
				iter.add(c);
				break;
			}

			}
		}
		for(char c : list) {
			sb.append(c);
		}
		System.out.println(sb);
	}
}
