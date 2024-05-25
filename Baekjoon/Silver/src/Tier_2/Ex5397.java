package Tier_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Ex5397 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			LinkedList<Character> list = new LinkedList<Character>();
			String str = br.readLine();
			ListIterator<Character> iter = list.listIterator();
			for(int j=0;j<str.length();j++) {
				switch (str.charAt(j)) {
				case '<':
					if(iter.hasPrevious()) {
						iter.previous();
					}
					break;
				case '>':
					if(iter.hasNext()) {
						iter.next();
					}
					break;
				case '-':
					if(iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
					break;
				default:
					iter.add(str.charAt(j));
					break;
				}
			}
			for(char c : list) {
				sb.append(c);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
