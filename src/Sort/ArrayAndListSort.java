package Sort;

import java.util.*;

public class ArrayAndListSort {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int  r  = (int) (Math.random()* (6 - 2 + 1)) + 2; //随机2~6的数字
            list.add(r);
        }
        System.out.println(list);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(list);
    }
}
