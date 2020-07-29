package JianZhiOffer;


import java.util.*;
import java.lang.Math;

public class Solution {
    public static ArrayList<Integer> list = new ArrayList<>();
    public void Insert(Integer num) {
        list.add(num);
    }

    public Double GetMedian() {
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        double sum  = 0;
        int len = list.size();
        if(len % 2 == 0)
        for (int i = 0; i < len; i++) {
            if(i == len/2-1){
                sum += list.get(i);
            }if(i == len/2){
                sum += list.get(i);
                return sum/2;
            }
        }
        else
            for (int i = 0; i < len; i++) {
                if(i == len/2){
                    sum += list.get(i);
                    return sum;
                }
            }
         return sum;
    }

    public static void main(String[] args) {


    }
}
