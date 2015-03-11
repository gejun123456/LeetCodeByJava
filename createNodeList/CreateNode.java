package createNodeList;

/**
 * Created by bruce on 3/11/2015.
 */
public class CreateNode {
    public static void main(String[] args) {
        Node start = new Node();
        Node r = start;
        for (int i = 0; i < 5; i++) {
            Node m = new Node(i);
            r.next = m;
            r = m;
        }
        while(start!=null) {
            System.out.println(start.val);
            start = start.next;
        }
    }
}
