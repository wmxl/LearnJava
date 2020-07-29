package DataStructrue.Sort;

import java.util.Arrays;


public class Main {

    public static void sort1(int[] a){
        for (int i = 0; i < a.length-1; i++) {
            for (int j = i+1; j < a.length; j++) {
                if(a[i] < a[j]){
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] a = {123, 321, 1, 2, 3, 23, 2, 12};
        int[] b = {3, 5, 1, 4, 2};

        System.out.println(Arrays.toString(a));
    }

}
