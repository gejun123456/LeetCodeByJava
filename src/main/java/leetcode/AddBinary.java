package leetcode;

/**
 * Created by bruce on 14-12-13.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        String result = "";
        int len1 = a.length();
        int len2 = b.length();
        if (len1 >= len2) {
            return getString(a, b, result, len1, len2);
        } else {
            return getString(b,a,result,len2,len1);
        }
    }

    private String getString(String a, String b, String result, int len1, int len2) {
        int c = 0;
        int index = 0;
        char[] res = new char[len1 + 1];
        for (int i = 0; i < len2; i++) {
            if (a.charAt(len1 - i - 1) == '0') {
                if (b.charAt(len2 - i - 1) == '0') {
                    if (c == 0) {
                        res[index++] = '0';
                    } else {
                        res[index++] = '1';
                        c = 0;
                    }

                } else {
                    if (c == 0) {
                        res[index++] = '1';
                    } else {
                        res[index++] = '0';
                        c = 1;
                    }
                }
            } else {
                if (b.charAt(len2 - i - 1) == '0') {
                    if (c == 0) {
                        res[index++] = '1';
                    } else {
                        res[index++] = '0';
                        c = 1;
                    }
                } else {
                    if (c == 0) {
                        res[index++] = '0';
                        c = 1;
                    } else {
                        res[index++] = '1';
                        c = 1;
                    }
                }
            }
        }
        for (int i = len1 - len2-1; i >= 0; i--) {
            if (c == 0) {
                res[index++] = a.charAt(i);
            } else {
                if (a.charAt(i) == '0') {
                    res[index++] = '1';
                    c = 0;
                } else {
                    res[index++] = '0';
                    c = 1;
                }
            }
        }
        if (c == 1) {
            res[index++] = '1';
        }
        for (int i = index - 1; i >= 0; i--) {
            result += res[i];
        }
        return result;
    }

    public static void main(String[] args) {
        String c = new AddBinary().addBinary("11", "1");
        System.out.printf(c);
    }
}
