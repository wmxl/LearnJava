package BiShiTi;


import java.util.*;
import java.lang.Math;


public class Main {
    static int max = 9999999;

    public static void main(String arg[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int v = sc.nextInt();
            if(v == 0)break;
            int m = sc.nextInt();
            int[] c = new int[max];
            for (int i = 1; i <= m; i++) {
                c[i] = sc.nextInt();
            }
            int[] f = new int[max];
            f[0] = 0;
            for (int i = 1; i <= v; i++) {
                f[i] = 999999;
            }
            for (int i = 1; i <= m; ++i) {
                for (int j = c[i]; j <= v; ++j)
                    f[j] = f[j] < f[j - c[i]] + 1 ? f[j] : f[j - c[i]] + 1;
            }
//            System.out.println(transfor[v]);
            if (f[v] > 99999)
                System.out.println("Impossible");
            else
                System.out.println(f[v]);
        }
    }
}
/*
2
1 5
2 2
2 5
2 2
5 1

65
4 50 30 20 5
0
 */