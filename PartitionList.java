/**
 * Created by bruce on 14-11-8.
 */
public class PartitionList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode p = head;
        if(head==null) {
            return head;
        }
        while (p.next != null) {
            if (p.next.val < x) {
                ListNode q = p.next;
                p.next = q.next;
                q.next = null;
                if (head.val >= x) {
                    q.next = head;
                    head = q;
                } else {
                    ListNode r = head;
                    while (r.next != null && r.next.val < x) {
                        r = r.next;
                    }
                    if (r.next == null) {
                        r.next = q;
                    } else {
                        q.next = r.next;
                        r.next = q;
                    }
                }

            }
            p = p.next;
            if(p==null) {
                break;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
//        ListNode d = new ListNode(2);
//        ListNode e = new ListNode(5);
//        ListNode f = new ListNode(2);
        a.next = b;
        b.next = c;
//        c.next = d;
//        d.next = e;
//        e.next = f;
        PartitionList partitionList = new PartitionList();
        ListNode result = partitionList.partition(a, 4);
        while (result!= null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
