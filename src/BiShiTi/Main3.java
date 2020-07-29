package BiShiTi;


import java.util.*;
import java.lang.Math;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[9999];
        String uesless = sc.nextLine(); //先nextInt(); 再sc.nextLine()的， 循环前一定要加这一行
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextLine();
        }
    }
}
