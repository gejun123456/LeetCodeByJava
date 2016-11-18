package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruce on 14-11-16.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> first = new ArrayList<Integer>();
        List<Integer> second = new ArrayList<Integer>();
        while (l1 != null) {
            first.add(l1.val);
            l1=l1.next;
        }
        while (l2 != null) {
            second.add(l2.val);
            l2=l2.next;
        }
        List<Integer> res = new ArrayList<Integer>();
        int i = 0;
        int len1 = first.size();
        int len2 = second.size();
        int c = 0;
        int sum = 0;
        while (i < len1 && i < len2) {
            int num1 = first.get(i);
            int num2 = second.get(i);
            sum = num1 + num2 + c;
            res.add(sum % 10);
            c = sum / 10;
            i++;
        }
        while (i < len1) {
            int num1 = first.get(i);
            sum = num1 + c;
            res.add(sum % 10);
            c = sum / 10;
            i++;
        }
        while (i < len2) {
            int num2 = second.get(i);
            sum = num2 + c;
            res.add(sum % 10);
            c = sum / 10;
            i++;
        }
        if (c!=0) {
            res.add(c);
        }
        int len3 = res.size();
        if (len3 == 0) {
            return null;
        }
        ListNode head = new ListNode(res.get(0));
        ListNode r = head;
        for (i = 1;i<len3;i++) {
            ListNode k = new ListNode(res.get(i));
            r.next = k;
            r = k;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(6);
        ListNode f = new ListNode(4);
        d.next = e;
        e.next = f;
        AddTwoNumbers ad = new AddTwoNumbers();
        ListNode result = ad.addTwoNumbers(a, d);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
