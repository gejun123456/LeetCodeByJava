package simple;

/**
 * Created by bruce on 14-11-23.
 */
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        int i = 0;
        String[] split = s.split(" ");
        if (split.length == 0) {
            return 0;
        }
        return split[split.length - 1].length();
    }

    public static void main(String[] args) {
        String a = "a";
        int result = new LengthofLastWord().lengthOfLastWord(a);
        System.out.println(result);
    }
}
