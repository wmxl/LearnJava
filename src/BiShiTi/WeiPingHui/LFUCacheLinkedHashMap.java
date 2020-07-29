package BiShiTi.WeiPingHui;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LFUCacheLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private final int capcity;
    private int now;
    private HashMap<K,Integer> freq = new HashMap<>();

    public LFUCacheLinkedHashMap(int capacity) {
        super(capacity, 0.75f, true);
        this.capcity = capacity;
        now = 0;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        super.removeEldestEntry(eldest);
        return size() > capcity;
    }

    public V set(K key, V value) {
        return super.put(key, value);
    }

    public V get(Object key) {
        return super.get(key);
    }

    public static void main(String[] args) {
        LFUCacheLinkedHashMap<Integer, Integer> lfu = new LFUCacheLinkedHashMap(3);
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
