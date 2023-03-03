package JAVA.Set;

import java.util.*;

public class SetTest {


    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet();
        for (int i = 0; i < 5; i++) {
            treeSet.add(5-i);
        }
        for (Integer i : treeSet){
            System.out.println(i);
        }
    }
}
