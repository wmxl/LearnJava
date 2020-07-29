package BiShiTi.XiaoHongShu;

import java.util.Scanner;


public class Main {
    public static int[] parent;
    public static int find(int x){
        return parent[x] == x ? x : find(parent[x]);
    }
    public static void union(int x, int y) {
        int p1 = find(x);
        int p2 = find(y);
        parent[p1] = p2;
    }
    public static void main(String arg[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            parent = new int[n];
            int[][] mat = new int[n][n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                for (int j = 0; j < n; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    if(mat[i][j] == 1){
                        union(i, j);
                    }
                }
            }
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if(parent[i] == i) cnt++;
            }
            System.out.println(cnt);
        }
    }


}
/*
3
1 1 0
1 1 0
0 0 1
 */