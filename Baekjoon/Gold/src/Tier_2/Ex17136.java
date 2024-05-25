package Tier_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex17136 {
	static int paper[] = {0,5,5,5,5,5};
	static int arr[][],cnt;
	static int min = -1;
	static final int size = 10;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		arr = new int[size][size];
		for(int i=0;i<size;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<size;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0,0);
		
		System.out.println(min);
	}
	
	static void dfs(int si, int sj,int cnt) {
		if(sj>9) {
			dfs(si+1,0,cnt);
			return;
		}
		if(si>9) {
			if(min==-1) {
				min = cnt;
			} else if(min > cnt) {
				min = cnt;
			}
			return;
		}
		if(arr[si][sj]==0) {
			dfs(si, sj+1, cnt);
			return;
		}
		for(int n=5;n>=1;n--) {
			if(paper[n]!=0 && si+n<=10 && sj+n<=10) {
				if(check(si,sj,n)) {
					change(si,sj,n,0);
					dfs(si,sj+n,cnt+1);
					change(si,sj,n,1);
				}
			}
		}
	}
	
	static boolean check(int i,int j, int n) {
		for(int si=0;si<n;si++) {
			for(int sj=0;sj<n;sj++) {
				if(arr[si+i][sj+j]==0) {
					return false;
				}
			}
		}
		return true;
	}
	
	static void change(int i, int j,int n, int tmp) {
		if(tmp==1) {
			paper[n]++;
		} else {
			paper[n]--;
		}
		for(int si=0;si<n;si++) {
			for(int sj=0;sj<n;sj++) {
				arr[si+i][sj+j]=tmp;
			}
		}
	}
}
