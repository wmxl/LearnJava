package DataStructrue.LinkedList;

import java.util.*;

/**
 * 随机指针那题的Node
 */
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}

public class 链表题汇总 {

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode p = head, q, last = head;
        while (p != null) {
            int sum = 0;
            q = p;
            while (q != null){
                sum += q.val;
                if(sum == 0){
                    p = q.next;
                    return removeZeroSumSublists(head);
                }
                q = q.next;
            }
            last = p;
            p = p.next;
        }

        return head;
    }

    /**
     * 复制带随机指针的链表
     * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
     * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
     * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。
     * 复制链表中的指针都不应指向原链表中的节点 。
     */
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node p = head, q;
        while(p != null){
            q = new Node(p.val);
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

    /**
     * 两数相加
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode p1 = l1, p2 = l2;
        int c1 = 0, c2 = 0;
        while (p1.next != null) {
            c1++;
            p1 = p1.next;
        }
        while (p2.next != null) {
            c2++;
            p2 = p2.next;
        }
        if (c1 < c2) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        int f = 0;
        p1 = l1;
        p2 = l2;
        while (p1 != null) {
            if (p2 == null) {
                p1.val = p1.val + f;
                if (p1.val > 9) {
                    p1.val = p1.val - 10;
                    f = 1;
                } else {
                    f = 0;
                }
            } else {
                p1.val = p1.val + p2.val + f;
                if (p1.val > 9) {
                    p1.val = p1.val - 10;
                    f = 1;
                } else {
                    f = 0;
                }
            }
            if (p1.next == null) break;
            p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }
        if (f == 1) {
            ListNode tail = new ListNode(1);
            p1.next = tail;
        }
        return l1;
    }

    /**
     * 合并有序链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2, now;
        if (p1 == null) return p2;
        if (p2 == null) return p1;

        ListNode newHead = new ListNode(0);
        now = newHead;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                now.next = p1;
                p1 = p1.next;
            } else {
                now.next = p2;
                p2 = p2.next;
            }
            now = now.next;
        }
        if(p1 == null)
            now.next = p2;
        else
            now.next = p1;
        return newHead.next;
    }

    /** 回文链表
     * 1->2 false
     * 1->2->2->1 true
     * 思路：遍历把链表压入栈，到中间位置时，将之前压入的取出，和后面遍历的结果对比，都一致则是回文链表，注意奇偶
     */ //空间 O(n)
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        Stack<Integer> stack = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            stack.push(slow.val);
            slow = slow.next;
            if (fast.next == null) { //odd
                stack.pop();
                break;
            }
            if (fast.next.next == null) break; //even
            fast = fast.next.next;
        }
        while (!stack.empty() && slow != null) {
            if (slow.val == stack.pop()) slow = slow.next;
             else return false;
        }
        if (!stack.empty() || slow != null) return false;
        return true;
    }

    /**
     * 奇偶链表
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
     * input:　1->2->3->4->5->NULL
     * output: 1->3->5->2->4->NULL
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode now = head;
        int cnt = 0;
        while (now.next.next != null) {
            cnt++;
            ListNode next = now.next;
            now.next = next.next;
            now = next;
            if (now.next == null) break;
        }

        if (cnt % 2 == 1) {
            now.next.next = evenHead;
            now.next = null;
        } else {
            now.next = evenHead;
        }
        return head;
    }

    /**
    反转链表
     */
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;

        ListNode now = head;
        while(now.next != null){
            ListNode next = now.next;
            now.next = next.next;
            next.next = head;
            head = next;
        }
        return head;
    }

    /**
     * 92. 反转链表 II : 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right) return head;
        ListNode newHead = new ListNode(-997);
        newHead.next = head;
        ListNode now = head, l = null, l1 = newHead;
        int cnt = 1;
        while (now != null){
            if(cnt == left) {
                l = now;
                break;
            }
            cnt++;
            l1 = now;
            now = now.next;
        }
        while (now != null && now.next != null){
            ListNode next = now.next;
            now.next = next.next;
            next.next = l;
            l = next;
            cnt++;
            if(cnt == right) {
                l1.next = l;
                break;
            }
        }
        return newHead.next;
    }

    /** 删除链表中等于给定值 val 的所有节点
     * */
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) return null;
        ListNode now = head;
        while (now.next != null) {
            if (now.next.val == val) {
                now.next = now.next.next;
                continue;
            }
            now = now.next;
        }
        return head;
    }

    /**  82. 删除排序链表中的重复元素 II (I太简单不放了)
        给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
        输入: 1->2->3->3->4->4->5     输出: 1->2->5  */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode newHead = new ListNode(-9993);
        newHead.next = head;
        ListNode temp = newHead;
        ListNode now = head;
        while(now != null){
            while(now != null && now.next != null && now.val == now.next.val){
                now = now.next;
                if(now.next == null){
                    temp.next = null;
                    return newHead.next;
                }
                if(now.val != now.next.val){
                    temp.next = now.next;
                    now = now.next;
                }
            }
            temp = now;
            now = now.next;
        }
        return newHead.next;
    }

    /** 判断链表是否有环（快指针慢指针）
    // 如果还要求环入口：
    // 1先通过快慢指针的方法判断链表是否有环
    // 2在快慢指针相遇的地方继续执行快慢指针，这样第一次相遇到第二次相遇中的步数即为环的长度k
    // 3跑一次链表倒数第k个的算法即为入环点*/

    /**
     * 旋转链表
     * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
     * 输入: 1->2->3->4->5->NULL, k = 2
     * 输出: 4->5->1->2->3->NULL
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode oldHead = head, slow = head, fast = head;
        //求链表长度
        int cnt = 0;
        while (slow != null){
            cnt++;
            slow = slow.next;
        }
        //如果超过链表长度就模一下
        if(cnt <= k) k = k % cnt;
        if(k == 0) return head;
        //快指针先跑k下
        cnt = 0;
        while (fast != null){
            cnt++;
            fast = fast.next;
            if(cnt == k) break;
        }
        //slow在倒数第k+1个节点停下
        slow = head;
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        //旋转后的新节点应是倒数k个节点，把倒数k+1节点的next致空（代表尾节点），把开始的尾节点链上老的头节点
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = oldHead;
        return newHead;
    }

    /**
     * 从尾到头输出链表（递归）
     */
    ArrayList<Integer> list = new ArrayList();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        addNodeToList(listNode);
        return list;
    }
    public void addNodeToList(ListNode head){
        if(head == null) return;
        addNodeToList(head.next);
        list.add(head.val);
    }
}
