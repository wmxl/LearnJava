package JiuDing;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    
    public ListNode erFenMergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        int len = lists.length;
        while (len > 1){
            int m = (len + 1) / 2;
            for (int i = 0; i < len / 2; i++) {
                lists[i] = merge(lists[i], lists[m + i]);
            }
            len = m;
        }
        return lists[0];
    }

    public ListNode MergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        
        for (int i = 1; i < lists.length; i++) {
            lists[0] = merge(lists[0], lists[i]);
        }
        return lists[0];
    }

    public ListNode merge(ListNode L1, ListNode L2) {
        if (L1 == null) return L2;
        if (L2 == null) return L1;

        ListNode L, now;
        if(L1.val <= L2.val){
            L = L1;
            L1 = L1.next;
        }else {
            L = L2;
            L2 = L2.next;
        }
        now = L;
        while(L1 != null && L2 != null){
            if(L1.val <= L2.val){
                now.next = L1;
                L1 = L1.next;
            }else {
                now.next = L2;
                L2 = L2.next;
            }
            now = now.next;
        }
        if(L1 == null) now.next = L2;
        else now.next = L1;

        return L;
    }
}
