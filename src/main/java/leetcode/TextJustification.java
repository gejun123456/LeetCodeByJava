package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 14-10-31.
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int L) {
        int size = 0;
        List<String> result = new ArrayList<String>();
        List<String> current = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            if (i == words.length - 1) {
                size = size + words[i].length();
                if (size <= L) {
                    String str = "";
                    current.add(words[i]);
                    for (String s : current) {
                        if(s!=current.get(current.size()-1))
                        str += s + " ";
                        else
                            str+=s;
                    }
                    for (int mi = str.length(); mi < L; mi++) {
                        str += " ";
                    }
                    result.add(str);
                } else {
                    String str = convert(current,L);
                    result.add(str);
                    String lastStr = words[i];
                    for (int j = words[i].length(); j < L; j++) {
                        lastStr += " ";
                    }
                    result.add(lastStr);
                }
            } else {
                size = size + words[i].length();
                if (size <= L) {
                    current.add(words[i]);
                    size = size + 1;
                } else {
                    String str = convert(current, L);
                    result.add(str);
                    size = words[i].length()+1;
                    current = new ArrayList<String>();
                    current.add(words[i]);
                }
            }
        }
        return result;
    }

    private String convert(List<String> current, int l) {
        String str = "";
        int len = current.size();
        int total = 0;
        for (String s : current) {
            total += s.length();
        }
        int p = l - total;
        int q = len;
        if (current.size() == 1) {
            String lastStr = current.get(0);
            for (int j = lastStr.length(); j < l; j++) {
                lastStr += " ";
            }
            return lastStr;
        }
        for (String s : current) {
            str += s;
            if (s != current.get(len - 1)) {
                int blank;
                q = q - 1;
                if (p % q != 0) {
                    blank = p / q + 1;
                } else
                    blank = p / q;
                for (int i = 0; i < blank; i++) {
                    str += " ";
                }
                p = p - blank;
            }
        }
        return str;
    }

    public static void main(String[] args) {
        List<String> result = new ArrayList<String>();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] word2 = {""};
        String[] word3 = {"Listen", "to", "many,", "speak", "to", "a", "few."};
        TextJustification textJustification = new TextJustification();
        result = textJustification.fullJustify(words, 14);
        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s.length());
            System.out.println(s);
        }
    }
}
