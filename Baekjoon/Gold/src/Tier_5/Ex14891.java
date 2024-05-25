package Tier_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Ex14891 {
	static LinkedList<Integer> list[] = new LinkedList[4];
	static int arr[][],n,score;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=0;i<4;i++) {
			list[i] = new LinkedList<Integer>();
			char c[] = br.readLine().toCharArray();
			for(int j=0;j<c.length;j++) {
				list[i].add(c[j]-'0');
			}
		}
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][2];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<n;i++) { // 회전체크 시작 
			boolean flag;
			if(arr[i][1]==1) {
				flag = true;
			} else {
				flag = false;
			}
			int x = arr[i][0]-1;
			LinkedList<Integer> target = list[x];
			int r = target.get(2);
			int l = target.get(6);
			if(flag) {
				flag = !flag;
				target.addFirst(target.pollLast());
			} else {
				flag = !flag;
				target.addLast(target.pollFirst());
			}
			boolean check = flag;
			for(int j=x-1;j>=0;j--) { //기준점으로 부터 왼쪽
				target = list[j];
				if(target.get(2)!=l) {
					l = target.get(6);
					if(flag) {
						flag = !flag;
						target.addFirst(target.pollLast());
					} else {
						flag = !flag;
						target.addLast(target.pollFirst());
					}
				} else {
					break;
				}
			}
//			print();
			for(int j=x+1;j<4;j++) { //기준점으로부터 오른쪽
				target = list[j];
				if(target.get(6)!=r) {
					r = target.get(2);
					if(check) {
						check = !check;
						target.addFirst(target.pollLast());
					} else {
						check = !check;
						target.addLast(target.pollFirst());
					}
				} else {
					break;
				}
			}
//			print();
		}
		
//		print();
		
		int s = 1;
		for(int i=0;i<4;i++) {
			score+=list[i].get(0)*s;
			s*=2;
		}
		System.out.println(score);
	}
	
//	static void print() {
//		for(int i=0;i<4;i++) {
//			for(int j :list[i]) {
//				System.out.print(j);
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
}
