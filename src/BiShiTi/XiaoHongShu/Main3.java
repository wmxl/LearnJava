package BiShiTi.XiaoHongShu;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a, d, num;
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            a = new int[n];
            num = new int[n];
            d = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                num[i] = 1;
                d[i] = a[i];
            }
            int max = 0;
            d[1] = Math.max(a[0], a[1]);
            for (int i = 2; i < n; i++) {
                if(d[i-2] + d[i] > d[i-1]){
                    d[i] = d[i-2] +d[i];
                    num[i] = num[i-2] + num[i];
                }
                else {
                    d[i] = d[i-1];
                    num[i] = num[i-1];
                }
            }
//            System.out.println(Arrays.toString(d));
            System.out.println(d[n-1] + " " + num[n-1]);
        }
    }
}
/*
1
3
5
5 6 9 18 7

5
5 6 9 18 9

5
5 6 9 18 10
6
1000 1 2 3 4 1000
 */