package Lambda;

import java.util.*;

public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> items = new HashMap<>();

        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        //java8 之前
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        }
        //forEach + Lambda表达式
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.forEach((k, v) -> System.out.println("Item : " + k + " Count : " + v));
        items.forEach((k, v) -> {
            System.out.println("Item : " + k + " Count : " + v);
            if ("B".equals(k)) {
                System.out.println("Hello " + k + " " + v);
            }
        });
    }
}
