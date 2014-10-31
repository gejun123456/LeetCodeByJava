/**
 * Created by Administrator on 14-10-26.
 */
public class ReverseWordsinaString {
    public String reverseWords(String s) {
        if(s.equals("")){
            return s;
        }
        String removedStr = removeSpaces(s);
        if (removedStr.equals("")) {
            return removedStr;
        } else {
            String result = reverse(removedStr);
            return result;
        }
    }

    private String reverse(String removedStr) {
        String[] res = new String[10000];
        String result = "";
        int i = 0;
        int p = 0;
        while (i < removedStr.length()) {
            while (i < removedStr.length() && removedStr.charAt(i) == ' ') {
                i++;
            }
            if (i < removedStr.length() && removedStr.charAt(i) != ' ') {
                String s = "";
                while (i < removedStr.length() && removedStr.charAt(i) != ' ') {
                    s += removedStr.charAt(i);
                    i++;
                }
                res[p] = s;
                p++;
            }
        }
        for (i = res.length - 1; i >= 0; i--) {
            if (res[i] != null) {
                if (i != 0) {
                    result += res[i] + " ";
                } else
                    result += res[i];
            }
        }
        return result;
    }

    private String removeSpaces(String s) {
        int first = 0;
        int last = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                first = i;
                break;
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                last = i;
                break;
            }
        }
        if (first > last) {
            return "";
        } else {
            return s.substring(first, last + 1);
        }
    }

    public static void main(String[] args) {
        ReverseWordsinaString reverseWordsinaString = new ReverseWordsinaString();
        System.out.println(reverseWordsinaString.reverseWords(""));
    }
}
