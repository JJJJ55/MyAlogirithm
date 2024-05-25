package Tier_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex24511 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer>dq = new ArrayDeque<Integer>();
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[t];
		for(int i=0;i<t;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<t;i++) {
			int num = Integer.parseInt(st.nextToken());
			if(arr[i]==0) {
				dq.add(num);
			}
		}
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			dq.addFirst(Integer.parseInt(st.nextToken()));
			sb.append(dq.pollLast()).append(" ");
		}
		System.out.println(sb);
	}
}
