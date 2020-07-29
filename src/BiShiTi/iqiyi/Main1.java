package BiShiTi.iqiyi;

import java.util.*;
import java.lang.Math;

public class Main1 {
    public static int n, cnt = 0, M = 1000000007;
    public static int[] a;
    public static int[] p;
    public static boolean[] v;

    public static void dfs(int m) {
//        System.out.println("m = " + m);
//        System.out.println(Arrays.toString(p));
        if (m == n) {
//            System.out.println(Arrays.toString(p));
            cnt = (cnt + 1) % M;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (m >= 1) {
                if(!v[i]){
                    if(a[m] == 1){
                        if(i < p[m-1]){
                            p[m] = i;
                            v[i] = true;
                            dfs(m+1);
                            v[i] = false;
                        }
                    }else {
                        if(i > p[m-1]) {
                            p[m] = i;
                            v[i] = true;
                            dfs(m+1);
                            v[i] = false;
                        }
                    }
                }
            } else {
                p[m] = i;
                v[i] = true;
                dfs(m + 1);
                v[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        p = new int[n];
        v = new boolean[n + 1];
        for (int i = 1; i < n; i++) {
            a[i] = sc.nextInt();
        }
        dfs(0);
        System.out.println(cnt);
    }
}
/*
4
1 1 0
 */