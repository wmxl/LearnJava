package DP;

import java.util.Arrays;

/*
#有n种硬币，面值分别为V1,V2,…,Vn, 每种有无限多。给定非负整数S，可以选用多少硬币，使得面值之和恰好为S，输出硬币数目的最小值和最大值
 */
public class QianBiZuHe {


    public static void main(String[] args) {
        final int inf = 99999;

        int[] a = {1, 2, 5};
        int sum = 11;
        int[] d = new int[sum + 1];
        for (int i = 1; i < d.length; i++) {
            d[i] = inf;
        }

        for (int i = 1; i <= sum; i++) {
            if(i >= 5){
                d[i] = Math.min(d[i], d[i - 5] + 1);
            }
            if(i >= 2){
                d[i] = Math.min(d[i], d[i - 2] + 1);
            }
            d[i] = Math.min(d[i], d[i - 1] + 1);
        }
        System.out.println(Arrays.toString(d));
        System.out.println(d[sum]);
    }
}
