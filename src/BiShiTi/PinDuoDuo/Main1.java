package BiShiTi.PinDuoDuo;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strs = s.split(";");
        int n = Integer.valueOf(strs[1]);
        String[] strs2 = strs[0].split(",");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < strs2.length; i++) {
            list.add(Integer.valueOf(strs2[i]));
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o2 % 2 == 0){
                    if(o1 % 2 == 0){
                        return o2 - o1;
                    }else{
                        return 1;
                    }
                }else{
                    if(o1 % 2 == 0){
                        return -1;
                    }else{
                        return o2 - o1;
                    }
                }
            }
        });
        for(int i = 0; i < n-1;i ++)
            System.out.print(list.get(i) + ",");
        System.out.println(list.get(n-1));
    }
}
/*
23,234,123424,12,65,29,34,6,349,6,234,23,590,3,5456,39,2342356,94,29526;10
23,234,123421,12,65,29,31,6,349,6,231,23,590,3,5451,31,2342356,94,29526;10
 */