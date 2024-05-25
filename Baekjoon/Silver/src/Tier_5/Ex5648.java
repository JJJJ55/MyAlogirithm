package Tier_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Ex5648 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		long arr[] = new long[n];
		int idx = 0;
		
		while(true) {
			while(st.hasMoreTokens()) {
				String str = st.nextToken();
				String tmp = "";
				for(int i=str.length()-1;i>=0;i--) {
					tmp+=str.charAt(i);
				}
				arr[idx] = Long.parseLong(tmp);
				idx++;
			}
			if(idx==n) break;
			st = new StringTokenizer(br.readLine());
		}
		
		Arrays.sort(arr);
		
		for(long i : arr) {
			System.out.println(i);
		}
	}
}
