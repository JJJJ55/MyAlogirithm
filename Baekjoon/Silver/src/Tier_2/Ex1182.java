package Tier_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex1182 {
	static int arr[],n,s,cnt,check,num;
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		visit = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		pick(0);
		System.out.println(cnt);
	}
	
	static void pick(int idx) {
		if(idx==n) {
			num++;
			if(num==Math.pow(2, n)) {
				return;
			}
			int sum = 0;
			for(int i=0;i<n;i++) {
				if(visit[i]) {
					sum+= arr[i];
//					if(sum>s) {
//						return;
//					}
				}
			}
			if(sum==s) {
//				System.out.println(Arrays.toString(visit));
				cnt++;
			}
			return;
		}
		visit[idx] = true;
		pick(idx+1);
		visit[idx] = false;
		pick(idx+1);
	}
}
