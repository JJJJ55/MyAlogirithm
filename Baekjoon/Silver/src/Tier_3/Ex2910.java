package Tier_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Ex2910 {
	public static void main(String[] args) throws IOException {
		HashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(st.nextToken());
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>(map.keySet());
		
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return map.get(o2) -map.get(o1);
			}
		});
		
//		Iterator<Integer> it = list.iterator();
//		
//		while(it.hasNext()) {
//			Integer el = it.next();
//			for(int i=0;i<map.get(el);i++) {
//				System.out.print(el+" ");
//			}
//		}
		
		for(int i=0;i<list.size();i++) {
			int tmp = list.get(i);
			for(int j=0;j<map.get(tmp);j++) {
				System.out.print(tmp+" ");
			}
		}
		
	}
}
