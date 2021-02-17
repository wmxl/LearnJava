package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
    int x,t;
    public Node(int x, int t) {
        this.x = x;
        this.t = t;
    }
}

public class Main {//抓奶牛
    static Queue<Node> q = new LinkedList<Node>();
    public static int[] mat = new int[100005];
    public static  int n, k;

    public static int bfs(int x){

        while(!q.isEmpty()) q.remove();
        boolean[] v = new boolean[100005];
        Node st = new Node(x, 0);
        v[x] = true;
        q.add(st);
        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.x == k){
                return now.t;
            }
            for(int i = 0; i < 3; i++){
                Node next = new Node(now.x, now.t);
                if(i == 0) next.x = now.x + 1;
                else if(i == 1) next.x = now.x - 1;
                else next.x = now.x * 2;
                next.t = now.t + 1;
                if(next.x < 0 || next.x > 100000 ) continue;
                if(v[next.x]) continue;
                v[next.x] = true;
                q.add(next);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            n = sc.nextInt();
            k = sc.nextInt();
            System.out.println(bfs(n));
        }
    }
}
