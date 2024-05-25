package Tier_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Ex2751 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i<n;i++) {
			list.add(Integer.parseInt(br.readLine())); 
		}
		Collections.sort(list);
		
		for(int i=0;i<n;i++) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.println(sb);
	}
}
