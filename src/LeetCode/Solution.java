package LeetCode;


import java.util.*;

public class Solution {
    public static int min(int a, int b) {
        return a < b ? a : b;
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public boolean isContinuous(int [] a) {
        for(int i = 0; i < 4; i++){
            int min = i;
            for(int j = i+1; j < 5; j++){
                if(a[min] > a[j]){
                    min = j;
                }
            }
            int t = a[min];
            a[min] = a[i];
            a[i] = t;
        }
        System.out.println(Arrays.toString(a));
        int cnt = 0;
        for(int i = 0; i < 5; i++){
            if(a[i] == 0) cnt++;
        }
        for(int i = cnt+1; i < 5; i++){
            int cha = a[i] - a[i-1];
            if(cha == 0) return false;
            if(cha - 1 > cnt){
                return false;
            }else{
                cnt -= (cha - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol  = new Solution();
        int[] a = {1,2,4,5,3};
        System.out.println(sol.isContinuous(a));
    }

}