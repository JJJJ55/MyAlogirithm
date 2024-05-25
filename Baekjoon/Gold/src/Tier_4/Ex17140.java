package Tier_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex17140 {
	static int arr[][], r,c,k, cnt;
	static int now_r = 3, now_c = 3;
	static ArrayList<Integer> list;
	static class num implements Comparable<num>{
		int n;
		int count;
		public num(int n, int count) {
			this.n = n;
			this.count = count;
		}
		
		@Override
		public int compareTo(num o) {
			if(this.count == o.count) {
				return this.n - o.n;
			}
			return this.count - o.count;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken())-1;
		c = Integer.parseInt(st.nextToken())-1;
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[now_r][now_c];
		
		for(int i=0;i<3;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			if(cnt==101) {
				System.out.println(-1);
				break;
			}
			if(now_r>r && now_c>c) {
				if(arr[r][c]==k) {
					System.out.println(cnt);
					break;
				}
			}

			if(now_r<now_c) { //c연산
				int max = 0;
				ArrayList<ArrayList<Integer>> sort = new ArrayList<ArrayList<Integer>>();
				for(int i=0;i<now_c;i++) {
					PriorityQueue<num> q = new PriorityQueue<num>();
					list = new ArrayList<Integer>();
					for(int j=0;j<now_r;j++) {
						if(arr[j][i]!=0 && !list.contains(arr[j][i])) {
							list.add(arr[j][i]);
							num tmp = new num(arr[j][i], 1); 
							for(int z=j+1;z<now_r;z++) {
								if(arr[z][i]==arr[j][i]) {
									tmp.count++;
								}
							}
							q.offer(tmp);
						}
					}
					ArrayList<Integer> result = new ArrayList<Integer>();
					int size = q.size();
					for(int a=0;a<size;a++) {
						num tmp = q.poll();
						result.add(tmp.n);
						result.add(tmp.count);
					}
					max = Math.max(max, result.size());
					sort.add(result);
				}
				if(max>100) {
					max = 100;
				}
				now_r = max;
				arr = new int[now_r][now_c];
				for(int j=0;j<now_c;j++) {
					ArrayList<Integer> ar = sort.get(j);
					for(int i=0;i<ar.size();i++) {
						if(i==100) break;
						arr[i][j] = ar.get(i);
					}
				}
			} else { //r연산
				int max = 0;
				ArrayList<ArrayList<Integer>> sort = new ArrayList<ArrayList<Integer>>();
				for(int i=0;i<now_r;i++) {
					PriorityQueue<num> q = new PriorityQueue<num>();
					list = new ArrayList<Integer>();
					for(int j=0;j<now_c;j++) {
						if(arr[i][j]!=0 && !list.contains(arr[i][j])) {
							list.add(arr[i][j]);
							num tmp = new num(arr[i][j], 1); 
							for(int z=j+1;z<now_c;z++) {
								if(arr[i][z]==arr[i][j]) {
									tmp.count++;
								}
							}
							q.offer(tmp);
						}
					}
					ArrayList<Integer> result = new ArrayList<Integer>();
					int size = q.size();
					for(int a=0;a<size;a++) {
						num tmp = q.poll();
						result.add(tmp.n);
						result.add(tmp.count);
					}
					max = Math.max(max, result.size());
					sort.add(result);
				}
				if(max>100) {
					max = 100;
				}
				now_c = max;
				arr = new int[now_r][now_c];
				for(int i=0;i<now_r;i++) {
					ArrayList<Integer> ar = sort.get(i);
					for(int j=0;j<ar.size();j++) {
						if(j==100) break;
						arr[i][j] = ar.get(j);
					}
				}
			}
//			print();
			cnt++;
		}
	}
	
	static void print() {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("=========");
	}
}
