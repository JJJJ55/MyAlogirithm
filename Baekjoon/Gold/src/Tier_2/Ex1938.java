package Tier_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Ex1938 {
	static int n;
	static char arr[][];
	static point[] sw, ew;
	static int di[] = { -1, 1, 0, 0 };
	static int dj[] = { 0, 0, -1, 1 };

	static class wood {
		int x, y, dir, dist;

		public wood(int x, int y, int dir, int dist) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.dist = dist;
		}
	}

	static class point {
		int x, y;

		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];

		sw = new point[3];
		ew = new point[3];

		int sidx = 0;
		int eidx = 0;
		for (int i = 0; i < n; i++) {
			char c[] = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				arr[i][j] = c[j];
				if (arr[i][j] == 'B') {
					sw[sidx++] = new point(i, j);
				}
				if (arr[i][j] == 'E') {
					ew[eidx++] = new point(i, j);
				}
			}
		}

		int ans = bfs();
		System.out.println(ans);
	}

	static int bfs() {
		Queue<wood> q = new LinkedList<>();
		boolean[][][] visit = new boolean[2][n][n];

		int dir = 0;
		if (sw[0].y + 1 == sw[1].y) {
			dir = 0; // 가로
		} else {
			dir = 1; // 세로
		}

		q.add(new wood(sw[1].x, sw[1].y, dir, 0));
		visit[dir][sw[1].x][sw[1].y] = true;

		while (!q.isEmpty()) {
			wood w = q.poll();
			int curX = w.x;
			int curY = w.y;
			int curDir = w.dir;
			int curDist = w.dist;

			if (curX == ew[1].x && curY == ew[1].y) {
				if (curDir == 0 && arr[curX][curY - 1] == 'E' && arr[curX][curY + 1] == 'E') {
					return curDist;
				}
				else if (curDir == 1 && arr[curX - 1][curY] == 'E' && arr[curX + 1][curY] == 'E') {
					return curDist;
				}
			}

			for (int t = 0; t < 4; t++) {
				int nx = curX + di[t];
				int ny = curY + dj[t];

				if (!checkRange(curDir, nx, ny, t))
					continue;

				if (visit[curDir][nx][ny])
					continue;

				visit[curDir][nx][ny] = true;
				q.add(new wood(nx, ny, curDir, curDist + 1));
			}

			if (canRotate(curX, curY)) {
				if (curDir == 0 && !visit[1][curX][curY]) {
					visit[1][curX][curY] = true;
					q.add(new wood(curX, curY, 1, curDist + 1));
				}
				else if (curDir == 1 && !visit[0][curX][curY]) {
					visit[0][curX][curY] = true;
					q.add(new wood(curX, curY, 0, curDist + 1));
				}
			}

		}
		return 0;
	}

	static boolean checkRange(int dir, int x, int y, int t) {
		switch(dir) {
    	case 0:
    		if(t < 2) {
    			if(x < 0 || x >= n) return false;
    			if(arr[x][y] == '1' || arr[x][y - 1] == '1' || arr[x][y + 1] == '1') return false;
    		} 
    		else {

    			if(y - 1 < 0 || y + 1 >= n) return false;
    			if(arr[x][y] == '1' || arr[x][y - 1] == '1' || arr[x][y + 1] == '1') return false;
    		}

    		break;	
    	case 1:
    		if(t < 2) {

    			if(x - 1 < 0 || x + 1 >= n) return false;

    			if(arr[x][y] == '1' || arr[x - 1][y] == '1' || arr[x + 1][y] == '1') return false;
    		} 

    		else {

    			if(y < 0 || y >= n) return false;

    			if(arr[x][y] == '1' || arr[x - 1][y] == '1' || arr[x + 1][y] == '1') return false;
    		}
    		
    		break;
    		
    	default:
    		break;
		}
		return true;
	}

	static boolean canRotate(int x, int y) {
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (i < 0 || i >= n || j < 0 || j >= n) {
					return false;
				}
				if (arr[i][j] == '1') {
					return false;
				}
			}
		}
		return true;
	}

}
