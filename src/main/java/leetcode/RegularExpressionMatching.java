package leetcode;

/**
 * Created by bruce on 14-11-22.
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int len = p.length();
        if (len == 0 && s.length() != 0) {
            return false;
        }
        if (len == 0 && s.length() == 0) {
            return true;
        }
        int realCharLen = 0;
        int i = 0;
        for (i = 0; i < len; i++) {
            if (p.charAt(i) != '*') {
                realCharLen++;
            }
        }
        char[] arr = new char[realCharLen];
        boolean[] check = new boolean[realCharLen];
        int cur = 0;
        i = 0;
        while (i < len) {
            char a = p.charAt(i);
            arr[cur] = a;
            if ((i + 1) < len && p.charAt(i + 1) == '*') {
                check[cur] = true;
                i = i + 2;
            } else {
                check[cur] = false;
                i = i + 1;
            }
            cur++;
        }
        realCharLen = realCharLen - 1;
        boolean result = matchReg(s, 0, realCharLen, arr, check);
        return result;
    }

    private boolean matchReg(String s, int i, int realCharLen, char[] arr, boolean[] check) {
        char x = arr[i];
        int len = s.length();
        boolean y = check[i];
        if (i == realCharLen) {
            if (y == true) {
                if (len == 0) {
                    return true;
                } else {
                    if (x == '.') {
                        return true;
                    } else {
                        for (int j = 0; j < len; j++) {
                            if (s.charAt(j) != x) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
            } else {
                if (len == 1) {
                    if (x == '.') {
                        return true;
                    } else {
                        if (s.charAt(0) == x) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
        } else {
            if (y == false) {
                if (len == 0) {
                    return false;
                }
                if (x == '.') {
                    if (1 == len) {
                        return matchReg("", i + 1, realCharLen, arr, check);
                    } else {
                        return matchReg(s.substring(1, len), i + 1, realCharLen, arr, check);
                    }
                } else {
                    if (s.charAt(0) == x) {
                        if (1 == len) {
                            return matchReg("", i + 1, realCharLen, arr, check);
                        } else {
                            return matchReg(s.substring(1, len), i + 1, realCharLen, arr, check);
                        }
                    } else {
                        return false;
                    }
                }
            } else {
                if (x == '.') {
                    boolean c= matchReg("",i+1,realCharLen,arr,check);
                    if(c==true) {
                        return true;
                    }
                    for (int j = 0; j < len; j++) {
                        c = matchReg(s.substring(j, len), i + 1, realCharLen, arr, check);
                        if (c == true) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    boolean c = matchReg(s, i + 1, realCharLen, arr, check);
                    if (c == true) {
                        return true;
                    }
                    for (int j = 0; j < len; j++) {
                        if (s.charAt(j) == x) {
                            if (j + 1 < len) {
                                c = matchReg(s.substring(j + 1, len), i + 1, realCharLen, arr, check);
                                if (c == true) {
                                    return true;
                                }
                            } else {
                                c = matchReg("", i + 1, realCharLen, arr, check);
                                if (c == true) {
                                    return true;
                                }
                            }
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        String a = "aabcbcbcaccbcaabc";
        String b = ".*a*aa*.*b*.c*.*a*";
        boolean result = new RegularExpressionMatching().isMatch(a, b);
        System.out.println(result);
    }
}
