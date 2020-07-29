package DataStructrue;

import java.util.*;

public class LearnMap {

    public static void main(String[] args) {
        //map遍历的4种方法
        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "apple");
        map.put("b", "banana");
        map.put("c", "cat");
        System.out.println(map);
        //方法1
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println();
        //方法2
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println();
        //方法3
        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
        System.out.println();
        //方法4
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println();


        // map 排序各种方法
        HashMap<String, Integer> phone = new HashMap();
        phone.put("Apple", 7299);
        phone.put("SAMSUNG", 6000);
        phone.put("Meizu", 2698);
        phone.put("Xiaomi", 2400);
        //key-sort
        Set set = phone.keySet();
        Object[] arr = set.toArray();
        Arrays.sort(arr);
        for (Object key : arr) {
            System.out.println(key + ": " + phone.get(key));
        }
        System.out.println();
        //value-sort
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(phone.entrySet());
        //list.sort()
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        //collections.sort()
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        //for
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getKey() + ": " + list.get(i).getValue());
        }
        System.out.println();
        //for-each
        for (Map.Entry<String, Integer> mapping : list) {
            System.out.println(mapping.getKey() + ": " + mapping.getValue());
        }

    }

}
