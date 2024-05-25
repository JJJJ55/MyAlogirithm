package Tier_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex19236 {
	static int map[][] = new int[4][4];
	static Fish fish[];
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
	static int ans;
	
	static class Fish{
		int num;
		int x;
		int y;
		int dir;
		int life;
		public Fish(int num, int x, int y, int dir, int life) {
			super();
			this.num = num;
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.life = life;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		fish = new Fish[17];
		for(int i=0;i<4;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken())-1;
				fish[num] = new Fish(num,i,j,dir,1);
				map[i][j] = num;
			}
		}
		
		int si = 0;
		int sj = 0;
		int sd = fish[map[0][0]].dir;
		int eat = map[0][0];
		
		fish[map[0][0]].life = 0;
		map[0][0] = -1; // 상어 위치
		
		dfs(si,sj,sd,eat);
		System.out.println(ans);
	}
	
	static void dfs(int sx, int sy, int sd, int eat) {
		ans = Math.max(ans, eat);
		
		int [][] test = new int[map.length][map.length];
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				test[i][j] = map[i][j];
			}
		}
		
		Fish[] testFish = new Fish[fish.length];
		for(int i=1;i<=16;i++) {
			testFish[i] = new Fish(fish[i].num, fish[i].x, fish[i].y, fish[i].dir, fish[i].life);
		}
		
		moveFish();
		
		for(int i=1;i<4;i++) {
			int nx = sx+dx[sd]*i;
			int ny = sy+dy[sd]*i;
			
			if(nx>=0 && nx<4 && ny>=0 &&ny<4 && map[nx][ny]!=0) {
				int eatFish = map[nx][ny];
				int nd = fish[eatFish].dir;
				map[sx][sy] = 0;
				map[nx][ny] = -1;
				fish[eatFish].life = 0;
				
				dfs(nx,ny,nd,eat+eatFish);
				
				fish[eatFish].life = 1;
				map[sx][sy] = -1;
				map[nx][ny] = eatFish;
			}
		}
		
		for(int j = 0; j < map.length; j++) 
			System.arraycopy(test[j], 0, map[j], 0, map.length);

		for(int i=1; i<=16; i++)
			fish[i] = new Fish(testFish[i].num, testFish[i].x, testFish[i].y, testFish[i].dir, testFish[i].life);
	}
	
	static void moveFish() {
		for(int i=1;i<=16;i++) {
			if(fish[i].life==0) continue;
			int cnt = 0;
			int dir = fish[i].dir;
			int nx = 0, ny = 0;
			
			while(cnt<8) {
				dir%=8;
				fish[i].dir = dir;
				
				nx = fish[i].x + dx[dir];
				ny = fish[i].y + dy[dir];
				
				if(nx>=0 && nx<4 && ny>=0 && ny<4 && map[nx][ny] !=-1) {
					if(map[nx][ny]==0) {
						map[fish[i].x][fish[i].y]= 0;
						fish[i].x = nx;
						fish[i].y = ny;
						map[nx][ny] = i;
					} else {
						int temp = fish[map[nx][ny]].num;
						fish[temp].x = fish[i].x;
						fish[temp].y = fish[i].y;
						map[fish[temp].x][fish[temp].y] = temp;
						
						fish[i].x = nx;
						fish[i].y = ny;
						map[nx][ny] = i;
					}
					break;
				} else {
					dir++;
					cnt++;
				}
			}
		}
	}

}
