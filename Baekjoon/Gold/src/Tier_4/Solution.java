package Tier_4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
    static int arr[][],n,m,cnt,result;
    static boolean visit[];
    static int num[];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
         
        arr = new int[n+1][n+1];
        num = new int[n+1];
        result = 0;
         
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
             
            arr[from][to]= 1;
        }
         
        for(int i=1;i<=n;i++) {
            bfs1(i);
            num[i]+=cnt;
            bfs2(i);
            num[i]+=cnt;
            if(num[i]==n-1) {
                result++;
            }
        }
         
        System.out.println(result);
    }
     
    static void bfs1(int idx) { //키 작은 순
        visit = new boolean[n+1];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(idx);
        visit[idx] = true;
        cnt = 0;
         
        while(!q.isEmpty()) {
            int tmp = q.poll();
             
            for(int i=1;i<=n;i++) {
                if(arr[i][tmp]==1 && !visit[i]) {
                    cnt++;
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
    }
    static void bfs2(int idx) { // 키 큰 순
        visit = new boolean[n+1];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(idx);
        visit[idx] = true;
        cnt = 0;
         
        while(!q.isEmpty()) {
            int tmp = q.poll();
             
            for(int i=1;i<=n;i++) {
                if(arr[tmp][i]==1 && !visit[i]) {
                    cnt++;
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
    }
}