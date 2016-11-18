package code_2016.leetcode_44;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by bruce.ge on 2016/10/26.
 */
public class WildcardMathchingFast {

    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        if (p.length() == 0 && s.length() > 0) {
            return false;
        }
        //计算fp到了pstart之后部位*字母个数 如何s中比他少直接结束
        String fp = removeMulti(p);

        String cur = "";
        String startstring="";
        int u=0;
        if(fp.charAt(0)!='*'){
            for (int i = 0; i < fp.length(); i++) {
                if(fp.charAt(i)!='*'){
                    startstring+=fp.charAt(i);
                }else {
                    break;
                }
            }
        }
        if(s.length()<startstring.length()){
            return false;
        }
        for (int i = 0; i < startstring.length(); i++) {
            if(! (s.charAt(i)==startstring.charAt(i))&&startstring.charAt(i)!='?'){
                return false;
            }
        }

        if(fp.length()==startstring.length()&&s.length()!=startstring.length()){
            return false;
        }

        s= s.substring(startstring.length());

        u= startstring.length();

        boolean hasMask = false;
        List<String> kmpString = new ArrayList<String>();
        for (int i = u; i < fp.length(); i++) {
            if (fp.charAt(i) == '*') {
                hasMask= true;
                if (!cur.equals("")) {
                    kmpString.add(cur);
                    cur = "";
                }
            } else {
                cur += fp.charAt(i);
            }
        }
        String lastString = cur;
        //first need to match with kmpstrings
        int j = 0;
        if (kmpString.size() > 0) {
            for (String kmp : kmpString) {
                j = kmpmatch(s, kmp);
                if(j==-1){
                    return false;
                }
                s = s.substring(j);
            }
        }
        if(!lastString.equals("")){
            if(!hasMask){
                if(s.length()==lastString.length()&&fullMatch(s,lastString)){
                    return true;
                }
            } else if(fullMatch(s,lastString)){
                return true;
            }
            return false;
        } else {
            return true;
        }
    }

    private int kmpmatch(String s, String kmp) {
        int len = kmp.length();
        if(s.length()<len){
            return -1;
        }
        for (int i = 0; i <= s.length() - kmp.length(); i++) {
            if(same(s.substring(i,i+len),kmp)){
                return i+len;
            }
        }
        return -1;
    }

    private boolean same(String substring, String kmp) {
        for (int i = 0; i < kmp.length(); i++) {
            if(kmp.charAt(i)=='?'||substring.charAt(i)==kmp.charAt(i)){
                continue;
            }
            return false;
        }
        return true;
    }

    private boolean fullMatch(String substring, String lastString) {
        if(lastString.length()>substring.length()){
            return false;
        }
        for (int i = lastString.length()-1; i >=0; i--) {
            if(!(substring.charAt(substring.length()-lastString.length()+i)==lastString.charAt(i))&&lastString.charAt(i)!='?'){
                  return false;
            }
        }
        return true;
    }





    private String removeMulti(String p) {
        if (p.length() < 2) {
            return p;
        }
        String pp = "";
        pp += p.charAt(0);
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '*' && pp.charAt(pp.length() - 1) == '*') {
                continue;
            }
            pp += p.charAt(i);
        }
        return pp;
    }


    public static void main(String[] args) {
        WildcardMathchingFast matching = new WildcardMathchingFast();
//        System.out.println(matching.removeMulti("***b**a*a*b***b*a*b*bbb**baa*bba**b**bb***b*a*aab*a**"));
//        assertEquals(false, matching.isMatch("abcdef", "a?de*"));
//        assertEquals(true, matching.isMatch("aa", "aa"));
//        assertEquals(false, matching.isMatch("aaa", "aa"));
//        assertEquals(true, matching.isMatch("aa", "*"));
        assertEquals(true, matching.isMatch("aa", "aa"));
        assertEquals(true, matching.isMatch("a", "a*"));

        assertEquals(true, matching.isMatch("aa", "?*"));
        assertEquals(false, matching.isMatch("aab", "c*a*b"));
//        long start = System.currentTimeMillis();
//        boolean oo = matching.isMatch("abbaabbbbababaababababbabbbaaaabbbbaaabbbabaabbbbbabbbbabbabbaaabaaaabbbbbbaaabbabbbbababbbaaabbabbabb",
//                "***b**a*a*b***b*a*b*bbb**baa*bba**b**bb***b*a*aab*a**");
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);
//        System.out.println(oo);
    }
}
