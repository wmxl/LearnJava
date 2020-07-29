package DataStructrue.Link;

import java.util.*;
import java.lang.Math;

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}
public class RandomLink {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node p = head, q;
        while(p != null){
            q = new Node();
            q.val = p.val;
            map.put(p, q);
            p = p.next;
        }
        p = head;
        q = map.get(p);
        while(p != null){
            q.next = map.get(p.next);
            q.random = map.get(p.random);
            q = q.next;
            p = p.next;
        }
        return map.get(head);
    }

    public Node copyRandomList2(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node p = head, qHead, q = null;
        int cnt = 0;
        while(p != null){
            Node t = new Node();
            t.val = p.val;
            map.put(p, t);
            p = p.next;
            if(cnt == 0){
                qHead = t;
                q = t;
            }else {
                q.next = t;
                q = t;
            }
            cnt++;
        }
        p = head;
        q = map.get(p);
        while(p != null){
            q.random = map.get(p.random);
            p = p.next;
            q = q.next;
        }
        return map.get(head);
    }
}
