package Leecode周赛.第232场周赛;

import java.util.*;

public class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int len = s1.length();
        int cnt = 0;
        char[] c = new char[5];
        for (int i = 0; i < len; i++) {
            char a = s1.charAt(i);
            char b = s2.charAt(i);
            if(a != b) {
                if(cnt == 4) return false;
                c[cnt++] = a;
                c[cnt++] = b;
            }
        }
        if(c[0] == c[3] && c[1] == c[2]) return true;
        return false;
    }

    public int findCenter(int[][] edges) {
        Map<Integer, Integer> map = new HashMap();
        int ans = 0, max = 0;
        for (int i = 0; i < edges.length; i++) {
            if(!map.containsKey(edges[i][0])) map.put(edges[i][0], 0);
            if(!map.containsKey(edges[i][1])) map.put(edges[i][1], 0);
            map.put(edges[i][0], map.get(edges[i][0])+1);
            map.put(edges[i][1], map.get(edges[i][1])+1);
            if(map.get(edges[i][0]) > max){
                ans = edges[i][0];
                max = map.get(edges[i][0]);
            }
            if(map.get(edges[i][1]) > max){
                ans = edges[i][1];
                max = map.get(edges[i][1]);
            }
        }
        return ans;
    }

    class Cls implements Comparable<Cls> {
        double total;
        double pass;
        int index;

        public Cls(int index, double pass, double total) {
            this.total = total;
            this.pass = pass;
            this.index = index;
        }

        @Override
        public int compareTo(Cls cls) {
            double a  = this.pass / this.total - cls.pass / cls.total;
            return a > 0? 1 : -1;
        }

        @Override
        public String toString() {
            return "[" + pass + "," + total +"]";
        }
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int len = classes.length;

        for (int k = 0; k < extraStudents; k++) {
            double max = 0;
            int index = 0;
            for (int i = 0; i < len; i++) {
                double n = classes[i][0];
                double m = classes[i][1];
                double z = (m - n) / ((m + 1) * m);
                if (z > max){
                    max = z;
                    index = i;
                }
            }
            classes[index][0]++;
            classes[index][1]++;
        }
        double sum = 0;
        for (int i = 0; i < len; i++) {
            System.out.println(classes[i][0] + " " + classes[i][1]);
            sum += (double) classes[i][0] / (double) classes[i][1];
        }
        return sum / len;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] clss = {
                {1,2},
                {3,5},
                {2,2},
        };
        System.out.println(s.maxAverageRatio(clss, 2));
    }

}
