package BiShiTi.WangYi2;

import java.util.*;

public class Main2 {
    static int m, n, ma, cnt;
    static int[][] mat;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] v = new boolean[m][n];


    public static void dfs(int x, int y, int c) {

        if (x >= m || x < 0 || y >= n || y < 0) return;
        if (v[x][y]) return;
        if(mat[x][y] != c) return;
        v[x][y] = true;
        cnt++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            dfs(nx, ny, c);
        }
    }

    public static int[][] copy(int[][] mat){
        int[][] res = new int[m][n];
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j] == -1){
                    continue;
                }else {
                    res[i][k++] = mat[i][j];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (; k < n; k++) {
                res[i][k] = -1;
            }
        }
        return res;
    }

    public static void change() {
        System.out.println("before change:");
        print(mat);
        print(v);
        int st = -1, ed = -1, count = 0;
        //处理方块下降
        for (int j = 0; j < n; j++) {
            count = 0;
            for (int i = 0; i < m; i++) {
                if(v[i][j]){
                    st = i;
                    count = 0;
                    for (int k = i; k < m; k++) {
                        System.out.println("k" + k);
                        if(v[k][j]){
                            count++;
                        }
                    }
                    break;
                }
            }
            int k = count;
            System.out.println("第" + " " + j + " 列");
            System.out.println("count = " + count);
            for (; k > 0 ; k--) {
                int before = st + k - 1;
                int after = st + k - 1 - count;
                System.out.println("before = " + before);
                System.out.println("after = " + after);
                if(after < 0){
                    mat[before][j] = -1;
                }else
                    mat[before][j] = mat[after][j];
            }
            for (int i = 0; i < count; i++) {
                mat[i][j] = -1;
            }
        }

        //处理左移
        count = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if(mat[i][j] == -1)
                    count++;
            }
            if(count == m -1){
                mat = copy(mat);
            }
        }
        print(mat);

    }
    public static void print(boolean[][] mat){
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static void print(int[][] mat){
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            m = sc.nextInt();
            n = sc.nextInt();
            mat = new int[m][n];
            String uesless = sc.nextLine(); // 先nextInt(); 再sc.nextLine()的， 循环前一定要加这一行
            for (int i = 0; i < m; i++) {
                String s = sc.nextLine();
                for (int j = 0; j < n; j++) {
                    mat[i][j] = s.charAt(j) - '0';
                }
            }
            ma = cnt = 0;
            v = new boolean[m][n];
            int ii = 0, jj = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(!v[i][j]){
                        cnt = 0;
                        dfs(i,j, mat[i][j]);
                        if(cnt> ma){
                            ma = cnt;
                            ii = i;
                            jj  = j;
                        }
                        System.out.println("cnt = " + cnt);
                        System.out.println("ma = " + ma);
                    }
                }
            }
            System.out.println("ii, jj"+ " " + ii + " " + jj);
            v = new boolean[m][n];
            dfs(ii,jj,mat[ii][jj]);
            change();
        }
    }
}
/*
4
5 5
25254
32234
23222
22222
22443

 */