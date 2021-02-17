package 矩形问题.最大矩阵;

/**
 * 85.最大矩阵
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 和柱状图中的最大矩阵类似，先做预处理，出了第一行，其他每行mat[i][j] = mat[i - 1][j] + 1，
 * 意思是到这个点的连续为1的个数
 * 然后就把每行看作是求柱形图的最大矩阵就行了
 */
public class Solution {

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;

        int[][] mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = matrix[i][j] - '0';
            }
        }

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= 1 && mat[i][j] == 1) {
                    mat[i][j] = mat[i - 1][j] + 1;
                }
                dp[i][j] = mat[i][j];
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (mat[i][k] >= mat[i][j]) {
                        dp[i][j] += mat[i][j];
                    } else break;
                }
                for (int k = j - 1; k >= 0; k--) {
                    if (mat[i][k] >= mat[i][j]) {
                        dp[i][j] += mat[i][j];
                    } else break;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
