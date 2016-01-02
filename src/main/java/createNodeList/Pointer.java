package createNodeList;

/**
 * Created by bruce on 3/11/2015.
 */
public class Pointer {
    public static void main(String[] args) {
        Node s = new Node(100);
        Node r = s;
        s = new Node(200); //s 指向了新的节点，相当于值变了
        System.out.println(r.val);
        r = s;
        s.val = 300;  // s的地址值并未改变
        System.out.println(r.val);

        Node a = new Node(1);
        Node b = new Node(4);
        a.next = b;
        b = new Node(5);
        System.out.println(a.next.val);

        Node c = new Node(100);  //只会绑到当时的对象上，不会一直和对象绑定。
        Node d = new Node(200);
        c.next = d;

        d.val = 400;  //释放地址不可单纯设为null，需要知道对象的地址才进行释放，java则不需要考虑这些。
//        Node e = c;
//        e.next = new Node(300);
        System.out.println(c.next.val);


        Node h = new Node(1000);
        Node i = h;
        i.val  = 1001;
        System.out.println(h.val); //对于属性的会改的
        i = new Node(1002);
    }
}
