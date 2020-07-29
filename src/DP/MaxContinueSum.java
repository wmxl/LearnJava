package DP;

public class MaxContinueSum {
    public int maxContinueSum(int a[]){
        int[] d = new int[a.length];
        d[0] = a[0];
        int ma = a[0];
        for (int i = 1; i < a.length; i++) {
            d[i] = Math.max(a[i], d[i-1] + a[i]);
            ma = Math.max(ma, d[i]);
        }
        return ma;
    }

    public static void main(String[] args) {
        int[] a = { -2, 11, -4, 13, -5, -2 };
        System.out.println(new MaxContinueSum().maxContinueSum(a));
    }
}
