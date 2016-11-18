package leetcode;

/**
 * Created by Administrator on 14-10-28.
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            ListNode head;
            if (l1.val < l2.val) {
                head = l1;
                l1 = l1.next;
            } else {
                head = l2;
                l2 = l2.next;
            }
            ListNode p = head;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    p.next = l1;
                    l1 = l1.next;
                } else {
                    p.next = l2;
                    l2 = l2.next;
                }
                p = p.next;
            }
            while (l1 != null) {
                p.next = l1;
                l1 = l1.next;
                p = p.next;
            }

            while (l2 != null) {
                p.next = l2;
                l2 = l2.next;
                p = p.next;
            }
            return head;
        }
    }
}
