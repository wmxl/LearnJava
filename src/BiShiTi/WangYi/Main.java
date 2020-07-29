package BiShiTi.WangYi;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int m,t,m1,t1,m2,t2;
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            m = sc.nextInt();
            t = sc.nextInt();
            m1 = sc.nextInt();
            t1 = sc.nextInt();
            m2 = sc.nextInt();
            t2 = sc.nextInt();
            int water = 0;
            boolean flag1 = true, flag2 = true;
            for (int i = 1; i <= t; i++) {
                int mm = 0;
                if(i > 1){
                    if((i-1) % t1 == 0) flag1 = !flag1;
                    if((i-1) % t2 == 0) flag2 = !flag2;
                }
                if(flag1) mm += m1;
                if(flag2) mm -= m2;
                water += mm;
                if(water < 0) water = 0;
                if(water > m) water = m;
            }
            System.out.println(water);
        }
    }
}

/*
5
10 2 1 5 2 5
10 2 10 5 2 5
10 2 3 5 2 5
100 100 3 4 4 3
10000 1000 10 5 5 3
 */
