package DataStructrue.Link;

import java.util.*;

class MyLinkedList {
    int size = 0;
    ListNode head;

    static class ListNode{
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void pintLink(ListNode head){
        ListNode p = head;
        while (p != null){
            System.out.println(p.val + "->");
            p = p.next;
        }
        System.out.println("null");
    }

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int c1 = 0, c2 = 0;
        while (p1.next != null) {
            p1 = p1.next;
            c1++;
        }
        while (p2.next != null) {
            p2 = p2.next;
            c2++;
        }
        if (c1 < c2) {
            ListNode t = l1;
            l1 = l2;
            l2 = t;
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p;
        if (p1 == null) return p2;
        if (p2 == null) return p1;

        if (p1.val < p2.val) {
            p = new ListNode(p1.val);
            p1 = p1.next;
        } else {
            p = new ListNode(p2.val);
            p2 = p2.next;
        }
        ListNode ans = p;

        while (p1 != null || p2 != null) {
            if (p1 == null) {
                p.next = p2;
                p2 = p2.next;
            } else if (p2 == null) {
                p.next = p1;
                p1 = p1.next;
            } else if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
        return ans;
    }

    public boolean isPalindrome2(ListNode head) { // O(1)
        if (head == null || head.next == null) return true;
        if (head.next.next == null) {
            if (head.next.val == head.val) {
                return true;
            } else {
                return false;
            }
        }
        ListNode slow = head;
        ListNode fast = head;
        int cnt = 0;
        while (true) {
            slow = slow.next;
            cnt++;
            if (fast.next == null) {//odd
                cnt--;
                break;
            }
            if (fast.next.next == null) { //even
                break;
            }
            fast = fast.next.next;
        }
        // System.out.println("after while, slow.val =" +slow.val);
        ListNode fan = head;
        ListNode temp = head;
        ListNode newHead = head;
        int n = 0;
        // System.out.println("cnt= " + cnt);
        while (n < cnt - 1) {
            temp = fan.next;
            fan.next = fan.next.next;
            temp.next = newHead;
            newHead = temp;
            // System.out.println("temp =" +temp.val);
            n++;
        }
        fan.next = null;
        boolean f = true;
        while (true) {
            // System.out.println(slow.val + " | " + newHead.val);
            if (slow.val == newHead.val) {
                slow = slow.next;
                newHead = newHead.next;
            } else {
                f = false;
                break;
            }
            if (slow == null && newHead != null) {
                f = false;
                break;
            } else if (slow != null && newHead == null) {
                f = false;
                break;
            } else if (slow == null && newHead == null) {
                break;
            }
        }
        return f;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        Stack<Integer> stack = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            stack.push(slow.val);
            slow = slow.next;
            if (fast.next == null) {//odd
                stack.pop();
                break;
            }
            if (fast.next.next == null) { //even
                break;
            }
            fast = fast.next.next;
        }
        boolean flag = true;
        while (!stack.empty() && slow != null) {
            int temp = stack.pop();
            if (slow.val == temp) {
                slow = slow.next;
            } else {
                flag = false;
                break;
            }
        }
        if (!stack.empty() || slow != null)
            flag = false;
        return flag;
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode now = head;
        ListNode temp = head;
        int cnt = 0;
        while (now.next.next != null) {
            cnt++;
            temp = now.next;
            now.next = now.next.next;
            now = temp;
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

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode now = head;
        while (now.next != null) {
            ListNode temp = now.next;
            now.next = now.next.next;
            temp.next = head;
            head = temp;
        }
        return head;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        ListNode now = newHead;
        while (now.next != null) {
            now = now.next;
        }
        now.next = head;
        head.next = null;
        return newHead;
    }

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

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= this.size || index < 0) return -1;
        ListNode now = this.head;
        int i = 0;
        while (now != null) {
            if (i == index)
                return now.val;
            now = now.next;
            i++;
        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val);
        if (this.head == null) {
            this.head = newHead;
        } else {
            newHead.next = this.head;
            this.head = newHead;
        }
        this.size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        ListNode nowNode = this.head;
        while (nowNode.next != null)
            nowNode = nowNode.next;
        nowNode.next = new ListNode(val);
        this.size++;
//        System.out.println(this.size);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > this.size) return;
        if (index <= 0) { //I have some question here, if I write index == 0   some case will not pass in LeetCode
            this.addAtHead(val);// because he have a case addAtIndex(-1, 0), I doubt this case is legal
            return;
        }
        ListNode nowNode = this.head;
        int i = 0;
        while (nowNode != null) {
            if (i == index - 1) {
                ListNode newNode = new ListNode(val);
                newNode.next = nowNode.next;
                nowNode.next = newNode;
                break;
            }
            nowNode = nowNode.next;
            i++;
        }
        this.size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= this.size || index < 0) return;
        if (index == 0) {
            this.head = this.head.next;
            this.size--;
        }

        ListNode nowNode = this.head;
        int i = 0;
        while (nowNode != null) {
            if (i == index - 1) {
//                System.out.println("i = " + i);
                nowNode.next = nowNode.next.next;
                this.size--;
                return;
            }
            nowNode = nowNode.next;
            i++;
        }
        this.size--;
    }

    /**
     * display this class 's linkedlist
     */
    public void display() {
        ListNode nowNode = this.head;
        while (nowNode != null) {
            System.out.print(nowNode.val + " -> ");
            nowNode = nowNode.next;
        }
//        System.out.print("null");
//        System.out.println("    size = " + this.size);
    }

    /**
     * display a single node and nodes behind it
     */
    static public void display(ListNode head) {
        ListNode nowNode = head;
//        int size = 0;
        while (nowNode != null) {
            System.out.print(nowNode.val + " -> ");
//            size++;
            nowNode = nowNode.next;
        }

//        System.out.print("null");
//        System.out.println("    size = " + size);
    }

    public static void main(String[] args) {
//        MyLinkedList l1 = new MyLinkedList();
//        MyLinkedList l2 = new MyLinkedList();
//        MyLinkedList a = new MyLinkedList();
//
//        l1.addAtHead(9);
//        l1.addAtTail(8);
////        l1.addAtTail(3);
//        l1.display();
//        l2.addAtHead(1);
////        l2.addAtTail(6);
////        l2.addAtTail(0);
//        l2.display();
//
//        a.display(a.addTwoNumbers(l1.head, l2.head));
//
//        //看这下面的代码   你就抄我的啊！！！！
//        Scanner sc = new Scanner(System.in);
//        int lenghth = sc.nextInt();
//        ListNode head = new ListNode(sc.nextInt());
//            ListNode rear = head;
//            for(int i = 1; i < lenghth; i++ ){
//                int num = sc.nextInt();
//                rear.next = new ListNode(num);
//                rear = rear.next;
//        }
        int[] arr = {3, 6, 4, 1, 4, 9 ,0, 8 ,6, 6};
        ListNode head = new ListNode(3);
        ListNode p = head;
        for (int i = 1; i < arr.length; i++) {
            p.next = new ListNode(arr[i]);
            p = p.next;
        }


    }

}
