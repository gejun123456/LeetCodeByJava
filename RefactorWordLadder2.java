import java.util.*;

/**
 * Created by Administrator on 14-11-1.
 */
public class RefactorWordLadder2 {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> solution = new ArrayList<String>();
        solution.add(start);
        result.add(solution);
        dict.remove(start);
        dict.remove(end);
        result = search(result,end,dict);
        return result;
    }

    private List<List<String>> search(List<List<String>> result, String end, Set<String> dict) {
        List<List<String>> realResult = new ArrayList<List<String>>();
        List<List<String>> currentResult = new ArrayList<List<String>>();
        List<String> deleted = new ArrayList<String>();
        int k = 0;
        for(List<String> so : result) {
            if(compare(so.get(so.size()-1),end)==1) {
                so.add(end);
                realResult.add(so);
                k = 1;
            }
            else if(k!=1) {
                for(Iterator it = dict.iterator();it.hasNext();) {
                    String cur = it.next().toString();
                    if(compare(so.get(so.size()-1),cur)==1) {
                        deleted.add(cur);
                        List<String> sr = new ArrayList<String>();
                        for(String s : so) {
                            sr.add(s);
                        }
                        sr.add(cur);
                        currentResult.add(sr);
                    }
                }
            }
        }
        if(k==1) {
            return realResult;
        } else {
            if(currentResult.size() ==0) {
                return currentResult;
            }
            for(String s :deleted) {
                dict.remove(s);
            }
            return search(currentResult,end,dict);
        }
    }
    private int compare(String p, String q) {
        int l = p.length();
        int difference = 0;
        for (int i = 0; i < l; i++) {
            if (p.charAt(i) != q.charAt(i))
                difference++;
        }
        return difference;
    }

    public static void main(String[] args) {
        WordLadderII wordLadderII = new WordLadderII();
        List<List<String>> result = new ArrayList<List<String>>();
        Set<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dog");
        dict.add("dot");
//        dict.add("lot");
//        dict.add("log");
        result = wordLadderII.findLadders("hot", "dog", dict);
        System.out.println(result.size());
        for (List<String> solution : result) {
            for (String s : solution) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
