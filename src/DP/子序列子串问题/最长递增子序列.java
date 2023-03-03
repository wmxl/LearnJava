package DP.子序列子串问题;

public class 最长递增子序列 {
    //普通dp （n^2）
    public int lengthOfLIS1(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    //二分查找 （nlogn）
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        dp[max] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > dp[max]) {
                dp[++max] = nums[i];
            }
            else{
                int l = 0, h = max;
                while (l < h){
                    int m = (l+h)/2;
                    if(dp[m] < nums[i]) l = m + 1;
                    else h = m;
                }
                dp[l] = nums[i];
            }
        }
        return max+1;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int[] nums1 = {4,10,4,3,8,9};
        int[] nums2 = { 7,7,7,7};
        int[] nums3 = { 2,3,4,1,2};
        System.out.println(new 最长递增子序列().lengthOfLIS(nums1));
    }
}
