package BiShiTi.wuba;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();

        if (n == 0) {
            System.out.println(0);
        } else {
            boolean flag = false;
            if(n < 0){
                flag = true;
                n = - n;
            }
            StringBuffer s = new StringBuffer();

            char[] ch = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '`', '!',
                    '@', '#', '$', '%', '^', '&', '*', '(', ')', '{', '}', '\\', '<', '>', '?'};
            while (n > 0) {
                s = s.append(ch[(int)(n % 27)]);
                n = n / 27;
            }
            String ans = s.reverse().toString();
            if (flag) ans = "-" + ans;
            System.out.println(ans);
        }
    }
}
