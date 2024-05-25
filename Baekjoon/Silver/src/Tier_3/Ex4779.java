package Tier_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex4779 {
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = "";
		while((str = br.readLine())!=null) {
			sb = new StringBuilder();
			int n = Integer.parseInt(str);
			for(int i=0;i<Math.pow(3, n);i++) {
				sb.append("-");
			}
			func(0,(int)Math.pow(3, n));
			System.out.println(sb);
		}
	}
	
	static void func(int start, int n) {
		if(n==1) {
			return;
		}
		int tmp = n/3;
		for(int i=start+tmp;i<start+2*tmp;i++) {
			sb.setCharAt(i, ' ');
		}
		func(start, tmp);
		func(start+2*tmp,tmp);
	}
}
