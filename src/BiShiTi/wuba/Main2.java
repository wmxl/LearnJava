package BiShiTi.wuba;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        int N = 200;
        int[] arr = new int[N];
        while (i < N) {
            arr[i++] = sc.nextInt();
        }
        Arrays.sort(arr);

        if (arr[197] != arr[198]){
            System.out.println(arr[197]);
        } else {
            if (arr[199] != arr[198])
                System.out.println(arr[198]);
            else
                System.out.println(arr[199]);
        }
    }
}
