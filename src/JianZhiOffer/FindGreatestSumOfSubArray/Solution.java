package JianZhiOffer.FindGreatestSumOfSubArray;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

public class Solution {

    public int FindGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int sum = dp[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] > 0)
            {//                200, -100, 50/150
                dp[i] =  Math.max(dp[i-1], sum + array[i]);
                sum = dp[i];
            }else{
                sum = dp[i-1] + array[i];
                if(sum < 0) sum = 0;
                dp[i] = Math.max(dp[i-1], array[i]);
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println("");
        for (int i = 0; i < array.length; i++) {
            System.out.print(dp[i] + "\t");
        }
        System.out.println("");

        return dp[array.length-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,-2,3,10,-4,7,2,-5};
        int[] arr2 = {-4,-3,-5,-2,-1,-9};
        int a = solution.FindGreatestSumOfSubArray(arr2);
        System.out.println(a);
    }
}
