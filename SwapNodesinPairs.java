/**
 * Created by Administrator on 14-10-25.
 */
public class SwapNodesinPairs {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode a = head;
        ListNode b =head.next;
        head = b;
        while(b!=null){
           ListNode c = b.next;
            b.next = a;
            a.next = c;
            if(c == null)
                return head;
            a = c;
            b = c.next;
        }
        return head;
    }
}
