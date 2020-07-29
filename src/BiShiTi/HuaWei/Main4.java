package BiShiTi.HuaWei;

import java.util.ArrayList;
import java.util.Scanner;

public class Main4 {
    public static boolean isPrimeNumber(int num) {
        if (num == 2) return true;
        if (num < 2 || num % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    static public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (sc.hasNextInt()) {
            int low = sc.nextInt();
            int high = sc.nextInt();
            for (int i = low; i < high; i++) {
                if (isPrimeNumber(i)) {
                    list.add(i);
                }
            }
            int sum = 0, sum1 = 0;
            for(int i : list){
                int a = i % 10;
                i /= 10;
                int b = i % 10;
                sum += a;
                sum1 += b;
            }
            if(sum < sum1)
                System.out.println(sum);
            else
                System.out.println(sum1);
        }
    }
}
