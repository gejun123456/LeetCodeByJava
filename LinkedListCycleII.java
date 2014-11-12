import java.util.HashSet;

/**
 * Created by bruce on 14-11-12.
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> nodeSet = new HashSet<ListNode>();
        while(head!=null) {
            if(!nodeSet.contains(head)) {
                nodeSet.add(head);
            } else {
                return head;
            }
            head = head.next;
        }
       return null;
    }
}
