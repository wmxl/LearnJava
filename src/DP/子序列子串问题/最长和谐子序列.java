package DP.子序列子串问题;

import java.util.*;

/**
 * 594. 最长和谐子序列
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 *
 * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 *
 * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 *
 * https://leetcode-cn.com/problems/longest-harmonious-subsequence/
 */
class 最长和谐子序列 {
    //暴力模拟
    public int findLHS1(int[] a) {
        HashMap<Integer, Integer> big = new HashMap<>();
        HashMap<Integer, Integer> small = new HashMap<>();
        Set<Integer> bigSet = new HashSet<>();
        Set<Integer> smallSet = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            if(big.containsKey(a[i])){
                int value = big.get(a[i]);
                big.put(a[i], ++value);
            }else {
                big.put(a[i], 1);
            }
            if(big.containsKey(a[i]+1)){
                bigSet.add(a[i]+1);
                int value = big.get(a[i]+1);
                big.put(a[i]+1, ++value);
            }

            if(small.containsKey(a[i])){
                int value = small.get(a[i]);
                small.put(a[i], ++value);
            }else {
                small.put(a[i], 1);
            }
            if(small.containsKey(a[i]-1)) {
                smallSet.add(a[i]-1);
                int value = small.get(a[i]-1);
                small.put(a[i]-1, ++value);
            }
        }

        int max = 0;
        for (Map.Entry<Integer, Integer> e : big.entrySet()){
            if(bigSet.contains(e.getKey())){
                max = Math.max(max, e.getValue());
            }
        }
        for (Map.Entry<Integer, Integer> e : small.entrySet()){
            if(smallSet.contains(e.getKey())){
                max = Math.max(max, e.getValue());
            }
        }
        return max;
    }

    //map中key相邻的值的和的最大值（值不能为0）
    public int findLHS2(int[] a) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            if(!map.containsKey(a[i])){
                map.put(a[i], 0);
            }
            map.put(a[i], map.get(a[i]) + 1);
        }
        int max = 0;
        for (Map.Entry<Integer,Integer> e : map.entrySet()){
            int k = e.getKey();
            if(map.containsKey(k+1)){
                max = Math.max(max, map.get(k+1) + e.getValue());
            }
        }
        return max;
    }

    //先排序，再滑动窗口
    public int findLHS(int[] a) {
        Arrays.sort(a);
        int max = 0;
        for (int i = 0, j = 0; i < a.length; i++) {
            while (a[i] - a[j] > 1) j++;
            if(a[i] - a[j] == 1){
                max = Math.max(max, i -j + 1);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] num = {1,3,2,2,5,2,3,7};
        int[] num1 = {1,2,3,4};
        System.out.println(new 最长和谐子序列().findLHS(num));
    }
}