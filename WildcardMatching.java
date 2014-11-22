/**
 * Created by bruce on 14-11-22.
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        p = removeDuplicate(p);
        int noDuplicat = cal(p);
        return matchReg(s, p, noDuplicat);
    }

    private int cal(String p) {
        int result = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                result++;
            }
        }
        return result;
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

    private boolean matchReg(String s, String p, int noDuplicat) {
        int len2 = p.length();
        int len1 = s.length();
        if (len1 < noDuplicat) {
            return false;
        }
        if (len2 == 0) {
            if (len1 == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            char x = p.charAt(0);
            if (x == '?') {
                if (len1 == 0) {
                    return false;
                } else {
                    return matchReg(subTime(s, 1, len1), subTime(p, 1, len2), noDuplicat - 1);
                }
            } else if (x == '*') {
                if (noDuplicat == 0) {
                    return true;
                }
                for (int i = 0; i <= len1 - noDuplicat; i++) {
                    if (len2 > 1) {
                        if (p.charAt(1) == '?') {
                            boolean c = matchReg(s.substring(i, len1), subTime(p,1,len2), noDuplicat - 1);
                            if (c == true) {
                                return true;
                            }
                        } else {
                            int g = 1;
                            int k = -1;
                            int m = i;
                            while (g < p.length() && m < s.length() && p.charAt(g) != '*' && p.charAt(g) != '?') {
                                if (s.charAt(m++) != p.charAt(g++)) {
                                    k = 0;
                                    break;
                                }
                            }
                            if (k == 0) {
                                continue;
                            } else {
                                boolean c = matchReg(subTime(s, m, len1), subTime(p, g, len2), noDuplicat - m - i);
                                if (c == true) {
                                    return true;
                                }
                            }
                        }
                    } else {
                        return true;
                    }

                }
                return false;
            } else {
                if (len1 == 0) {
                    return false;
                } else {
                    int g = 0;
                    int m = 0;
                    while (g < p.length() && p.charAt(g) != '*' && p.charAt(g) != '?') {
                        if (s.charAt(m++) != p.charAt(g++)) {
                            return false;
                        }
                    }
                    return matchReg(subTime(s, m, len1), subTime(p, g, len2), noDuplicat - m - 0);
                }

            }
        }
    }


    private String subTime(String p, int g, int len2) {
        if (g < len2) {
            return p.substring(g, len2);
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        String a = "bbaaaabaaaaabbabbabbabbababaabababaabbabaaabbaababababbabaabbabbbbbbaaaaaabaabbbbbabbbbabbabababaaaaa";
        String b = "******aa*bbb*aa*a*bb*ab***bbba*a*babaab*b*aa*a****";
        boolean result = new WildcardMatching().isMatch(a, b);
        System.out.println(result);
    }
}
