package createNodeList;

/**
 * Created by bruce on 3/11/2015.
 */
public class ReverseCreateNode {
    public static void main(String[] args) {
        Node start = new Node();
        for (int i = 0; i < 5; i++) {
            Node s = new Node(i);
            s.next = start;
            start = s;     //根本不需要一个变量, 就是一个指针，用来指向一个位置，变了之前绑定到上面的可不会变，只有这个变，不会跟着变
        }
        while(start!=null) {
            System.out.println(start.val);
            start = start.next;
        }
    }
}
