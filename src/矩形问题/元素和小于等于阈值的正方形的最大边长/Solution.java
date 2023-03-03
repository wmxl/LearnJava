package 矩形问题.元素和小于等于阈值的正方形的最大边长;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/*
1292. 元素和小于等于阈值的正方形的最大边长
给你一个大小为 m x n 的矩阵 mat 和一个整数阈值 threshold。

请你返回元素总和小于或等于阈值的正方形区域的最大边长；如果没有这样的正方形区域，则返回 0 。

链接：https://leetcode-cn.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold
*/
public class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int cnt = 0;
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = mat[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k+i < m && k+j < n; k++) {
                    if(dp[k+i+1][k+j+1] + dp[i][j] - dp[k+i+1][j] - dp[i][k+j+1] <= threshold)
                        cnt++;
                }
            }
        }
        return cnt;
    }

}
