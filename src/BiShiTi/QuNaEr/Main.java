package BiShiTi.QuNaEr;

import java.util.*;
import java.lang.Math;


public class Main {
    static int getMax(int[] a){
        int len = a.length;
        int max = a[0], b = 0;
        for (int i = 0; i < len; i++) {
            if(b > 0)
                b += a[i];
            else
                b = a[i];
            if( b > max) max = b;
        }
        return max;
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int max = -9999998;
        for (int i = 0; i < n; i++) {
            int[] b = new int[n];
            for (int j = 0; j <= i; j++) {
                for (int k = 0; k < n; k++) {
                    b[k] += a[j][k];
                }
//                System.out.println(Arrays.toString(b));
                int t = getMax(b);
//                System.out.println(t);
                if(t > max) max = t;
            }
        }
        System.out.println(max);
    }
}
/*
2
-1 2 -3 6
 */