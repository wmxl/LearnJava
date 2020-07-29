package MianShi;

class ListNode <T>{
    T val;
    ListNode next;
    ListNode(T x) {
        this.val = x;
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
}

public class Main {
    public static void main(String[] args) {

    }
}
