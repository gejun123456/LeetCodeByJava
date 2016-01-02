package simple;

/**
 * Created by bruce on 14-12-8.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int m = x;
        int u = 0;
        while (m > 0) {
            u = u * 10 + m % 10;
            m = m/10;
        }
        int z = u^x;
        if(z!=0) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        int x = 12;
        int y = 121;
        boolean b = new PalindromeNumber().isPalindrome(x);
        System.out.println(b);
        b = new PalindromeNumber().isPalindrome(y);
        System.out.println(b);
    }
}
