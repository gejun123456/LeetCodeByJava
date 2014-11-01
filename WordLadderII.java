import java.util.*;

/**
 * Created by Administrator on 14-11-1.
 */
public class WordLadderII {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<String> solution = new ArrayList<String>();
        List<List<String>> result = new ArrayList<List<String>>();
        if (start == end) {
            solution.add(start);
            result.add(solution);
            return result;
        }
        if (compare(start, end) == 1) {
            solution.add(start);
            solution.add(end);
            result.add(solution);
            return result;
        } else {
            int judge = 0;
            for (Iterator it = dict.iterator(); it.hasNext(); ) {
                String word = it.next().toString();
                if (compare(end, word) == 1) {
                    judge = 1;
                }
            }
            if (judge == 0) {
                return result;
            } else {
                List<Integer> min = new ArrayList<Integer>();
                min.add(10000);
                solution.add(start);
                check(start, end, dict, solution, result, min);
                return result;
            }
        }
    }

    private void check(String start, String end, Set<String> dict, List<String> solution, List<List<String>> result, List<Integer> min) {

        for(Iterator it = dict.iterator();it.hasNext();) {
            String word = it.next().toString();
            if (solution.size() < min.get(0) - 1 && compare(word,end)<=(min.get(0) - solution.size()) ) {
                if (compare(start, word) == 1 && compare(word, end) == 1) {
                    solution.add(word);
                    solution.add(end);
                    if (result.size() == 0 || solution.size() == min.get(0)) {
                        result.add(solution);
                    } else if (solution.size() < min.get(0)) {
                        result.clear();
                        result.add(solution);
                    }
                    min.add(0,solution.size());
                } else if (compare(start, word) == 1) {
                    Set<String> newDict = new HashSet<String>();
                    for(Iterator o = dict.iterator();o.hasNext();) {
                        String dic = o.next().toString();
                        if(dic != word) {
                            newDict.add(dic);
                        }
                    }
                    List<String> nextSolution = new ArrayList<String>();
                    for(String s : solution) {
                        nextSolution.add(s);
                    }
                    nextSolution.add(word);
                    if (newDict.size() != 0) {
                        check(word, end, newDict, nextSolution, result, min);
                    }
                }
            }
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
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        result = wordLadderII.findLadders("hit", "cog", dict);
        System.out.println(result.size());
        for (List<String> solution : result) {
            for (String s : solution) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
