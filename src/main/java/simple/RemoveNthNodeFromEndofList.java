package simple;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bruce on 14-11-22.
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer,ListNode> map= new HashMap<Integer,ListNode>();
        int len = 0;
        ListNode p = head;
        while(p!=null) {
            len++;
            map.put(len,p);
            p = p.next;
        }
        if(n==len) {
            return head.next;
        }
        ListNode h = map.get(len-n);
        h.next = h.next.next;
        return head;
    }
}
