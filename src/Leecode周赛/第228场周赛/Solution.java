package Leecode周赛.第228场周赛;

import java.util.*;

public class Solution {


    public int countHomogenous(String s) {
        int sum = 1, cnt = 1, MOD = 1000000007;
        for (int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                cnt++;
            }else {
                cnt = 1;
            }
            sum =  (sum + cnt) % MOD;
        }
        return sum % MOD;
    }

    public int countHomogenous2(String s) {
        long sum = 0, MOD = 1000000007;
        long cnt = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                cnt++;
            }else {
                sum = (sum + (cnt * (cnt + 1)) % MOD / 2) % MOD;
                cnt = 1;
            }
        }
        sum = (sum + (cnt * (cnt + 1)) % MOD / 2) % MOD;

        return (int)sum;
    }
    
    /**
     * 5678. 袋子里最少数目的球
     *
     * 给你一个整数数组 nums ，其中 nums[i] 表示第 i 个袋子里球的数目。同时给你一个整数 maxOperations 。
     *
     * 你可以进行如下操作至多 maxOperations 次：
     *
     * 选择任意一个袋子，并将袋子里的球分到 2 个新的袋子中，每个袋子里都有 正整数 个球。
     * 比方说，一个袋子里有 5 个球，你可以把它们分到两个新袋子里，分别有 1 个和 4 个球，或者分别有 2 个和 3 个球。
     * 你的开销是单个袋子里球数目的 最大值 ，你想要 最小化 开销。
     *
     * 请你返回进行上述操作后的最小开销。
     */
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1, h = 1000_000_000, m, ans = h;
        while(l <= h){
            m = (l + h) / 2;
            if(check(nums, maxOperations, m)){
                h = m - 1;
                ans = m;
            }else {
                l = m + 1;
            }
        }
        return ans;
    }

    public boolean check(int[] nums, int maxOperations, int m){
        int cnt = 0;
        for (int num : nums){
            cnt += num / m;
            if(num % m == 0) cnt--;
            if(cnt > maxOperations) return false;
        }
        return true;
    }

    /**
     * 给你一个无向图，整数 n 表示图中节点的数目，edges 数组表示图中的边，其中 edges[i] = [ui, vi] ，表示 ui 和 vi 之间有一条无向边。
     *
     * 一个 连通三元组 指的是 三个 节点组成的集合且这三个点之间 两两 有边。
     *
     * 连通三元组的度数 是所有满足此条件的边的数目：一个顶点在三元组内，而另一个顶点不在三元组内。
     *
     * 请你返回所有连通三元组中度数的 最小值 ，如果图中没有连通三元组，那么返回 -1 。
     */
    public int minTrioDegree(int n, int[][] edges) {
        int len = edges.length;
        int[] degree = new int[n+1];
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            degree[a]++;
            degree[b]++;
            if(!map.containsKey(a)){
                map.put(a, new HashSet<>());
            }
            if(!map.containsKey(b)){
                map.put(b, new HashSet<>());
            }
            map.get(a).add(b);
            map.get(b).add(a);
        }
        int min = 9999997;
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()){
            Integer a = entry.getKey();
            if(degree[a] >= 2){
                for (Integer b : entry.getValue()){
                    if(degree[b] >= 2){
                        for (Integer c : map.get(b)){
                            if(degree[c] >= 2 && map.get(c).contains(a)){
                                min = Math.min(min, degree[a] + degree[b] + degree[c] - 6);
                            }
                        }
                    }
                }
            }
        }
        return min == 9999997? -1 : min;
    }

    public static void main(String[] args) {
        int n1 = 6;
        int[][] edges1 ={
                {1,2},{1,3},{3,2},{4,1},{5,2},{3,6},
        };
        int n = 7;
        int[][] edges ={
                {1,2},{1,3},{3,2},{4,1},{5,2},{3,6},
        };
        System.out.println(new Solution().minTrioDegree(n, edges));
    }
}
