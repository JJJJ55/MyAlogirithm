package Tier_2;

import java.util.Arrays;
import java.util.Scanner;

public class Ex17825 {
	static int arr[] = new int[10];
	static int num[] = new int[10];
	static int max = Integer.MIN_VALUE;
	static int map[] = {0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,0
						,10,13,16,19,25,30,35,40,0 //22 ~ 30
						,20,22,24,25,30,35,40,0 //31 ~ 38
						,30,28,27,26,25,30,35,40,0}; //39 ~ 47

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<10;i++) {
			arr[i] = sc.nextInt();
		}
		
		back(0);
		
		System.out.println(max);
	}
	
	static void back(int idx) {
		if(idx==10) {
			game();
			return;
		}
		
		for(int i=0;i<4;i++) {
			num[idx] = i;
			back(idx+1);
		}
	}
	
	static void game() {
		boolean visit[] = new boolean[map.length]; // 다른말이 있나 점검
		int score = 0;
		int p[] = new int[4]; //말이 있는 위치
		for(int i=0;i<10;i++) {
			int t = num[i]; // 말 뽑기
			if(finish(p[t])) return; // 말이 들어왔으면 그 즉시 종료
			
			int m = move(p[t],arr[i]); //말 이동
			
			if(finish(m)) {
				setvisit(visit,p[t],false); // 이전 위치 fasle
				p[t] = m;
				continue;
			}
			
			if(!visit[m]) {
				setvisit(visit,p[t],false);
				setvisit(visit,m,true);
				score+=map[m];
				p[t] = m;
			} else { //현재 위치에 말이 있다면 끝
				return;
			}
		}
		max = Math.max(max, score);
	}
	
	static void setvisit(boolean[] visit, int idx, boolean flag) {
		if(idx==20 || idx==29 || idx==37 || idx==46) {
			visit[20] = flag;
			visit[29] = flag;
			visit[37] = flag;
			visit[46] = flag;
		} else if(idx==26 || idx==34 || idx==43) {
			visit[26] = flag;
			visit[34] = flag;
			visit[43] = flag;
		} else if(idx == 27 || idx == 35 || idx == 44) {
			visit[27] = flag;
			visit[35] = flag;
			visit[44] = flag;
        }else if(idx == 28 || idx == 36 || idx == 45) {
        	visit[28] = flag;
        	visit[36] = flag;
        	visit[45] = flag;
        }else {
        	visit[idx] = flag;
        }
	}
	
	static int move(int idx, int dist) {
		int next = idx+dist;
		if(idx<21) {
			if(next>=21) return 21;
		} else if(idx<30) {
			if(next>=30) return 30;
		} else if(idx<38) {
			if(next>=38) return 38;
		} else if(idx<47) {
			if(next>=47) return 47;
		}
		
		if(next==5) return 22;
		if(next==10) return 31;
		if(next==15) return 39;
		return next;
	}
	
	static boolean finish(int idx) {
		return idx==21 || idx==30 || idx==38 || idx==47;
	}
}
