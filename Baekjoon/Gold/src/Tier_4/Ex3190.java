package Tier_4;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Ex3190 {
	static int n,k,l;
	static int arr[][];
	static Map<Integer, String> dir = new HashMap<Integer, String>();
	static Queue<int[]> q = new ArrayDeque<int[]>();
	static int di[] = {0,-1,0,1};
	static int dj[] = {1,0,-1,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		arr = new int[n][n];
		
		k = sc.nextInt();
		for(int i=0;i<k;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a-1][b-1] = 9;
		}
		
		l = sc.nextInt();
		for(int i=0;i<l;i++) {
			int time = sc.nextInt();
			String ang = sc.next();
			dir.put(time, ang);
		}
		
		int play = 0;
		int si = 0;
		int sj = 0;
		int d = 0;
		q.offer(new int[] {0,0});
		while(true) {
			int ni = si+di[d];
			int nj = sj+dj[d];
			play++;
			if(ni<0 || ni>n-1 || nj<0 || nj>n-1) {
				break;
			}
			boolean flag = false;
			for(int []info : q) {
				if(Arrays.equals(info, new int[] {ni,nj})) {
					flag = true;
					break;
				}
			}
			if(flag) {
				break;
			}
			if(arr[ni][nj]==9) {
				arr[ni][nj] = 0;
				q.offer(new int[] {ni,nj});
			} else {
				q.offer(new int[] {ni,nj});
				q.poll();
			}
			
			if(dir.containsKey(play)) {
				String dd = dir.get(play);
				if(dd.equals("D")) {
					d -=1;
					d = d<0 ? 3 : d;
				} else {
					d +=1;
					d = d>3 ? 0 : d;
				}
			}
			si = ni;
			sj = nj;
		}
		System.out.println(play);
	}
}
