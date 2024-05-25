package D3;

import java.util.Scanner;

public class Ex8104 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
 
        for(int t=0;t<T;t++) {
            int sum = 0;
            int grade = 0;
            int n = sc.nextInt();
            int k = sc.nextInt();
             
            int num = n*k;
            for(int i=0;i<num/k;i++) {
                if(i%2==0) {
                    grade++;
                    sum+=grade;
                } else {
                    grade = k*(i+1);
                    sum+=grade;
                }
            }
            System.out.printf("#%d ",t+1);
             
            if((num/k)%2==0) {
                for(int i=0;i<k;i++) {
                    System.out.printf("%d ",sum);
                }
                System.out.println();
            } else {
                for(int i=0;i<k;i++) {
                    System.out.printf("%d ",sum+i);
                }
                System.out.println();
            }
 
        }   
    }
}
