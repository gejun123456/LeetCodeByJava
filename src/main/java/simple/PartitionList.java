package simple;

/**
 * Created by bruce on 14-11-8.
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode p = head;
        if (head == null) {
            return head;
        }
        while (p.next!= null) {
            if (p.next.val < x) {
                ListNode q = p.next;
                p.next = q.next;
                q.next = null;
                if (head.val >= x) {
                    q.next = head;
                    head = q;
                } else {
                    ListNode r = head;
                    if (r == p && r.val < x) {
                        q.next = p.next;
                        p.next = q;
                        p = p.next;
                    } else {
                        while (r.next != p && r.next.val < x) {
                            r = r.next;
                        }
                        if (r.next == p && p.val < x) {
                            q.next = p.next;
                            p.next = q;
                            p = p.next;
                        } else {
                            q.next = r.next;
                            r.next = q;
                        }
                    }
                }

            }else{
                p= p.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(2);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        PartitionList partitionList = new PartitionList();
        ListNode result = partitionList.partition(a, 3);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
