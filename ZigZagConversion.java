import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruce on 14-12-13.
 */
public class ZigZagConversion {
    public String convert(String s, int nRows) {
        String result = "";
        if(nRows==1) {
            return s;
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < nRows; i++) {
            List<Integer> kk = new ArrayList<Integer>();
            res.add(kk);
        }
        int mo = (nRows)+(nRows-2);
        for (int i = 0; i < s.length(); i++) {
            if(i%mo>mo/2) {
                res.get(mo-i%mo).add(i);
            } else {
                res.get(i%mo).add(i);
            }
        }
        for(List<Integer> ll : res) {
            if(ll.size()>0) {
                for(Integer u : ll)
                result+=s.charAt(u);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(s.length());
        String res = new ZigZagConversion().convert(s, 3);
        System.out.printf(res);
    }
}
