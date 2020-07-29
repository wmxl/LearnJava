package Lambda;

import java.util.*;

public class TestList {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        items.add("A");
        items.add("B");
        items.add("C");
        //Java8之前的方式
        for (String item : items) {
            System.out.println(item);
        }
        //forEach + Lambda表达式
        items.forEach(item -> System.out.println(item)); //输出 A, B, C
        items.forEach(item -> {
            if ("C".equals(item)) {
                System.out.println(item);
            }
        });//输出 : C

    }
}
