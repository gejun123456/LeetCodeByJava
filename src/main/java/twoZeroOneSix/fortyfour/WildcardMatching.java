package twoZeroOneSix.fortyfour;

import org.junit.Assert;

import static org.junit.Assert.assertEquals;

/**
 * Created by bruce.ge on 2016/10/25.
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p){
        if(s.length()==0&&p.length()==0){
            return true;
        }
        if(p.length()==0&&s.length()>0){
            return false;
        }
        //计算fp到了pstart之后部位*字母个数 如何s中比他少直接结束
        String fp = removeMulti(p);
        int[] flcount = new int[fp.length()];
        int count = 0;
        for (int i = fp.length()-1;i>=0; i--) {
            if(fp.charAt(i)!='*'){
                count++;
            }
            flcount[i]=count;
        }
        return matchWith(s,fp,0,0,flcount);
    }

    //try not to use with substring.
    private boolean matchWith(String s, String fp,int sstart,int pstart,int[] flcount) {
        //try to configure with the end point.
        if(s.length()-sstart<flcount[pstart]){
            return false;
        }
        if(s.length()-sstart==0&& fp.length()-pstart>=2){
            return false;
        }
        if(fp.length()-pstart==1){
            if(fp.charAt(pstart)=='*'){
                return true;
            } else if(fp.charAt(pstart)=='?'&&s.length()-sstart==1){
                return true;
            } else if(s.length()-sstart==1&&s.charAt(sstart)==fp.charAt(pstart)){
                return true;
            } else {
                return false;
            }
        } else {
            if(fp.charAt(pstart)=='*'){
                boolean a = matchWith(s,fp,sstart,pstart+1,flcount);
                if(a){
                    return true;
                }
                boolean b = matchWith(s,fp,sstart+1,pstart,flcount);
                if(b){
                    return true;
                }
                return false;
            } else if(fp.charAt(pstart)=='?'||fp.charAt(pstart)==s.charAt(sstart)){
                return matchWith(s,fp,sstart+1,pstart+1,flcount);
            } else {
                return false;
            }
        }
    }

    private String removeMulti(String p) {
        if(p.length()<2){
            return p;
        }
        String pp="";
        pp+=p.charAt(0);
        for (int i = 1; i < p.length(); i++) {
            if(p.charAt(i)=='*'&&pp.charAt(pp.length()-1)=='*'){
                continue;
            }
            pp+=p.charAt(i);
        }
        return pp;
    }

    public static void main(String[] args) {
        WildcardMatching matching = new WildcardMatching();
//        System.out.println(matching.removeMulti("***b**a*a*b***b*a*b*bbb**baa*bba**b**bb***b*a*aab*a**"));
//        assertEquals(false,matching.isMatch("aa","a"));
//        assertEquals(true,matching.isMatch("aa","aa"));
//        assertEquals(false,matching.isMatch("aaa","aa"));
//        assertEquals(true,matching.isMatch("aa","*"));
//        assertEquals(true,matching.isMatch("aa","a*"));
//        assertEquals(true,matching.isMatch("aa","?*"));
//        assertEquals(false,matching.isMatch("aab","c*a*b"));
        long start = System.currentTimeMillis();
        boolean oo = matching.isMatch("abbaabbbbababaababababbabbbaaaabbbbaaabbbabaabbbbbabbbbabbabbaaabaaaabbbbbbaaabbabbbbababbbaaabbabbabb",
                "***b**a*a*b***b*a*b*bbb**baa*bba**b**bb***b*a*aab*a**");
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(oo);
    }
}
