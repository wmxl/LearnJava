package LeetCode;

public class MyLinkedList {
    int size = 0;
    ListNode head;

    class ListNode {
        int val;
        ListNode next, prev;

        ListNode(int x) {
            val = x;
        }
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
        int i = 0;
        ListNode now = this.head;
        while (now != null) {
            if(index == i) return now.val;
            i++;
            now = now.next;
        }
        return  -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val);
        if(this.head == null){
            this.head = newHead;
        }else {
            newHead.next = this.head;
            this.head.prev = newHead;
            this.head = newHead;
        }
        this.size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        ListNode tail = new ListNode(val);
        ListNode now = this.head;
        if(now == null){
            this.head = tail;
            size++;
            return;
        }
        while (now.next != null){
            now = now.next;
        }
        now.next = tail;
        tail.prev = now;
        this.size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        if(index == size){
            addAtTail(val);
            return;
        }
        if(index <= 0){
            addAtHead(val);
            return;
        }
        ListNode newNode = new ListNode(val);
        ListNode now = this.head;
        int i = 0;
        while (now != null){
            if(i == index-1){
                newNode.next = now.next;
                now.next.prev = newNode;
                now.next = newNode;
                newNode.prev = now;
                break;
            }
            now = now.next;
            i++;
        }
        this.size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if(index >= size || index < 0){
            return;
        }
        ListNode now = this.head;
        if(index == 0){
            this.head = this.head.next;
            size--;
            return;
        }
        int i = 0;
        while (now != null){
            if(i == index-1){
                if(now.next.next != null)
                    now.next.next.prev = now;
                now.next = now.next.next;
                break;
            }
            now = now.next;
            i++;
        }
        size--;
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
        System.out.print("null");
        System.out.println("    size = " + this.size);
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
//        String[] instructions = {"addAtHead","get","addAtIndex","deleteAtIndex","get","addAtIndex","addAtHead","get","deleteAtIndex","get","addAtHead","get","addAtHead","addAtTail","addAtHead","get","addAtHead","addAtHead","get","addAtTail","get","addAtTail","addAtTail","deleteAtIndex","addAtHead","addAtIndex","addAtTail","deleteAtIndex","addAtHead","addAtHead","addAtTail","get","get","addAtHead","addAtTail","addAtTail","deleteAtIndex","addAtHead","addAtHead","addAtTail","addAtTail","addAtTail","addAtHead","addAtTail","addAtIndex","addAtTail","addAtHead","addAtTail","addAtHead","get","deleteAtIndex","deleteAtIndex","addAtIndex","addAtTail","addAtTail","deleteAtIndex","get","addAtHead","addAtIndex","addAtHead","addAtTail","addAtIndex","addAtTail","get","addAtHead","addAtHead","addAtTail","addAtTail","addAtHead","addAtHead","addAtIndex","addAtHead","addAtHead","addAtTail","addAtHead","get","addAtIndex","addAtTail","addAtHead","addAtIndex","addAtTail","addAtIndex","get","addAtTail","get","addAtHead","get","addAtHead","get","get","addAtHead","get","addAtTail","deleteAtIndex","deleteAtIndex","addAtHead","deleteAtIndex","addAtHead","deleteAtIndex","addAtTail","addAtHead"};
////        for (int i = 0; i < instructions.length; i++) {
////            System.out.println(instructions[i]);
////        }
//        int[][] p = new int[instructions.length][2];
//
//        String parameterString = "[56],[1],[1,50],[1],[1],[1,43],[82],[2],[3],[1],[41],[1],[44],[36],[57],[1],[64],[24],[4],[89],[5],[7],[33],[11],[24],[2,66],[91],[7],[48],[67],[32],[14],[12],[97],[91],[29],[6],[47],[69],[13],[88],[82],[4],[8],[8,85],[75],[56],[16],[51],[4],[13],[27],[11,62],[66],[10],[4],[28],[87],[22,99],[17],[30],[28,82],[17],[16],[76],[61],[36],[45],[31],[19],[2,73],[56],[58],[48],[87],[2],[4,49],[99],[81],[9,2],[39],[35,35],[19],[98],[50],[73],[22],[29],[6],[45],[13],[54],[42],[3],[8],[27],[16],[43],[39],[0],[23]";
//        int cnt =0;
//        for (int i = 0; i < parameterString.length(); i++) {
//            char c = parameterString.charAt(i);
//            if(c =='['){
//                int j = 0;
//                String s = "";
//                for(j = i+1; parameterString.charAt(j)!=']'; j++){
//                    s += parameterString.charAt(j);
//                }
//                String[] parameters = s.split(",");
//                for (int k = 0; k < parameters.length; k++) {
//                    p[cnt][k] = Integer.parseInt(parameters[k]);
//                }
//                cnt++;
//                i = j;
//            }
//        }
//        for (int i = 0; i < instructions.length; i++) {
//            System.out.print(i +": " + instructions[i] + " ");
//            System.out.println(p[i][0] + " " + p[i][1]);
//            switch (instructions[i]){
//                case "addAtHead":
//                    linkedList.addAtHead(p[i][0]);
//                    break;
//                case "get":
//                    linkedList.get(p[i][0]);
//                    break;
//                case "addAtIndex":
//                    linkedList.addAtIndex(p[i][0], p[i][1]);
//                    break;
//                case "deleteAtIndex":
//                    linkedList.deleteAtIndex(p[i][0]);
//                    break;
//                case "addAtTail":
//                    linkedList.addAtTail(p[i][0]);
//                    break;
//                default:
//                    System.out.println("others situation");
//                    break;
//            }
//            linkedList.display();

        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);
        System.out.println(linkedList.get(1));
        linkedList.deleteAtIndex(1);
        System.out.println(linkedList.get(1));
        linkedList.display();
    }
}
/*
["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
[[],[1],[3],[1,2],[1],[1],[1]]
 */
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */