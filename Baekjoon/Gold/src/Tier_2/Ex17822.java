package Tier_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex17822 {
	static int n,m,t,arr[][];
	static int sum, cnt;
	static LinkedList<Integer> list[];
	static int di[] = {-1,1,0,0};
	static int dj[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		list = new LinkedList[n+1];
		cnt = n*m;
		for(int i=1;i<=n;i++) {
			list[i] = new LinkedList<Integer>();
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				int num = Integer.parseInt(st.nextToken());
				sum+=num;
				list[i].add(num);
			}
		}
		arr = new int[n][m];
		
		for(int a=0;a<t;a++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			for(int i=1;i<=n;i++) {
				if(i%x==0) {
					if(d==0) { // 시계방향
						for(int j=0;j<k;j++) {
							list[i].addFirst(list[i].pollLast());
						}
					} else { // 반시계방향
						for(int j=0;j<k;j++) {
							list[i].addLast(list[i].pollFirst());
						}
					}
				}
			}
			
			for(int i=1;i<=n;i++) { //bfs 세팅
				for(int j=0;j<m;j++) {
					arr[i-1][j] = list[i].get(j);
				}
			}
//			print();
//			System.out.println("bfs전");
			boolean change = false;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(arr[i][j]!=0) {
						int tmp = arr[i][j];
						if(!bfs(i,j, tmp)) {
							arr[i][j] = tmp;
							cnt++;
							sum+=tmp;
						} else {
							change = true;
						}
					}
				}
			}
			if(!change) { //인접한 것들 중 같은 수가 없는 경우
				double avg = (double)sum/cnt;
//				System.out.println("ww");
//				System.out.println(sum+" "+cnt+" "+avg);
				for(int i=0;i<n;i++) {
					for(int j=0;j<m;j++) {
						if(arr[i][j]!=0 && arr[i][j]<avg) {
							arr[i][j]++;
						} else if(arr[i][j]!=0 && arr[i][j]>avg) {
							arr[i][j]--;
						}
					}
				}
			}
//			System.out.println(sum+" "+cnt+" "+sum/cnt);
			sum = 0;
			cnt = 0;
			for(int i=0;i<n;i++) {
				list[i+1].clear();
				for(int j=0;j<m;j++) {
					list[i+1].add(arr[i][j]);
					if(arr[i][j]!=0) {
						sum+=arr[i][j];
						cnt++;
					}
				}
			}
//			print();
		}
		int ans = 0;
		for(int i=1;i<=n;i++) {
			for(int j=0;j<m;j++) {
				ans +=list[i].get(j);
			}
		}
		
		System.out.println(ans);
	}
	
	static boolean bfs(int x,int y, int tmp) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		boolean flag = false;
		q.offer(new int[] {x,y});
		arr[x][y] = 0;
		cnt--;
		sum-=tmp;
		while(!q.isEmpty()) {
			int info[] = q.poll();
			for(int d=0;d<4;d++) {
				int ni = info[0]+di[d];
				int nj = info[1]+dj[d];
				if(nj==-1) nj=m-1;
				else if(nj==m) nj=0;
				if(ni>=0 && ni<n && nj>=0 &&nj<m && arr[ni][nj]==tmp) {
					sum-=tmp;
					flag = true;
//					bfs(ni,nj,tmp);
					q.offer(new int[] {ni,nj});
					arr[ni][nj] = 0;
					cnt--;
				}
			}
		}
		return flag;
	}
	
	static void print() { //다른건 다 맞는데 sum이랑 cnt만 틀림
		for(int i=1;i<=n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(list[i].get(j)+" ");
			}
			System.out.println();
		}
		System.out.println("=====");
	}
}
