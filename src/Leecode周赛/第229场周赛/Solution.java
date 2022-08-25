package Leecode周赛.第229场周赛;

public class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while(i < len1 && i < len2){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
            i++;
        }
        int j = i;
        while(i < len1){
            sb.append(word1.charAt(i));
            i++;
        }
        while(j < len2){
            sb.append(word2.charAt(j));
            j++;
        }
        return sb.toString();
    }

    public int[] minOperations(String boxes) {
        int len = boxes.length();
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = 0;
            for (int j = 0; j < len; j++) {
                if(i == j) continue;
                if(boxes.charAt(j) == '1'){
                    ans[i] += Math.abs(i - j);
                }
            }
        }
        return ans;
    }

    public int maximumScore1(int[] n, int[] m) {
        int[][] ans = new int[n.length+1][n.length+1];
        int max = -99999999;
        for (int l = m.length - 1; l >= 0; l--) {
            for (int r = n.length-m.length; r < n.length; r++) {
                int i = n.length - 1 - (r - l);
                if(l > r || i >= m.length){
                    ans[l][r] = 0;
                    continue;
                }
                int left = m[i] * n[l];
                int right = m[i] * n[r];

                if(r == 0)
                    ans[l][r] = Math.max(left, right);
                else
                    ans[l][r] = Math.max(ans[l+1][r] + left, ans[l][r-1] + right);
                max = Math.max(max, ans[l][r]);
            }
        }
        return max;
    }


    int[][] ans;
    int[] n, m;
    int dfs(int i, int l, int r){
        if(i >= m.length) return 0;
        if(this.ans[i][l] != -9994) return ans[i][l];

        int left = m[i] * n[l];
        int right = m[i] * n[r];

        ans[i][l] = Math.max(dfs(i+1,l+1, r) + left, dfs( i+1, l, r-1) + right);
        return ans[i][l];
    }
    public int maximumScore(int[] nums, int[] multipliers) {
        n = nums;
        m = multipliers;
        ans = new int[m.length +1][m.length +1];
        for (int i = 0; i < multipliers.length; i++) {
            for (int j = 0; j < multipliers.length; j++) {
                ans[i][j] = -9994;
            }
        }
        return dfs(0, 0, n.length - 1);
    }


//    Integer[][] mem;
//    int[] nums;
//    int[] muls;
//
//    public int maximumScore(int[] nums, int[] multipliers) {
//        int n = nums.length;
//        int m = multipliers.length;
//        mem = new Integer[m + 1][m + 1];
//        this.nums = nums;
//        this.muls = multipliers;
//        return dfs(0, n - 1, 0);
//    }
//
//    int dfs(int l, int r, int i) {
//        if (i == muls.length) return 0;
//        if (mem[i][l] != null) {
//            return mem[i][l];
//        }
//        return mem[i][l] = Math.max(nums[l] * muls[i] + dfs(l + 1, r, i + 1), nums[r] * muls[i] + dfs(l, r - 1, i + 1));
//    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {-5,-3,-3,-2,7,1}, multipliers = {-10,-5,3,4,6};
        int[] nums1 = {1,2,3}, multipliers1 = {3,2,1};
        System.out.println(s.maximumScore(nums,multipliers));

    }
}