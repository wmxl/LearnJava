package 矩形问题.区域矩阵和;

/**
 给你一个 m * n 的矩阵 mat 和一个整数 K ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和： 

 i - K <= r <= i + K, j - K <= c <= j + K 
 (r, c) 在矩阵内。

 */
public class Solution {

    //暴力
    public int[][] matrixBlockSum1(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int r = i - k >= 0? i - k : 0; r <= i + k && r < m; r++) {
                    for (int c = j - k >= 0? j -k : 0; c <= j + k  && c < n; c++) {
                        ans[i][j] += mat[r][c];
                    }
                }
            }
        }
        return ans;
    }

    //二维矩阵前缀和
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = mat[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int rightDown_i = Math.min(i+k, m-1);
                int rightDown_j = Math.min(j+k, n-1);
                int leftUp_i = Math.max(i-k, 0);
                int leftUp_j = Math.max(j-k, 0);

                ans[i][j] = dp[rightDown_i+1][rightDown_j+1] - dp[leftUp_i][rightDown_j+1] - dp[rightDown_i+1][leftUp_j]
                        + dp[leftUp_i][leftUp_j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3}, {4,5,6},{7,8,9}}; int K = 1;
        int[][] ans = new Solution().matrixBlockSum(mat, K);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
