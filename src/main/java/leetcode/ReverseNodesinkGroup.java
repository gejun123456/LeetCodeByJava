package leetcode;

/**
 * Created by bruce on 14-11-22.
 */
public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null) {
            return null;
        }
        ListNode p = head;
        int len = 0;
        while(p!=null) {
            len++;
            p=p.next;
        }
        if(k>len) {
            return head;
        }
        int count = len/k;
        ListNode bigHead = new ListNode(0);
        p = head;
        ListNode r = bigHead;
        ListNode eachHead = r;
        for (int i = 0; i < count; i++) {
            int h = 0;
            while(h<k) {
                if(h==0) {
                    eachHead = p;
                }
                ListNode q = p.next;
                p.next = null;
                p.next = r.next;
                r.next = p;
                h++;
                p=q;
            }
            r = eachHead;
        }
        r.next = p;
        return bigHead.next;
    }
}
