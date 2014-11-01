import java.util.*;

/**
 * Created by Administrator on 14-11-1.
 */
public class RefactorWordLadder2 {
    public class node {
        String value;
        node next;
    }

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<node> solution = new ArrayList<node>();
        node first = new node();
        first.value = start;
        solution.add(first);
        dict.remove(start);
        dict.remove(end);
        result = search(solution, end, dict);
        return result;
    }

    private List<List<String>> search(List<node> nodeList, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<node> realResult = new ArrayList<node>();
        List<node> currentResult = new ArrayList<node>();
        List<String> deleted = new ArrayList<String>();
        int k = 0;
        for (node so : nodeList) {
            if (compare(so.value, end)) {
                node ss = new node();
                ss.value = end;
                ss.next = so;
                realResult.add(ss);
                k = 1;
            } else if (k != 1) {
                for (String s : compute(so.value)) {
                    if (dict.contains(s)) {
                        node ss = new node();
                        ss.value = s;
                        ss.next = so;
                        currentResult.add(ss);
                    }
                }
            }
        }
        if (k == 1) {
            for (node so : realResult) {
                List<String> sol = new ArrayList<String>();
                String[] arr = new String[1000];
                int i = 0;
                while (so.next != null) {
                    arr[i] = so.value;
                    so = so.next;
                    i++;
                }
                for (int u = i - 1; u >= 0; u--) {
                    sol.add(arr[u]);
                }
                result.add(sol);
            }
            return result;
        } else {
            if (currentResult.size() == 0) {
                return result;
            }
            for (String s : deleted) {
                dict.remove(s);
            }
            return search(currentResult, end, dict);
        }
    }

    private boolean compare(String p, String q) {
        int l = p.length();
        int difference = 0;
        for (int i = 0; i < l; i++) {
            if (p.charAt(i) != q.charAt(i)) {
                difference++;
                if (difference > 1) {
                    return false;
                }
            }
        }
        if (difference != 1) {
            return false;
        }
        return true;
    }

    private List<String> compute(String p) {
        List<String> near = new ArrayList<String>();
        int l = p.length();
        for (int i = 0; i < l; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != p.charAt(i)) {
                    String r = p.substring(0, i) + c + p.substring(i + 1, l);
                    near.add(r);
                }
            }
        }
        return near;
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
