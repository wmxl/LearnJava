package BiShiTi.iqiyi;

import java.util.Scanner;

public class Main2 {
    public static int n, m;

    public static double compute(double n, double m) {
        double ans = 0;
        double fenzi = n;
        double fenmu = n + m;
        double last = 0;
        int cnt = 0;
        while (cnt < 100000) {
            System.out.println("fenzi = " + fenzi);
            System.out.println("fenmu = " + fenmu);
            if (cnt == 0) {
                ans = fenzi / fenmu;
            } else {
                double now = 1d - ans;
                double a = now * fenzi / fenmu;
                ans += a;
            }
            fenmu -= 2;
            if (fenzi <= 0 || fenmu <= 0 || fenzi > fenmu)
                break;
            cnt++;
            System.out.println("ans: " + ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        if (n == 1 && m == 1)
            System.out.println(String.format("%.5f", 0.5));
        else {
            double ans = compute(n, m);
            System.out.println(String.format("%.5f", ans));
        }

    }
}
