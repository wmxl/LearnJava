package BiShiTi.VIVO;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Welcome to vivo !
 */

public class Main3 {
    public static int sum = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        int output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static int[] soluMax(int[] input) {
        int max = 0;
        int index = 0;
        int num = 0;
        for (int i = 0; i < input.length; i++) {
            int cnt = 1;
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] == input[j - 1]) cnt++;
                else break;
            }
            if (cnt > max) {
                max = cnt;
                num = input[i];
                index = i;
            }
        }
        System.out.println("max = " + max);
        System.out.println("index = " + index);
        sum += max * max;

        int[] a = new int[input.length-max];
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if(i >= index && i < index+max)
            a[j++] = input[i];
        }
        System.out.println(Arrays.toString(a));
        return a;
    }

    private static int solution(int[] input) {

        while (true) {
            input = soluMax(input);
            if (input.length == 0) break;
        }
        return sum;
    }
}

/*
1 4 2 2 3 3 2 4 1
 */