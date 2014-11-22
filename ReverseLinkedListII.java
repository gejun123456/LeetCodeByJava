/**
 * Created by bruce on 14-11-20.
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        ListNode h = new ListNode(0);
        ListNode p = head;
        int count = 0;
        ListNode r = h;
        ListNode u = h;
        while (p != null) {
            count++;
            ListNode q = p.next;
            if (count < m) {
                p.next = null;
                r.next = p;
                r = p;
            } else if (count >= m && count <= n) {
                if (count == m) {
                    u = p;
                }
                p.next = r.next;
                r.next = p;
            } else if (count > n) {
                p.next = null;
                u.next = p;
                u = p;
            }
            p = q;
        }

        return h.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
//        ListNode b = new ListNode(2);
//        ListNode c = new ListNode(3);
//        ListNode d = new ListNode(4);
//        ListNode e = new ListNode(5);
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = e;
        ReverseLinkedListII re = new ReverseLinkedListII();
        re.reverseBetween(a, 1, 1);
        while (a != null) {
            System.out.printf(a.val + " ");
            a = a.next;
        }
    }
}
