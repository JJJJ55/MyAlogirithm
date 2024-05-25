package Tier_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Ex15686 {
	static int arr[][],n,m;
	static int num[];
	static int min = Integer.MAX_VALUE;
	static List<int[]> home = new ArrayList<int[]>();
	static List<int[]> chi = new ArrayList<int[]>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][n+1];
		num = new int[m];
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) {
					home.add(new int[] {i,j});
				} else if(arr[i][j]==2) {
					chi.add(new int[] {i,j});
				}
			}
		}
		
		func(0,0);
		
		System.out.println(min);
		
	}
	
	static void func(int idx,int cnt) {
		if(idx==m) {
			int pick[][] = new int[m][2];
			
			for(int i=0;i<m;i++) {
				int a[] = chi.get(num[i]);
				for(int j=0;j<2;j++) {
					pick[i][j]=a[j];
				}
			}
			
			int d = 0;
			for(int i=0;i<home.size();i++) {
				int h[] = home.get(i);
				int dis = Integer.MAX_VALUE;
				for(int j=0;j<pick.length;j++) {
					dis = Math.min(dis, Math.abs(h[0]-pick[j][0])+Math.abs(h[1]-pick[j][1]));
				}
				d+=dis;
			}
			min = Math.min(min, d);
			return;
		}
		
		for(int i=cnt;i<chi.size();i++) {
			num[idx] =i;
			func(idx+1,i+1);
		}
	}
}
