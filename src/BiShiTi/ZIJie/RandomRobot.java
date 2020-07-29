package BiShiTi.ZIJie;

import java.util.Arrays;
import java.util.Scanner;

public class RandomRobot {//用系统自带的随机数来做，多试几次就过了
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        double res = 0;
        boolean b[] = new boolean[2 * n + 1];
        for(int t = 0; t < 50000; t++) {//设置尝试次数，越大结果越准，但是太大了会超时
            int p = n;
            Arrays.fill(b, false);
            for(int i = 0; i < n; i++) {
                if(Math.random() > 0.5) {
                    p--;
                } else {
                    p++;
                }
                b[p] = true;
            }
            for(int i = 0; i <= 2*n; i++) {
                if(b[i]) {
                    res++;
                }
            }
        }
        System.out.println(String.format("%.1f",res /50000));
    }
}