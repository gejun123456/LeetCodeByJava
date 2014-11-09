/**
 * Created by bruce on 14-11-9.
 */

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) {
        this.label = x;
    }
};

public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) {
            return null;
        }
        RandomListNode res = new RandomListNode(head.label);
        RandomListNode p = head.next;
        RandomListNode r = res;
        int length = 1;
        while(p!=null) {
            length++;
            RandomListNode n = new RandomListNode(p.label);
            r.next = n;
            r = n;
            p = p.next;
        }
        p = head;
        r = res;
        while(p!=null) {
            if(p.random==null) {
                r.random = null;
            } else {
                RandomListNode ran = p.random;
                
            }
            p = p.next;
            r = r.next;
        }

        return res;
    }

    public static void main(String[] args) {
        RandomListNode a = new RandomListNode(1);
        RandomListNode b = new RandomListNode(2);
        RandomListNode c = new RandomListNode(3);
        RandomListNode d = new RandomListNode(4);
        RandomListNode e = new RandomListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        a.random = c;
        b.random = null;
        c.random = b;
        d.random = e;
        e.random = b;
        printRandomList(a);
        CopyListwithRandomPointer co = new CopyListwithRandomPointer();
        RandomListNode res = co.copyRandomList(a);
        printRandomList(res);
    }

    private static void printRandomList(RandomListNode a) {
        RandomListNode p = a;
        while (p != null) {
            System.out.printf(p.label + " ");
            p = p.next;
        }
        System.out.println();
        p = a;
        while (p != null) {
            if (p.random != null) {
                System.out.printf(p.random.label + " ");
            }
            p = p.next;
        }
    }
}
