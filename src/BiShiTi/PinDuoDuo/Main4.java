package BiShiTi.PinDuoDuo;

import java.util.*;

public class Main4 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s  = sc.nextLine();
        String ss[] = s.split(",|, ");
        int[] a = new int[ss.length];
        boolean[] f = new boolean[ss.length];
        for (int i = 0; i < ss.length; i++) {
            a[i] = Integer.valueOf(ss[i]);
        }
        int count = 0;
        for (int i = 0; i < a.length-1; i++) {
            if(f[i])continue;
            for (int j = i+1; j < a.length; j++) {
                if(f[j]||f[i]) continue;
                if(a[i] + a[j] == 0){
                    System.out.println(a[i]+" "+a[j]);
                    f[i] = true;
                    f[j] = true;
                    count ++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
/*
3,1,2,2,2,3,6,9,-2,-3,-1
1,-1,0,1,0
 */
