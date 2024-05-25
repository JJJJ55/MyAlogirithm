package Tier_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Ex14499 {
	static int arr[][],n,m,si,sj,k;
	static int di[] = {0,0,0,-1,1};
	static int dj[] = {0,1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		si = Integer.parseInt(st.nextToken());
		sj = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		int result[] = new int[6];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		list1.add(1);
		list1.add(0);
		list1.add(4);
		list1.add(5);
		
		list2.add(2);
		list2.add(list1.get(1));
		list2.add(3);
		list2.add(list1.get(3));
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<k;i++	) {
			int num = Integer.parseInt(st.nextToken());
			
			si+=di[num];
			sj+=dj[num];
			
			if(si>=0 && si<n && sj>=0 && sj<m) {
				switch (num) {
				case 1: // 동
					list2.addFirst(list2.pollLast());
					list1.remove(1);
					list1.add(1, list2.get(1));
					list1.remove(3);
					list1.add(3, list2.get(3));
					break;
				case 2: // 서
					list2.addLast(list2.pollFirst());
					list1.remove(1);
					list1.add(1, list2.get(1));
					list1.remove(3);
					list1.add(3, list2.get(3));
					break;
				case 3: // 북
					list1.addFirst(list1.pollLast());
					list2.remove(1);
					list2.add(1, list1.get(1));
					list2.remove(3);
					list2.add(3, list1.get(3));
					break;
				case 4: // 남
					list1.addLast(list1.pollFirst());
					list2.remove(1);
					list2.add(1, list1.get(1));
					list2.remove(3);
					list2.add(3, list1.get(3));
					break;
				}
				if(arr[si][sj]==0) {
					System.out.println(result[list1.get(3)]);
					arr[si][sj] = result[list1.get(1)];
				} else {
					System.out.println(result[list1.get(3)]);
					result[list1.get(1)] = arr[si][sj];
					arr[si][sj] = 0;
				}
			} else {
				si-=di[num];
				sj-=dj[num];
			}
		}
	}
}
