package DP.BeiBao;

import java.util.Arrays;

public class Solution {
    public static int max(int a, int b){
        return a > b ? a : b;
    }
    public static void main(String[] args) {
        int[] w = {2, 3, 4, 5};
        int[] v = {3, 6, 5, 8};
        int[] dp = new int[9];
        int capacity = 8;

//        if(w[0] <= capacity)
//            dp[w[0]] = v[0];
//        for (int i = 1; i < 4; i++) {
//            if(w[i] <= capacity){
//                dp[w[i]] = max(dp[w[i-1]], v[i]);
//            }
//        }
//        System.out.println(Arrays.toString(dp));
//        //可以多次取的背包（完全背包）
//        for (int j = 1; j <= capacity; j++) {
////            System.out.println("j = " + j);
//            dp[j] = dp[j-1];
//            for (int i = w.length-1; i >= 0; i--) {
//                if(j >= w[i]){
//                    dp[j] = max(dp[j],dp[j - w[i]] + v[i]);
//                }
//            }
//        }
//        System.out.println(Arrays.toString(dp));

        //01背包
        System.out.println("-------01----------");
        int[][] d = new int[5][9];
        d[0][0] = 0;
//        for (int j = 0; j <= capacity; j++) {
//            if(j >= w[0])
//                d[0][j] = v[0];
//        }
//        System.out.println(Arrays.toString(d[0]));
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= capacity; j++) {
                if(i == 0){
                    if(j >= w[i])
                        d[0][j] = v[0];
                    continue;
                }
                if(j >= w[i])
                    d[i][j] = max(d[i-1][j],d[i-1][j - w[i]] + v[i]);
                else {
                    d[i][j] = d[i-1][j];
                }
            }
            System.out.println("d[i]: " +Arrays.toString(d[i]));
        }







    }
}
