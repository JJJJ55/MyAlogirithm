package D2;

import java.util.Base64;
import java.util.Scanner;

public class Ex1928 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int t=0;t<T;t++) {
			String str = sc.next();
			String ans = new String(Base64.getDecoder().decode(str));
			System.out.printf("#%d %s\n",t+1,ans);
		}
	}
}