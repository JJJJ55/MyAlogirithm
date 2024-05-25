package Tier_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex20920 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Map<String, Integer> map = new HashMap<String, Integer>();
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			if(str.length()<m) continue;
			map.put(str, map.getOrDefault(str, 0)+1);
		}
		
		List<String>list = new ArrayList<String>(map.keySet());
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if(Integer.compare(map.get(o1), map.get(o2))!=0) {
					return Integer.compare(map.get(o2), map.get(o1));
				}
				if(o1.length() != o2.length()) {
					return o2.length()-o1.length();
				}
				return o1.compareTo(o2);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(String s : list) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
		
		
	}
}
