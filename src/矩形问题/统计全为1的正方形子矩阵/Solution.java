package 矩形问题.统计全为1的正方形子矩阵;

/*
1277. 统计全为 1 的正方形子矩阵
给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 */
public class Solution {

    //二维前缀和
    public int countSquares1(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i-1][j-1];
            }
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; i + k < m && j + k < n; k++) {
                    int sum = dp[i+k+1][j+k+1] - dp[i][j+k+1] - dp[i+k+1][j] + dp[i][j];
                    if(sum == (k+1)*(k+1)) cnt++;
                    else break;
                }
            }
        }
        return cnt;
    }

    //dp
    public int countSquares(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i != 0 && j != 0 && mat[i][j] != 0)
                    mat[i][j] = Math.min(Math.min(mat[i-1][j], mat[i][j-1]), mat[i-1][j-1]) + 1;
                cnt += mat[i][j];
            }
        }
        return cnt;
    }



    public static void main(String[] args) {
        int[][] mat = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0},
        };
        int[][] mat1 = {
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 1, 1, 0},
        };
        int[][] mat2 = {
                {1, 1, 1, 1, 1, 1}
        };
        System.out.println(new Solution().countSquares(mat));
    }
}
