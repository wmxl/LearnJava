package DP;

import java.util.Arrays;

public class LIS {
    int max(int a, int b) {
        return a > b ? a : b;
    }

    public int lengthOfLIS(int[] a) {
        if(a.length == 0) return 0;
        int dp[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    dp[i] =  max(dp[i], dp[j] + 1);
                }
            }
        }
        Arrays.sort(dp);
        return dp[a.length - 1];
    }

    public int lengthOfLIS2(int[] a) {
        if(a.length == 0) return 0;
        int dp[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            dp[i] = 1;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] > a[i] && dp[i] + 1 > dp[j]) {
                    dp[j] = dp[i] + 1;
                }
            }
        }
        Arrays.sort(dp);
        return dp[a.length - 1];
    }

    public static void main(String[] args) {

    }
}
