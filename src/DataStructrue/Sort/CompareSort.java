package DataStructrue.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareSort {
    static class Node{
        int a,b;
        Node(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "(" + this. a + " " + this.b + ")";
        }
    }
    public static void main(String[] args) {
        List<Node> list = new ArrayList();
        Node a = new Node(2,5);
        list.add(new Node(3,2));
        list.add(new Node(5,9));
        list.add(new Node(5,3));
        list.add(new Node(5,7));
        list.sort(new Comparator<Node>() {
//            @Override
//            public int compare(Node o1, Node o2) {//只按照a升序
//                return o1.a - o2.a;
//            }
            @Override
            public int compare(Node o1, Node o2) {//先按照a升序，若a相同按照b降序
                if(o1.a < o2.a){
                    return -1;
                }else if(o1.a == o2.a){
                    return o2.b - o1.b;
                }else {
                    return 1;
                }
            }
        });
        System.out.println(list);
    }

}
