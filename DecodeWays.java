/**
 * Created by bruce on 14-11-19.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            if (s.charAt(0) == '0') {
                return 0;
            } else {
                return 1;
            }
        }
        int[] res = new int[len];
        char last = s.charAt(len - 1);
        char lastToOne = s.charAt(len - 2);
        if (last == '0') {
            res[0] = 0;
        } else {
            res[0] = 1;
        }
        if (lastToOne == '0') {
            res[1] = 0;
        } else if (lastToOne == '1' || (lastToOne == '2' && last <= '6')) {
            res[1] = 1 + res[0];
        } else {
            res[1] = res[0];
        }
        for (int i = 2; i < len; i++) {
            char c = s.charAt(len - i - 1);
            char next = s.charAt(len - i);
            if (c == '0') {
                res[i] = 0;
            } else if (c == '1' || (c == '2' && next <= '6')) {
                res[i] = res[i - 2] + res[i - 1];
            } else {
                res[i] = res[i - 1];
            }
        }
        return res[len - 1];
    }


    // the function   a[0][s] = a[2][s] + a[1][s];  a[1][s] = a[3][s] + a[2][s];  a[s-2][s];
//                a[0][s] = a[1][s];

//    user array to judge    a[0] = 代表为最后的一个数的可能性 a[1] 进行判断

    public static void main(String[] args) {
        DecodeWays de = new DecodeWays();
        int result = de.numDecodings("9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253");
        System.out.println(result);

    }
}
