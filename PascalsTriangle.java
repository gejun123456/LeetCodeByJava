import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruce on 14-11-19.
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows==0) {
            return result;
        }
        List<Integer> first = new ArrayList<Integer>();
        first.add(1);
        result.add(first);
        List<Integer> p = first;
        for (int i = 2; i <=numRows ; i++) {
            List<Integer> cur = new ArrayList<Integer>();
            cur.add(1);
            for (int j = 0; j < p.size()-1; j++) {
                cur.add(p.get(j)+p.get(j+1));
            }
            cur.add(1);
            result.add(cur);
            p = cur;
        }
        return result;
    }
}
