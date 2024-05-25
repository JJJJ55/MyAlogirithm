package test;

import java.util.Arrays;

public class BruteForceBasic {
    static String[] cards = {"A","B","C", "D","E"};
    static String[] result;
    static boolean flag[];
    static int N=5, R=3;
    
    public static void main(String[] args) {
        // 여기서 아래 4개의 실행을 모두 테스트 하시오!!!
    	result = new String[R];
    	
    	flag = new boolean[N];
//    	perm(0);
    	subset(0);
//    	comb1(0,0);
//    	comb2(0,0);
//    	comb3(0,0);
    }
    
    // 5개중에 3개 뽑아 순서 나열하는 순열 구현
    static void perm(int idx) {
    	if(idx==R) {
    		System.out.println(Arrays.toString(result));
    		return;
    	}
    	for(int i=0;i<N;i++) {
    		if(!flag[i]) {
    			flag[i] = true;
        		result[idx] = cards[i];
        		perm(idx+1);
        		flag[i] = false;
    		}
    	}
    }
    
    // 5개의 재료중 그 무엇이든 상관없이 부분 원소로 구현된 모든 부분집합 구현
    static void subset(int cnt) {
    	if(cnt==N) {
    		for(int i=0;i<N;i++) {
    			System.out.print(flag[i] ? cards[i]+" " : "");
    		}
    		System.out.println();
    		return;
    	}
    	flag[cnt]=true;
    	subset(cnt+1);
    	flag[cnt] = false;
    	subset(cnt+1);
    	
    }
    
    // 5개중에 3개 뽑은 순서 상관없는 조합 구현 : 태희쌤 버전 반복문 사용 
    static void comb1(int idx, int start) {
    	if(idx==R) {
    		System.out.println(Arrays.toString(result));
    		return;
    	}
    	for(int i=start;i<N;i++) {
    		result[idx] = cards[i];
    		comb1(idx+1,i+1);
    	}
    }
    
    // 5개중에 3개 뽑은 순서 상관없는 조합 구현 : 양유 버전 반복문 사용금지!!(부분집합 버전) 
    static void comb2(int idx, int cnt) {
    	if (cnt == R) {
            for (int i = 0; i < N; i++) {
                System.out.print(flag[i]?cards[i]+" ":"");
            }
            System.out.println();
            return;
        }
    	if(idx==cards.length) return;
    	flag[idx] = true;
        comb2(idx + 1, cnt+1);
        flag[idx] = false;
        comb2(idx + 1, cnt);
    }
    
    static void comb3(int target, int cnt) { //?
    	if(cnt==R) {
    		System.out.println(Arrays.toString(result));
    		return;
    	}
    	if(target==N) return;
    	
    	result[cnt] = cards[target];
    	comb2(target + 1, cnt+1);
    	comb2(target, cnt);
    }
}