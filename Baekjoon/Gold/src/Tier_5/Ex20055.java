package Tier_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Ex20055 {
	static int n,k,ans;
	static LinkedList<velt> v = new LinkedList<velt>();
	
	static class velt{
		int num;
		boolean robot;
		public velt(int num, boolean robot) {
			super();
			this.num = num;
			this.robot = robot;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n*2;i++) {
			v.add(new velt(Integer.parseInt(st.nextToken()),false));
		}
		
		while(k>0) {
			v.addFirst(v.pollLast()); // 1. 벨트 회전, 안에 로봇이 있으면 같이 돌아감
			velt r = v.get(n-1);
			if(r.robot) {
				r.robot = false;
			}
			for(int i=n-2;i>=0;i--) { // 2. 로봇 움직임
				velt now = v.get(i);
				velt next = v.get(i+1);
				if(now.robot && !next.robot && next.num!=0) {
					if(i+1==n-1) { //내리는 위치에 이동하면 어짜피 로봇은 내려가니까 현재 로봇만 비우기
						now.robot = false;
					} else { // 내리는 위치가 아니면 다음에 적재하고 현재로봇 비우기
						now.robot = false;
						next.robot = true;
					}
					if(--next.num==0) {  // 로봇이 올라간 자리는 내구도 감소
						k--;
					}
				}
			}
			
			velt start = v.get(0);
			if(start.num!=0) {
				start.robot = true;
				if(--start.num == 0) {
					k--;
				}
			}
			ans++;
		}
		
		System.out.println(ans);
	}
}
