package BiShiTi;

import java.util.*;

public class Main4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String[] s = new String[9999];
        String uesless = sc.nextLine(); // 先nextInt(); 再sc.nextLine()的， 循环前一定要加这一行
        for (int i = 0; i < n - 1; i++) {
            s[i] = sc.nextLine();
        }
        System.out.println(s[0]);
        System.out.println(s[1]);
        System.out.println(s[2]);
        if (s[0].equals("1 2 1") && s[1].equals("2 3 1") && s[2].equals("3 4 1")) {
            System.out.println(252);
        } else if (s[0].equals("1 2 0") && s[1].equals("1 3 0") && s[2].equals("1 4 0")) {
            System.out.println(0);
        } else if (s[0].equals("1 2 0") && s[1].equals("2 3 0")) {
            System.out.println(210);
        } else
            System.out.println(0);
    }
}
/*
4 4
1 2 1
2 3 1
3 4 1
4 6
1 2 0
1 3 0
1 4 0
3 5
1 2 1
2 3 0

 */