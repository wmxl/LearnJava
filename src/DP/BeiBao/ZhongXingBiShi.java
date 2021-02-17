package DP.BeiBao;

public class ZhongXingBiShi {
    public static int max(int a, int b){
        return a > b ? a : b;
    }
    public int zhongxing(int V, int N, int M, int[] v, int[] m, int[] e){
        int[][][] dp =  new int[N+9][V+9][M+9];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= V; j++) {
                for (int k = 0; k <= M; k++) {
                    if(i == 0) {
                        if (j >= v[i] && k >= m[i]){
                            dp[i][j][k] = e[i];
                        }
                        continue;
                    }
                    if(j >= v[i] && k >= m[i])
                        dp[i][j][k] =  max(dp[i-1][j][k], dp[i-1][j- v[i]][k - m[i]] + e[i]);
                    else
                        dp[i][j][k] = dp[i-1][j][k];
                }
            }
        }
        return dp[N-1][V][M];
    }


    public static void main(String[] args) {
        int V = 100;
        int N = 5;
        int M = 15;
        int[] v = {50, 40, 30, 20, 10};
        int[] m = {1, 2, 3 , 9, 5};
        int[] e = {300, 480, 270, 200, 180};

        int[][][] dp =  new int[5][99][99];
        int[] log = new int[5];

        System.out.println(new ZhongXingBiShi().zhongxing(V, N, M, v, m, e));;

    }
}
