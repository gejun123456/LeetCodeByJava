package test;

import java.util.ArrayList;
import java.util.List;

///**
//* Created by bruce on 14-11-23.
//*/
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        p = removeDuplicate(p);
        int len1 = s.length();
        int len2 = p.length();
        int firstM = -1;
        int lastM = len2;
        for (int i = 0; i < len2; i++) {
            if (p.charAt(i) == '*') {
                firstM = i;
                break;
            }
        }
        for (int i = len2 - 1; i >= 0; i--) {
            if (p.charAt(i) == '*') {
                lastM = i;
                break;
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
                if (firstM > 0 && firstM < len2) {
                    if (len1 >= firstM && len1 >= len2 - 1 && same(p.substring(0, firstM), s.substring(0, firstM)) && same(p.substring(firstM + 1, len2), s.substring(len1 - len2 + firstM + 1, len1))) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (firstM == 0) {
                    if (len1 >= len2 - firstM - 1 && same(p.substring(firstM + 1, len2), s.substring(len1 - len2 + firstM + 1, len1))) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    if (len1 >= firstM && same(p.substring(0, firstM), s.substring(0, firstM))) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        } else {
            int start = 0;
            int end = len2;
            if (firstM != 0) {
                if (len1 >= firstM && same(p.substring(0, firstM), s.substring(0, firstM))) {
                    start = firstM;
                } else {
                    return false;
                }
            }
            if (lastM != len2 - 1) {
                if (len1 >= len2 - firstM - 1 && same(p.substring(firstM + 1, len2), s.substring(len1 - len2 + firstM + 1, len1))) {
                    end = lastM;
                } else {
                    return false;
                }
            }
            p = p.substring(start, end);
            s = s.substring(start, len1 - len2 + end);
            return matchReg(p, s);
        }
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
        int max = findMax(res, k);
        if (max == 0) {
            return matchByArr(0, k - 1, res, s);
        }
        if (max == k - 1) {
            s = reverse(s);
            reverseArr(res, k);
            return matchByArr(0, k - 1, res, s);
        }
        String maxString = res[max];
        String[] res1 = new String[max];
        for (int i = 0; i < max; i++) {
            res1[i] = res[i];
        }
        String[] res2 = new String[k - max - 1];
        for (int i = max + 1; i < k; i++) {
            res2[i - max - 1] = res[i];
        }
        int len1 = s.length();
        int len2 = maxString.length();
        if (len1 < len2) {
            return false;
        }
        for (int j = 0; j <= len1 - len2; j++) {
            if (same(s.substring(j, j + len2), maxString)) {
                if (j + len2 < len1) {
                    boolean c = matchByArr(0, max - 1, res1, s.substring(0, j));
                    boolean d = matchByArr(0, k - max - 2, res2, s.substring(j + len2, len1));
                    if (c == true && d == true) {
                        return true;
                    }
                }
            }
        }
        return false;
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

    private void reverseArr(String[] res, int k) {
        String[] u = new String[k];
        int m = 0;
        for (int i = k - 1; i >= 0; i--) {
            u[m++] = res[i];
        }
        for (int i = 0; i < k; i++) {
            res[i] = u[i];
        }
    }

    private String reverse(String s) {
        String p = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            p += s.charAt(i);
        }
        return p;
    }


    private boolean matchByArr(int i, int k, String[] res, String s) {
        String cur = res[i];
        int len1 = s.length();
        int min = 0;
        for(int u = i+1;u<=k;u++) {
            min +=res[u].length();
        }
        if(len1<min) {
            return false;
        }
        int len2 = cur.length();
        if (i == k) {
            if (len1 >= len2 && same(s.substring(0, len2), cur)) {
                return true;
            } else {
                return false;
            }
        } else {
            if (len1 < len2) {
                return false;
            }
            for (int j = 0; j <= len1 - len2; j++) {
                if (same(s.substring(j, j + len2), cur)) {
                    if (j + len2 < len1) {
                        boolean c = matchByArr(i + 1, k, res, s.substring(j + len2, len1));
                        if (c == true) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
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
        String a = "aabbbbaababbabababaabbbbabbabbaabbbabbbabaabbaaaababababbababbabbbbabaaabaaabaabbaaaabbbbabaaabbbbbabbbaabbbbbabaabababaaabaaababaababbaaabaabbabaababbabababaaababbabbabaabbbbabbbbabaabbaababaaabababbab";
        String b = "a*b*a*b*aaaa*abaaa**b*a***b*a*bb****ba*ba*b******a********a**baba*ab***a***bbba*b**a*b*ba*a*aaaa*ab**";
        boolean result = new WildcardMatching().isMatch(a, b);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(result);
    }
}
