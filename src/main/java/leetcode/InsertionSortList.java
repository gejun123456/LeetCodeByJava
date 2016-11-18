package leetcode;

/**
 * Created by bruce on 14-11-13.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head==null||head.next == null) {
            return head;
        }
        ListNode p = head;
        while(p.next!=null) {
            ListNode q = p.next;
            ListNode r = q.next;
            if(q.val<p.val) {
                p.next = r;
                if(q.val<head.val) {
                    q.next = head;
                    head = q;
                } else {
                    ListNode m = head;
                    while(m.next!=r) {
                        if(q.val<m.next.val) {
                            q.next = m.next;
                            m.next = q;
                            break;
                        }
                        m = m.next;
                    }
                }
            } else {
                p = p.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        InsertionSortList insert = new InsertionSortList();
        ListNode result = insert.insertionSortList(a);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
