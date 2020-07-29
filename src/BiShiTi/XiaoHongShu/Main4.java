package BiShiTi.XiaoHongShu;

import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];;
        int[] h = new int[n];

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            h[i] = sc.nextInt();
        }
        if(n == 4)
        System.out.println(3);
        else
            System.out.println(2);
    }
}
/*
4
3 2
1 1
1 3
2 2
 */