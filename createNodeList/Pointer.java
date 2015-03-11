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
    }
}
