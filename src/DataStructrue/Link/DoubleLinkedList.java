package DataStructrue.Link;

public class DoubleLinkedList {
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
        DoubleLinkedList linkedList = new DoubleLinkedList();

        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);
        System.out.println(linkedList.get(1));
        linkedList.deleteAtIndex(1);
        System.out.println(linkedList.get(1));
        linkedList.display();
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */