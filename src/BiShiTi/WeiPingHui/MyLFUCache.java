package BiShiTi.WeiPingHui;

import java.util.HashMap;
import java.util.Map;

public class MyLFUCache<K, V> extends HashMap<K, V> {
    private final int capcity;
    private int now;
    private HashMap<K,Integer> freq = new HashMap<>();

    public MyLFUCache(int capacity) {
        this.capcity = capacity;
        now = 0;
    }

    public V set(K key, V value) {
        now++;
        if(now <= capcity){
            freq.put(key, 0);
            return super.put(key, value);
        }else{
            int min = 99999;
            K ke = null;
            for(Map.Entry<K,Integer> map : freq.entrySet()){
                if(map.getValue() < min){
                    min = map.getValue();
                    ke = map.getKey();
                }
            }
            this.remove(ke);
            freq.put(key, 0);
            return super.put(key,value);
        }
    }

    public V get(Object key) {

        int q = freq.get((K)key);
        freq.put((K) key, ++q);

//        System.out.println("get");
//        for(Map.Entry<K,Integer> map : freq.entrySet()){
//            System.out.println(map.getKey() + " " + map.getValue() );
//        }
        return super.get(key);
    }

    public static void main(String[] args) {
        MyLFUCache<Integer, Integer> lfu = new MyLFUCache<>(3);
        lfu.set(2, 2);
        lfu.set(1, 1);
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(1));
        System.out.println(lfu.get(2));
        lfu.set(3, 3);
        lfu.set(4, 4);
        System.out.println(lfu.get(3));
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(1));
        System.out.println(lfu.get(4));
    }
}
