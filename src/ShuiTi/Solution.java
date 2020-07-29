package ShuiTi;

import java.util.*;

class Solution {
    public int f(String s){
        char z  = 'z';
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) < z) z = s.charAt(i);
        }
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == z)
                cnt ++;
        }
        return cnt;
    }
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int cnt = 0;
            for (int j = 0; j < words.length; j++) {
                if(f(queries[i]) < f(words[j]))
                    cnt++;
            }
            ans[i] = cnt;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}