package test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int arr[][],test[][],n,sum,result = Integer.MAX_VALUE;
	static int di[] = {1,1,1,1};
	static int dj[] = {-1,1,1,-1};
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				sum+=arr[i][j];
			}
		}

		for(int i=1;i<=n;i++) {
			for(int j=2;j<=n;j++) {
				for(int d1=1;d1<=n;d1++) {
					for(int d2=1;d2<=n;d2++) {
						test = new int[n+1][n+1];
						if(i+d1+d2>n) continue;
						if((j-d1<1) || (j+d2>n)) continue;
						play(i,j,d1,d2);
					}
				}
			}
		}
//		test = new int[n+1][n+1];
//		play(3,3,1,1);
		System.out.println(result);
	}
	
	static void play(int i, int j, int d1, int d2) {
		int cnt[] = new int[5];
		int nj = 0;
		//1
		for(int x=1;x<i;x++) {
			for(int y=1;y<=j;y++) {
				test[x][y] = 1;
				cnt[1]+=arr[x][y];
			}
		}

		nj = j;
		for(int x=i;x<i+d1;x++) {
			for(int y=1;y<nj;y++) {
				test[x][y] = 1;
				cnt[1]+=arr[x][y];
			}
			nj-=1;
		}
//		print();
		//2
		for(int x=1;x<i;x++) {
			for(int y=j+1;y<=n;y++) {
				test[x][y] = 2;
				cnt[2]+=arr[x][y];
			}
		}
		nj = j;
		for(int x=i;x<=i+d1;x++) {
			for(int y=nj+1;y<=n;y++) {
				test[x][y]=2;
				cnt[2]+=arr[x][y];
			}
			nj+=1;
		}
//		print();
		//3
		nj = j;
		for(int x=i+d1;x<=i+d1+d2;x++) {
			for(int y=1;y<nj-d1;y++) {
				test[x][y] = 3;
				cnt[3]+=arr[x][y];
//				System.out.println(x+" "+y);
			}
			nj+=1;
		}
		for(int x=i+d1+d2+1;x<=n;x++) {
			for(int y=1;y<j-d1+d2;y++) {
				test[x][y] = 3;
				cnt[3]+=arr[x][y];
//				System.out.println(x+" "+y);
			}
		}
//		print();
		//4
		nj = j;
		for(int x = i+d2+1;x<=i+d1+d2;x++) {
			for(int y = nj+d2;y<=n;y++) {
				test[x][y] = 4;
				cnt[4]+=arr[x][y];
			}
			nj-=1;
		}
		for(int x=i+d1+d2+1;x<=n;x++) {
			for(int y=j+d2-d1;y<=n;y++) {
				test[x][y] = 4;
				cnt[4]+=arr[x][y];
			}
		}
//		print();
		cnt[0] = sum-cnt[1]-cnt[2]-cnt[3]-cnt[4];
//		System.out.println(Arrays.toString(cnt));
		Arrays.sort(cnt);
		result = Math.min(result, cnt[4]-cnt[0]);
		if(result==137) {
			print();
		}
	}
	
	
	static void print() {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				System.out.print(test[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	// 3이 왜 이상하게 나와
}