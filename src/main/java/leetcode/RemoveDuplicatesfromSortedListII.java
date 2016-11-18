package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bruce on 14-11-22.
 */
public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode h = new ListNode(0);
        ListNode p = head;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        while(p!=null) {
            if(!map.containsKey(p.val)) {
                map.put(p.val,1);
            } else {
                map.put(p.val,map.get(p.val) +1);
            }
            p = p.next;
        }
        h.next = head;
        p = h;
        while(p.next!=null) {
            if(map.get(p.next.val)>1) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return h.next;
    }
}
