/**
 * Created by bruce on 14-11-5.
 */
public class RotateList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode rotateRight(ListNode head, int n) {
            if (head == null) {
                return head;
            }
            ListNode p = head;
            int u = 0;
            while (p != null) {
                u++;
                p = p.next;
            }
            p = head;
            if (n >= u) {
                n = n % u;
            }
            if (n == 0) {
                return head;
            }
            int k = 0;
            while (p != null && k < u - n - 1) {
                p = p.next;
                k++;
            }
            ListNode r = p.next;
            p.next = null;
            ListNode q = r;
            while (r.next != null) {
                r = r.next;
            }
            r.next = head;
            return q;
        }
    }
}
