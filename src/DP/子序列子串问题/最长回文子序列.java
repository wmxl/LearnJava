package DP.子序列子串问题;

public class 最长回文子序列 {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = len-1; i > -1; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < len; j++) {
                if(s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i+1][j-1] + 2;
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        return  dp[0][len-1];
    }
}