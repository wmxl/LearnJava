package 矩形问题.统计全1子矩形;

/*
1504. 统计全 1 子矩形
给你一个只包含 0 和 1 的 rows * columns 矩阵 mat ，请你返回有多少个 子矩形 的元素全部都是 1 。
 */
public class Solution {

    //最纯的暴力
    public int numSubmat1(int[][] mat) {//这样暴力是可以过的，精髓是第三个break
        int n = mat.length;
        int m = mat[0].length;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = i; k < n; k++) {
                    for (int l = j; l < m; l++) {
                        boolean flag = true;
                        for (int o = i; o <= k; o++) {
                            for (int p = j; p <= l; p++) {
                                if (mat[o][p] != 1) {
                                    flag = false;
                                    break;
                                }
                                if (!flag) break;
                            }
                        }
                        if (flag) cnt++;
                        else break;
                    }
                }
            }
        }
        return cnt;
    }

    //二维前缀和
    public int numSubmat2(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i-1][j-1];
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = i; k < n; k++) {
                    for (int l = j; l < m; l++) {
                        int sum = dp[k+1][l+1] - dp[i][l+1] - dp[k+1][j] + dp[i][j];
                        if (sum == (k - i + 1) * (l - j + 1)) cnt++;
                        else break;
                    }
                }
            }
        }
        return cnt;
    }

    //根据柱形图中最大矩阵方法改的
    public int numSubmat3(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1)
                    mat[i][j] = mat[i - 1][j] + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int height = mat[i][j];
                for (int k = 1; k <= height; k++) {
                    int width = 0;
                    for (int l = j; l < m; l++) {
                        if (mat[i][l] >= k) {
                            width++;
                        } else break;
                    }
                    cnt += width;
                }
            }
        }
        return cnt;
    }

    //方法3 再优化，保存中间状态
    public int numSubmat(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1)
                    mat[i][j] = mat[i - 1][j] + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int min = mat[i][j];
                for (int l = j; l < m; l++) {
                    min = Math.min(min, mat[i][l]);
                    if (min > 0) {
                        cnt += min;
                    } else break;
                }
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
        System.out.println(new Solution().numSubmat(mat));
    }
}
