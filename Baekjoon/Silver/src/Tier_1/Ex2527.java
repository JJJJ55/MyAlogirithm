package Tier_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2527 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t=0;t<4;t++) {
			int arr[] = new int[8];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<arr.length;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			if(arr[0]>arr[6] || arr[2]<arr[4] || arr[1]>arr[7] || arr[3]<arr[5]) {
				sb.append("d").append("\n");
			} else if((arr[0]==arr[6]&&arr[1]==arr[7])||(arr[2]==arr[4]&&arr[1]==arr[7])||(arr[2]==arr[4]&&arr[3]==arr[5])||(arr[0]==arr[6]&&arr[3]==arr[5])) {
				sb.append("c").append("\n");
			} else if(arr[1]==arr[7] || arr[2]==arr[4] || arr[0] == arr[6] || arr[3]==arr[5]) {
				sb.append("b").append("\n");
			} else {
				sb.append("a").append("\n");
			}
		}
		System.out.println(sb);
	}
}
