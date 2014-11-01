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
                Integer min = new Integer(10000);
                solution.add(start);
                check(start, end, dict, solution, result, min);
                return result;
            }
        }
    }

    private void check(String start, String end, Set<String> dict, List<String> solution, List<List<String>> result, Integer min) {

        Iterator it = dict.iterator();
        while(it.hasNext()) {
            String word = it.next().toString();
            if (solution.size() < min - 1) {
                if (compare(start, word) == 1 && compare(word, end) == 1) {
                    solution.add(word);
                    solution.add(end);
                    List<String> convert = new ArrayList<String>();
                    for (String s : solution) {
                        convert.add(s);
                    }
                    if (result.size() == 0 || solution.size() == min) {
                        result.add(convert);
                    } else if (solution.size() < min) {
                        result.clear();
                        result.add(convert);
                    }
                    min = solution.size();
                    solution.remove(word);
                    solution.remove(end);
                } else if (compare(start, word) == 1) {
                    dict.remove(word);
                    solution.add(word);
                    if (dict.size() != 0) {
                        check(word, end, dict, solution, result, min);
                    }
                    solution.remove(word);
                    dict.add(word);
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
        for (List<String> solution : result) {
            for (String s : solution) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
