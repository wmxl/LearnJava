package BiShiTi.ZiJieTiaoDong;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

class State {
    int count, x, y, z;

    public State(int count, int x, int y, int z) {
        this.count = count;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] size = new int[3];
        int[] next = new int[3];
        int[] now = new int[3];
        while (sc.hasNextInt()) {
            size[0] = sc.nextInt();
            size[1] = sc.nextInt();
            size[2] = sc.nextInt();
            int w = sc.nextInt();
            boolean v[][][] = new boolean[size[0] + 1][size[1] + 1][size[2] + 1];
            int count = 0;
            v[0][0][0] = true;
            for (int i = 0; i < 3; i++) {
                now[i] = 0;
                next[i] = 0;
            }
            LinkedList<State> q = new LinkedList<>();

            while (true) {
//                if (!v[lx = xT < (y - yT) ? 0 : xT - (x - xT)][ly = xT < (y - yT) ? yT + xT : y][zT]) //x->y
                for (int i = 0; i < 3; i++) { //倒满
                    if(i == 0){
                        if(!v[size[0]][now[1]][now[2]])
                            q.add(new State(count+1, size[0], now[1], now[2]));
                    }
                    if(i == 1){
                        if(!v[now[0]][size[1]][now[2]])
                            q.add(new State(count+1, now[0], size[1], now[2]));
                    }
                    if(i == 2){
                        if(!v[now[0]][now[1]][size[2]])
                            q.add(new State(count+1, now[0], now[1], size[2]));
                    }
                }
                int x, y, z;
                for (int i = 0; i < 2; i++) { //互相倒
                    if(i == 0){
                        if(!v[now[0]]
                                [next[1] = now[1] < (size[2] - now[2]) ? 0 : now[1] - (size[1] - now[1])]
                                [next[2] = now[1] < (size[2] - now[2]) ? now[2] + now[1] : size[2]]
                                 ){
                            q.add(new State(count+1, now[0], next[1], next[2]));
                        }
                        if(!v[next[0] = now[0] < (size[2] - now[2]) ? 0 : now[0] - (size[0] - now[0])]
                                [now[1]]
                                [next[2] = now[0] < (size[2] - now[2]) ? now[2] + now[0] : size[2]]
                        ){
                            q.add(new State(count+1, next[0], now[1], next[2]));
                        }
                        if(!v[next[1] = now[1] < (size[0] - now[0]) ? 0 : now[1] - (size[1] - now[1])]
                                [next[0] = now[1] < (size[0] - now[0]) ? now[0] + now[1] : size[0]]
                                [now[2]]
                        ){
                            q.add(new State(count+1, next[0], next[1], now[2]));
                        }
                    }
                    if(i == 1){
                        if(!v[now[0]]
                                [next[2] = now[2] < (size[1] - now[1]) ? 0 : now[2] - (size[2] - now[2])]
                                [next[1] = now[2] < (size[1] - now[1]) ? now[1] + now[2] : size[1]]
                        ){
                            q.add(new State(count+1, now[0], next[1], next[2]));
                        }
                        if(!v[next[0] = now[0] < (size[2] - now[2]) ? 0 : now[0] - (size[0] - now[0])]
                                [now[1]]
                                [next[2] = now[0] < (size[2] - now[2]) ? now[2] + now[0] : size[2]]
                        ){
                            q.add(new State(count+1, next[0], now[1], next[2]));
                        }
                        if(!v[next[1] = now[1] < (size[0] - now[0]) ? 0 : now[1] - (size[1] - now[1])]
                                [next[0] = now[1] < (size[0] - now[0]) ? now[0] + now[1] : size[0]]
                                [now[2]]
                        ){
                            q.add(new State(count+1, next[0], next[1], now[2]));
                        }
                    }
                }
                if(q.size() > 0){
                    State k = (State) q.poll();
                    if(k.x == w || k.y == w || k.z == w)
                        System.out.println(k.count);

                }else
                    System.out.println(-1);
            }
        }
    }

}
/*
3 5 8 4

 */
