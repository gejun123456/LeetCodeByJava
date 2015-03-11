package createNodeList;

/**
 * Created by bruce on 3/11/2015.
 */
public class ReverseCreateNode {
    public static void main(String[] args) {
        Node start = new Node();
        for (int i = 0; i < 5; i++) {
            Node s = new Node(i);
            Node r = start;
            s.next = r;
            start = s;
        }
        while(start!=null) {
            System.out.println(start.val);
            start = start.next;
        }
    }
}
