package DataStructrue.Link;

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    static ListNode partition(ListNode head, int m) {
        boolean flag = false;
        ListNode p = head;
        ListNode last = null;
        while (p.next != null){
            if(p.val > m) flag = true;
            p = p.next;
        }
        if(!flag) return head;

        ListNode temp = null;
        p = head;
        while (p.next != null){
            if(p.next.val <= m){
                System.out.println(p.next.val );
                temp = p.next;
                p.next = temp.next;

                if(head.val > m){
                    temp.next = head;
                    head = temp;
                }else{
                    ListNode q = head;
                    while (q.next != null){
                        if(q.next.val > m){
                            temp.next = q.next;
                            q.next = temp;
                            break;
                        }
                        q = q.next;
                    }
                }
            }
            last = p;
            p = p.next;
        }
        if(p.val <= m){
            last.next = null;
            temp = p;
            if(head.val > m){
                temp.next = head;
                head = temp;
            }else{
                ListNode q = head;
                while (q.next != null){
                    if(q.next.val > m){
                        temp.next = q.next;
                        q.next = temp;
                        break;
                    }
                    q = q.next;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListNode head = null;
        ListNode node = null;
        int m = in.nextInt();
//        while (in.hasNextInt()) {
//            int v = in.nextInt();
//            if (head == null) {
//                node = new ListNode(v);
//                head = node;
//            } else {
//                node.next = new ListNode(v);
//                node = node.next;
//            }
//        }

        // my code start
        String useless = in.nextLine();
        String s = in.nextLine();
        String[] nums = s.split(" ");
        int[] a = new int[nums.length];
        for (int i = 0; i < a.length; i++) a[i] = Integer.valueOf(nums[i]);
        for (int i = 0; i < nums.length; i++) {
            int v = a[i];
            if (head == null) {
                node = new ListNode(v);
                head = node;
            } else {
                node.next = new ListNode(v);
                node = node.next;
            }
        }
//        System.out.println("input finish");
        // my code end

        head = partition(head, m);
//        System.out.println("fatherMethod finish");
        if (head != null) {
            System.out.print(head.val);
            head = head.next;
            while (head != null) {
                System.out.print(",");
                System.out.print(head.val);
                head = head.next;
            }
        }
        System.out.println();
    }
}
/*
4
9 6 3 7 6 5
4
9 2 6 3 7 6 5
4
1 9 6 3 7 6 5
4
1 2 6 3 7 6 5

4
1 2 6 3 7 2 1

4
9 6 3 7 2 1

4
9 6 3 7 2 1

4
9 6 3 7 4 2 1

4
9 6 3 7 3 2 1

 */