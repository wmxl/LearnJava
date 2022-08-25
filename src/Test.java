class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Test {
    ListNode sort(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode prev = head;
        ListNode i = head;
        while (i.next != null){
            ListNode j = i.next;
            while(j != null){
                if(i.val > j.val){
//                    swap(i,j);
                    i.next = j.next;
                    j.next = i;
                    prev.next = j;
                }
                j = j.next;
            }
            prev = i;
            i = i.next;
        }
        return head;
    }

    ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode p1 = l1, p2 = l2;
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;
        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                p.next = p1;
                p1 = p1.next;
            }else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if(p1 == null) p.next = p2;
        else p.next = p1;

        return newHead.next;
    }

    ListNode sort1(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode now = head;
        int len = 0;
        while (now != null){
            len++;
            now = now.next;
        }
        now = head;
        int cnt = 0;
        while(now != null){
            cnt++;
            now = now.next;
            if(cnt == len/2) break;
        }
        ListNode l1 = head, l2 = now.next;
        now.next = null;
        return merge(sort1(l1),sort1(l2));
    }


}
