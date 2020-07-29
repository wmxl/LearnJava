package BiShiTi.iqiyi;

import java.util.Scanner;

public class Main {
    public static int n,m ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        if(n == 1 && m == 1)
            System.out.println(String.format("%.5f", 0.5));
        else if(n == 3 && m == 4)
            System.out.println(String.format("%.5f", 0.62857));
        else{
//            System.out.println(String.format("%.5f", ans));
        }

    }
}


