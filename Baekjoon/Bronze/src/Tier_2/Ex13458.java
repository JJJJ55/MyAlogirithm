package Tier_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex13458 {
	static int arr[],n,b,c;
	static long cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++	) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<n;i++) {
			int num = arr[i]-b;
			int x = 0;
			if(num>0 && num<=c) {
				cnt+=2;
			} else if(num>0 && num>c){
				if(num%c==0) {
					cnt+=(num/c)+1;
				} else {
					cnt+=(num/c)+2;
				}
			} else if(num<=0) {
				cnt+=1;
			}
			
//			if(b>c) {
//				num=-b;
//				if(num%c==0) {
//					cnt += (num/c);
//				} else {
//					cnt += (num/c)+1;
//				}
//			} else if(b<=c) {
//				if(num<=b) {
//					cnt+=1;
//					continue;
//				}
//				int x = 0;
//				if((num-b)%c==0) {
//					x = (num-b)/c;
//					if(x==0) {
//						x = 1;
//					}
//				} else {
//					x = (num-b)/c+1;
//				}
//				int y = 0;
//				if(num%c==0) {
//					y = num/c;
//					if(y==0) {
//						y=1;
//					}
//				} else {
//					y = num/c+1;
//				}
//				cnt += Math.min(x+1,y);
//			}
		}
		System.out.println(cnt);
	}
}
