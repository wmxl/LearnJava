package BFS;//要删除

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class N{
    int x, y;
    public N(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class RedAndBlack {// 类名要改成Main
    static Queue<N> q = new LinkedList<N>();
    static char room[][] = new char[21][21];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int w,h;

//    static int dfsSum = 0;
//    static boolean[][] v = new boolean[21][21];
    public static int bfs(int x, int y){
        int sum = 1;
        while(!q.isEmpty()) q.remove();
        boolean[][] v = new boolean[21][21];
        N st = new N(x, y);
        v[x][y] = true;
        q.add(st);

        while(!q.isEmpty()){
            N now = q.poll();
            for(int i = 0; i < 4; i++){
                N next = new N(now.x, now.y);
                next.x += dx[i];
                next.y += dy[i];
//                System.out.println(next.x + " " + next.y);
                if(next.x < 0 || next.x >= h ||next.y < 0 || next.y >= w) continue;
                if(v[next.x][next.y]) continue;

                if(room[next.x][next.y] == '#') continue;
                v[next.x][next.y] = true;
                sum++;
                q.add(next);
            }
        }
        return sum;
    }

//    public static void dfs(int x, int y){
//        if(x < 0 || x >= h ||y< 0 || y >= w) return;
//        if(v[x][y]) return ;
//        if(room[x][y] == '#') return ;
//        v[x][y] = true;
//        dfsSum++;
//        for(int i = 0; i < 4; i++){
//            int next_x = x + dx[i];
//            int next_y = y + dy[i];
////            System.out.println(next_x +" "+next_y);
//            dfs(next_x, next_y);
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            w = sc.nextInt();
            h = sc.nextInt();
            if (w == 0 && h == 0) break;
            for (int i = 0; i < h; i++) {
                room[i] = sc.next().toCharArray();
            }

            int x = 0, y = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (room[i][j] == '@') {
                        x = i;
                        y = j;
                    }
                }
            }
//            dfsSum = 0;
//            v = new boolean[21][21];
//            dfs(x,y);
//            System.out.println(dfsSum);
            System.out.println(bfs(x,y));
        }
    }
}
