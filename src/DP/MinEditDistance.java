package DP;

import java.util.Scanner;

public class MinEditDistance {
    public static int min(int a, int b, int c) {
        a = a < b ? a : b;
        return a < c ? a : c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();
        System.out.println(word1 + " " + word2);

        int[][] d = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i <= word1.length(); i++) d[i][0] = i;
        for (int i = 0; i <= word2.length(); i++) d[0][i] = i;

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    d[i][j] = min(d[i - 1][j], d[i][j - 1], d[i - 1][j - 1]) + 1;
                } else {
                    d[i][j] = min(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1]);
                }
            }
        }
        System.out.println(d[word1.length()][word2.length()]);
        System.out.println(MinEditDistance2.minDistance(word1, word2));
    }
}
/*
abc abd
abc ab
aaacaaa aaadaaa
adf basdf
 */