package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class QueueTest {
	
	static class test implements Comparable<test>{
		int x,y;

		public test(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "test [x=" + x + ", y=" + y + "]";
		}
		@Override
		public int compareTo(test o) {
			return this.y-o.y;
		}
		
	}
	
	static Deque<test> q = new LinkedList<QueueTest.test>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=0;i<10;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			q.add(new test(x,y));
		}
		
		int size = q.size();
		for(int i=0;i<size;i++) {
			test t = q.poll();
			System.out.println(t.toString());
		}
	}
}
