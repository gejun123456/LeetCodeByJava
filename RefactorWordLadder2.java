import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

/**
 * Created by Administrator on 14-11-1.
 */
public class RefactorWordLadder2 {
    public class node {
        String value;
        node next;
        int used;
    }

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<node> solution = new ArrayList<node>();
        node first = new node();
        first.value = end;
        first.used = -1;
        solution.add(first);
        dict.remove(start);
        dict.remove(end);
        result = search(solution, start, dict);
        return result;
    }

    private List<List<String>> search(List<node> nodeList, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<node> realResult = new ArrayList<node>();
        List<node> currentResult = new ArrayList<node>();
        List<String> endResult = compute(end);
        List<String> deleted = new ArrayList<String>();
        int k = 0;
        for (node so : nodeList) {
            if (endResult.contains(so.value)) {
                node ss = new node();
                ss.value = end;
                ss.next = so;
                realResult.add(ss);
                k = 1;
            }
        }
        if (k == 1) {
            for (node so : realResult) {
                List<String> sol = new ArrayList<String>();
                while (so != null) {
                    sol.add(so.value);
                    so = so.next;
                }
                result.add(sol);
            }
            return result;
        } else {
            for (node so : nodeList) {
                String p = so.value;
                for (int i = 0; i < p.length(); i++) {
                    if (so.used == i) {
                        continue;
                    }
                    for (char c = 'a'; c <= 'z'; c++) {
                        String str = p.substring(0, i) + c + p.substring(i + 1, p.length());
                        if (dict.contains(str)) {
                            deleted.add(str);
                            node ss = new node();
                            ss.value = str;
                            ss.next = so;
                            ss.used = i;
                            currentResult.add(ss);
                            deleted.add(str);
                        }
                    }
                }
//                for (String s : computeNode(so)) {
//                    if (dict.contains(s)) {
//
//                    }
//                }
            }
            if (currentResult.size() == 0) {
                return result;
            }
            for (String s : deleted) {
                dict.remove(s);
            }
            return search(currentResult, end, dict);
        }
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
        RefactorWordLadder2 wordLadder = new RefactorWordLadder2();
        List<List<String>> result = new ArrayList<List<String>>();
        Set<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        result = wordLadder.findLadders("hit", "cog", dict);
        System.out.println(result.size());
        for (List<String> solution : result) {
            for (String s : solution) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
        System.out.println("nimaya");
    }
}
