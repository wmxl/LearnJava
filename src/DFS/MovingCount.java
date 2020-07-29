package DFS;

import java.util.Arrays;

public class MovingCount {
    int cnt, m, n, k;
    int dx[] = {0, 0, 1, -1};
    int dy[] = {1, -1, 0, 0};
    boolean v[][] = new boolean[999][999];

    void dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) return;
        if (v[x][y]) return;
        int sum = 0, xx = x, yy = y;
        while (xx > 0) {
            sum += xx % 10;
            xx /= 10;
        }
        while (yy > 0) {
            sum += yy % 10;
            yy /= 10;
        }
        if (sum > k) return;
        v[x][y] = true;
        cnt++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            dfs(nx, ny);
        }
    }

    int movingCount(int threshold, int rows, int cols) {
        n = rows;
        m = cols;
        k = threshold;
        cnt = 0;
        dfs(0, 0);
        return cnt;
    }

    public static void main(String[] args) {
        int a = new MovingCount().movingCount(10,1,100);
        System.out.println(a);
    }
}
