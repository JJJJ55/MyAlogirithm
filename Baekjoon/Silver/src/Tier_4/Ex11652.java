package Tier_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Ex11652 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		
		int n = Integer.parseInt(br.readLine());
		int max = 0;
		long x = 0;
		for(int i=0;i<n;i++) {
			long num = Long.parseLong(br.readLine());
			map.put(num, map.getOrDefault(num, 0)+1);
			
			if(map.get(num)>max) {
				max = map.get(num);
				x = num;
			} else if(map.get(num) == max) {
				x = num>x ? x : num;
			}
		}
		System.out.println(x);
	}
}
