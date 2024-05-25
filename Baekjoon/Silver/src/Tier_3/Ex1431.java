package Tier_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Ex1431 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String arr[] = new String[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					int sum1 = 0;
					int sum2 = 0;
					for(int i=0;i<o1.length();i++) {
						int num1 = o1.charAt(i)-'0';
						int num2 = o2.charAt(i)-'0';
						if(num1>=0 && num1<=9) {
							sum1+=num1;
						}
						if(num2>=0 && num2<=9) {
							sum2+=num2;
						}
					}
					if(sum1 == sum2) {
						return o1.compareTo(o2);
					} else {
						return sum1 - sum2;
					}
				} else {
					return o1.length() - o2.length();
				}
			}

		});
		
		for(int i=0;i<n;i++) {
			System.out.println(arr[i]);
		}
	}
}
