package 矩形问题.元素和为目标值的子矩阵数量;
/*
1074. 元素和为目标值的子矩阵数量
给出矩阵 matrix 和目标值 target，返回元素总和等于目标值的非空子矩阵的数量。
子矩阵 x1, y1, x2, y2 是满足 x1 <= x <= x2 且 y1 <= y <= y2 的所有单元 matrix[x][y] 的集合。
如果 (x1, y1, x2, y2) 和 (x1', y1', x2', y2') 两个子矩阵中部分坐标不同（如：x1 != x1'），那么这两个子矩阵也不同。

链接：https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target
*/
public class Solution {
    //二维数组前缀和 + 暴力
    public int numSubmatrixSumTarget1(int[][] mat, int target) {
        int cnt = 0;
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = mat[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int r = i; r < m; r++) {
                    for (int c = j; c < n; c++) {
                        if(dp[r+1][c+1] + dp[i][j] - dp[i][c+1] - dp[r+1][j] == target)
                            cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    //压缩成一维
    public int numSubmatrixSumTarget(int[][] mat, int target) {
        int cnt = 0;
        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i < m; i++) {
            int[] a = new int[n];
            for (int i1 = i; i1 < m; i1++) {
                for (int j = 0; j < n; j++) {  //这里二维压缩一维的时候，我开始写成了3层循环，实际上2层就可以
                    a[j] += mat[i1][j];
                }

                for (int j = 0; j < n; j++) {
                    int sum = 0;
                    for (int k = j; k < n; k++) {
                        sum += a[k];
                        if(sum == target) cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[][] mat = {{0,1,0},{1,1,1},{0,1,0},};
        System.out.println(new Solution().numSubmatrixSumTarget(mat,0));

    }
}
