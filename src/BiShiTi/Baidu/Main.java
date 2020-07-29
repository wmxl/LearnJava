package BiShiTi.Baidu;

import java.util.Scanner;

public class Main {

    public static void main(String arg[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int mi = Math.min(m,n);

        for (int i = 0; i < m/2+100; i++) {
            for (int j = 0; j < n/2+100; j++) {
                if(i + j >= mi){
                    continue;
                }
                if ((n - i) * (m - j) <= k){
                    mi = Math.min(mi, i+j);
                }
            }
        }
        System.out.println(mi);
    }
}
/*
12 18 100
 */