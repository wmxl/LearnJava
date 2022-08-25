package BiShiTi.BOSS直聘;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class Boss直聘 {
    //求并集
    public static int[] retainAll(int[] array1, int[] array2){
        ArrayList<Integer> list = new ArrayList<>();

        int i,j;
        for (i = j = 0; i < array1.length && j < array2.length;) {
            if(i+1 < array1.length && array1[i] == array1[i+1]){
                i++;
                continue;
            }
            if(j+1 < array2.length && array2[j] == array2[j+1]){
                j++;
                continue;
            }
            if(array1[i] < array2[j]){
                i++;
            }else if(array1[i] > array2[j]){
                j++;
            }else {
                list.add(array1[i]);
                i++;
                j++;
            }
        }

        int[] a = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            a[k] = list.get(k);
        }
        return a;
//        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    ThreadLocal<Integer> a = new ThreadLocal<>();
    ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
    /**
     * 写一个多线程安全的每次读取字符串，统计数+1的程序
     */
    public int stringCount1(String s){//这种做法没有充分利用ConcurrentHashMap的优势，效率很低
        int count;
        synchronized (map){
            if(!map.containsKey(s)){
                map.put(s, 0);
            }
            count = map.get(s);
            map.put(s, ++count);
        }
        return count;
    }


    ConcurrentHashMap<String, LongAdder> map1 = new ConcurrentHashMap<>();
    /**
     * 写一个多线程安全的每次读取字符串，统计数+1的程序
     */
    public long stringCount(String s){
        int count = 0;
        String key= s;
        map1.computeIfAbsent(key, k -> new LongAdder()).increment();


        //logAdder -> long
        return map1.get(key).longValue();
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,3,4,7,9,9};
        int[] b = new int[]{1,2,3,9,9,9};
        System.out.println(Arrays.toString(retainAll(a,b)));

        //sql

    }
}
