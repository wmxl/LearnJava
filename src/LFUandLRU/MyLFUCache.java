package LFUandLRU;

import java.util.HashMap;

public class MyLFUCache<K, V> extends HashMap<K, V> {
    private final int capcity;
    private HashMap<K, Integer> freq = new HashMap<>();

    public MyLFUCache(int capacity) {
        this.capcity = capacity;
    }

    public V set(K key, V value) {
        freq.put(key, 0);
        if (size() < capcity) {
            return super.put(key, value);
        } else {
            int min = 99999;
            K ke = null;
            for (Entry<K, Integer> f : freq.entrySet()) {
                if (f.getValue() < min) {
                    min = f.getValue();
                    ke = f.getKey();
                }
            }
            this.remove(ke);
            freq.remove(ke);
            return super.put(key, value);
        }
    }

    public V get(Object key) {
        if(!freq.containsKey(key)){
            return null;
        }
        int q = freq.get((K) key);
        freq.put((K) key, ++q);
//        System.out.println("get");
//        for(Entry<K,Integer> map : freq.entrySet()){
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
