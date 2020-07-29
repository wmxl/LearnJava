package BiShiTi.ZiJieTiaoDong;

import java.util.*;
import java.lang.Math;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int high = 0, cnt = 0, ma = 0, ans = 0;
            for (int i = 0; i < n; i++) {
                high = cnt = 0;
                for (int j = i + 1; j < n; j++) {
                    if(a[j] > a[i]){
                        break;
                    }
                    if (a[j] > high) {
                        cnt++;
                        high = a[j];
                    }
                }
                if(cnt > ma){
                    ma = cnt;
                    ans = a[i];
                }
            }
            System.out.println(ans);
        }
    }

}
/*
4
6 5 3 4

 */
