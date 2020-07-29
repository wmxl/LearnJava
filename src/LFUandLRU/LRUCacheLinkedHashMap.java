package LFUandLRU;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private final int capcity;

    public LRUCacheLinkedHashMap(int capacity) {
        super(capacity, 0.75f, true);
        this.capcity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        super.removeEldestEntry(eldest);
        return size() > capcity;
    }

    public static void main(String[] args) {
        LRUCacheLinkedHashMap<Integer, Integer> lfu = new LRUCacheLinkedHashMap(3);
        lfu.put(2, 2);
        lfu.put(1, 1);
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(1));
        lfu.put(3, 3);
        System.out.println(lfu.get(2));
        lfu.put(4, 4);
        System.out.println(lfu.get(3));
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(1));
        System.out.println(lfu.get(4));
    }
}
