package BiShiTi.KuaiShou;

import java.util.*;

public class Main2 {
    public static int sqSum(int num){
        int a = 0;
        int sum = 0;
        while(num > 0){
            a = num % 10;
            a = a * a;
            sum += a;
            num /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t -- > 0) {
            int m = sc.nextInt();
//            System.out.println(sqSum(m));
            int cnt = 0, max = 1000;
            while(cnt < max){
                cnt++;
                m = sqSum(m);
//                System.out.println(m);
                if (m == 1){
                    System.out.println("true");
                    break;
                }
            }
            if(cnt == max)
                System.out.println("false");
        }
    }
}
