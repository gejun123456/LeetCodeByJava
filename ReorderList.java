/**
 * Created by bruce on 14-11-19.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head==null) {
            return;
        }
        int len = 0;
        ListNode p = head;
        while(p!=null) {
            len++;
            p=p.next;
        }
        if(len==1||len==2){
            return;
        }
        int m = len/2;
        p = head;
        int left = 0 ;
        ListNode k = new ListNode(0);
        while(p.next!=null) {
            left++;
            if(left>m) {
                k= p.next;
                break;
            }
            p = p.next;
        }
        p.next = null;
        p = head;
        ListNode uu = k;
        ListNode mm  = new ListNode(2);
        while(uu!=null) {
            ListNode kk = mm.next;
            ListNode g = uu.next;
            uu.next = kk;
            mm.next = uu;
            uu = g;
        }
        k = mm.next;
        while(k!=null) {
            ListNode r = k.next;
            k.next = p.next;
            p.next = k;
            k = r;
            p = p.next.next;
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
//        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
//        c.next = d;
        ReorderList re = new ReorderList();
        re.reorderList(a);
        while (a != null) {
            System.out.printf(a.val + "");
            a= a.next;
        }
    }
}