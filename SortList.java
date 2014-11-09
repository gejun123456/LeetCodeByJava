import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 14-11-3.
 */

public class SortList {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode sortList(ListNode head) {
        ListNode p = head;
        int[] arr = new int[100000];
        int i =0;
        while(p!=null) {
            arr[i] = p.val;
            i++;
            p = p.next;
        }
        Arrays.sort(arr,0,i);
        ListNode u = head;
        i = 0;
        while(u!=null) {
            u.val = arr[i];
            i++;
            u=u.next;
        }
        return head;
    }
}
