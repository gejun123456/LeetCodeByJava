package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruce on 14-11-19.
 */
public class MergekSortedLists {
    public ListNode mergeKLists(List<ListNode> lists) {
        int len = lists.size();
        if(len==0) {
            return null;
        }
        if (len == 1) {
            return lists.get(0);
        } else {
            List<ListNode> result = new ArrayList<ListNode>();
            int m = len / 2;
            for (int i = 0; i < m; i++) {
                ListNode mre = merge2List(lists.get(2 * i), lists.get(2 * i + 1));
                result.add(mre);
            }
            if (2 * m != len) {
                result.add(lists.get(len - 1));
            }
            return mergeKLists(result);
        }

    }

    private ListNode merge2List(ListNode first, ListNode second) {
        ListNode p = first;
        ListNode q = second;
        ListNode m = new ListNode(0);
        ListNode r = m;
        while (p != null && q != null) {
            if (p.val < q.val) {
                ListNode buf = p.next;
                p.next = null;
                r.next = p;
                r = p;
                p = buf;
            } else {
                ListNode buf = q.next;
                q.next = null;
                r.next = q;
                r = q;
                q = buf;
            }
        }
        if (p != null) {
            r.next = p;
        }
        if (q != null) {
            r.next = q;
        }
        return m.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = c;
        b.next = d;
        List<ListNode> res = new ArrayList<ListNode>();
//        res.add(a);
//        res.add(b);
        MergekSortedLists me = new MergekSortedLists();
        ListNode result = me.mergeKLists(res);
        while (result != null) {
            System.out.printf(result.val + " ");
            result = result.next;
        }
    }
}
