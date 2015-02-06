import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruce on 14-12-14.
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> first = new ArrayList<Integer>();
        first.add(1);
        List<Integer> p = first;
        for (int i = 2; i <= rowIndex+1; i++) {
            List<Integer> cur = new ArrayList<Integer>();
            cur.add(1);
            for (int j = 0; j < p.size() - 1; j++) {
                cur.add(p.get(j) + p.get(j + 1));
            }
            cur.add(1);
            p = cur;
        }
        return p;
    }

    public static void main(String[] args) {
        List<Integer> row = new PascalsTriangleII().getRow(0);
        for(Integer r : row) {
            System.out.printf(r+" ");
        }
    }
}
