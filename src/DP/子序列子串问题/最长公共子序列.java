package DP.子序列子串问题;

public class 最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] d  = new int[text1.length()+1][text2.length()+1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if(text1.charAt(i) == text2.charAt(j))
                    d[i][j] = d[i-1][j-1] + 1;
                else
                    d[i][j] = Math.max(d[i-1][j], d[i][j-1]);
            }
        }
        return d[text1.length()][text2.length()];
    }

    public static void main(String[] args) {

    }
}
