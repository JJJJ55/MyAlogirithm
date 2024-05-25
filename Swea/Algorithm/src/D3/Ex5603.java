package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex5603 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		int T = sc.nextInt();
//		for(int t=0;t<T;t++) {
//			int n = sc.nextInt();
//			int arr[] = new int[n];
//			int sum = 0;
//			for(int i=0;i<n;i++) {
//				arr[i] = sc.nextInt();
//				sum +=arr[i];
//			}
//			sum/=n;
//			
//			int count = 0;
//			for(int i=0;i<n;i++) {
//				if(arr[i]<sum) {
//					count += sum-arr[i];
//				}
//			}
//			System.out.printf("#%d %d\n",t+1,count);
//		}
//	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int n = Integer.parseInt(br.readLine());
			int arr[] = new int[n];
			int sum = 0;
			for(int i=0;i<n;i++) {
				String str = br.readLine();
				st = new StringTokenizer(str);
				arr[i] = Integer.parseInt(st.nextToken());
				sum +=arr[i];
			}
			sum/=n;
			
			int count = 0;
			for(int i=0;i<n;i++) {
				if(arr[i]<sum) {
					count += sum-arr[i];
				}
			}
			System.out.printf("#%d %d\n",t+1,count);
		}
	}
}
