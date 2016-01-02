package simple;

///**
//* Created by bruce on 14-11-23.
//*/
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int len1 = s.length();
        int count = countNum(p);
        if(len1<count) {
            return false;
        }
        p = removeDuplicate(p);
        int len2 = p.length();
        int firstM = -1;
        int lastM = len2;
        int judge = 0;
        for (int i = 0; i < len2; i++) {
            if (p.charAt(i) == '*'&&judge==0) {
                judge = 1;
                firstM = i;
                lastM = i;
            } else if(p.charAt(i)=='*'&&judge==1) {
                lastM = i;
            }
        }
        if (firstM == -1) {
            if (same(s, p)) {
                return true;
            } else {
                return false;
            }
        }
        if (firstM == lastM) {
            if (len2 == 1) {
                return true;
            } else {
                if (firstM > 0 && firstM < len2-1) {
                    if (len1 >= firstM && len1 >= len2 - 1 && same(s.substring(0, firstM),p.substring(0, firstM)) && same(s.substring(len1 - len2 + firstM + 1, len1),p.substring(firstM + 1, len2))) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (firstM == 0) {
                    if (len1 >= len2 - firstM - 1 && same(s.substring(len1 - len2 + firstM + 1, len1),p.substring(firstM + 1, len2))) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    if (len1 >= firstM && same(s.substring(0,firstM), p.substring(0, firstM))) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        } else {
            int start = firstM;
            int end = lastM;
            if (firstM != 0) {
                if (len1 >= firstM && same(s.substring(0, firstM),p.substring(0, firstM))) {
                    start = firstM;
                } else {
                    return false;
                }
            }
            if (lastM != len2 - 1) {
                if (len1 >= len2 - lastM - 1 && same(s.substring(len1 - len2 + lastM + 1, len1),p.substring(lastM + 1, len2))) {
                    end = lastM;
                } else {
                    return false;
                }
            }
            p = p.substring(start, end+1);
            s = s.substring(start, len1 - len2 + end+1);
            return matchReg(p, s);
        }
    }

    private int countNum(String p) {
        int result = 0;
        for (int i = 0; i < p.length(); i++) {
            if(p.charAt(i)!='*') {
                result++;
            }
        }
        return result;
    }

    private boolean matchReg(String p, String s) {
        String[] res = new String[p.length()];
        int k = 0;
        String cur = "";
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                res[k++] = cur;
                cur = "";
            } else {
                cur += p.charAt(i);
            }
        }
        return matchByArr(0, k - 1, res, s);
    }

    private int findMax(String[] res, int k) {
        int max = 0;
        int position = 0;
        for (int i = 0; i < k; i++) {
            if (res[i].length() > max) {
                max = res[i].length();
                position = i;
            }
        }
        return position;
    }

//    private void reverseArr(String[] res, int k) {
//        String[] u = new String[k];
//        int m = 0;
//        for (int i = k - 1; i >= 0; i--) {
//            u[m++] = res[i];
//        }
//        for (int i = 0; i < k; i++) {
//            res[i] = u[i];
//        }
//    }
//
//    private String reverse(String s) {
//        String p = "";
//        for (int i = s.length() - 1; i >= 0; i--) {
//            p += s.charAt(i);
//        }
//        return p;
//    }


    private boolean matchByArr(int g, int k, String[] res, String s) {
        int len1 = s.length();
        String cur = res[g];
        int len2 = cur.length();
        int min = 0;
        for (int j = 0; j <= k; j++) {
            min += res[j].length();
        }
        if (len1 < min) {
            return false;
        }
        if (g == k) {
            for (int j = 0; j <= len1 - len2; j++) {
                if (same(s.substring(j, j + len2), cur)) {
                    return true;
                }
            }
            return false;
        }

        int max = findMax(res, k+1);
        cur = res[max];
        len2 = cur.length();
        if (max == 0) {
            String[] res1 = new String[k];
            for (int i = 0; i < k; i++) {
                res1[i] = res[i+1];
            }
            for (int j = 0; j <= len1 - len2; j++) {
                if (same(s.substring(j, j + len2), cur)) {
                    boolean c = matchByArr(g,k-1,res1,s.substring(j+len2,len1));
                    if(c==true){
                        return true;
                    }
                }
            }
            return false;
        }
        if (max == k) {
            String[] res2 = new String[k];
            for (int i = 0; i < k; i++) {
                res2[i] = res[i];
            }
            for (int i = 0; i <= len1 - len2; i++) {
                if(same(s.substring(i,i+len2),cur)) {
                    boolean c = matchByArr(g,k-1,res2,s.substring(0,i));
                    if(c==true){
                        return true;
                    }
                }
            }
            return false;
        }
        String maxString = res[max];
        String[] res1 = new String[max];
        for (int i = 0; i < max; i++) {
            res1[i] = res[i];
        }
        String[] res2 = new String[k - max];
        for (int i = max + 1; i <= k; i++) {
            res2[i - max - 1] = res[i];
        }
        len2 = maxString.length();
        if (len1 < len2) {
            return false;
        }
        for (int j = 0; j <= len1 - len2; j++) {
            if (same(s.substring(j, j + len2), maxString)) {
                boolean c = matchByArr(0, max - 1, res1, s.substring(0, j));
                boolean d = matchByArr(0, k - max - 1, res2, s.substring(j + len2, len1));
                if (c == true && d == true) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean same(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        if (len1 != len2) {
            return false;
        }
        for (int i = 0; i < len1; i++) {
            if (p.charAt(i) != '?' && p.charAt(i) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private String removeDuplicate(String p) {
        String s = "";
        if (p.length() == 0) {
            return p;
        }
        s += p.charAt(0);
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '*' && p.charAt(i - 1) == '*') {
                continue;
            }
            s += p.charAt(i);
        }
        return s;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String a = "aaabbbabbababaababbbbbabbaaaaabbbbaaaabaaaabbabbbaaababaaaabababbaababbaabbbbaabaabaababbbabaabbabbaaaaaabbbabaabaaabbbaabbabaabbbbabbabaababbbbbbbaaaaababaabbaaaabbabbaaaabbbbaabbaabbaababaabaabbbaab";
        String b = "******a****aa**a**aa**aa**ba**aba*aa*b*a*bb**a*****b*******bb******a*aa*bbba*a*ba***baa*a*abb***ab*ab";
        boolean result = new WildcardMatching().isMatch(a, b);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(result);
    }
}
