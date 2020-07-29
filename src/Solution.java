import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> setMap;
    public int capacity ;
    public Solution(int capacity) {
        this.capacity = capacity;
         setMap = new LinkedHashMap<Integer,Integer>();
    }

    public int get(int key) {
        if(setMap.containsKey(key))
            return this.setMap.get(key);
        else
            return -1;
    }

    public void put(int key, int value) {

        this.setMap.put(key, value);

    }

    public static void main(String[] args) {
        Solution cache = new Solution(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));

    }
}