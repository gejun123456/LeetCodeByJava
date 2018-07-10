package leetcode;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class EncodeUrl {

    private static String HTTP_URL_PREFIX = "http://tinyurl.com/";


    private static Map<String, String> maps = new HashMap<>();

    private static Map<String, String> shortToLongMap = new HashMap<>();

    private static String preUrl = "1";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (maps.containsKey(longUrl)) {
            return maps.get(longUrl);
        }
        String shortUrl = calcute(preUrl);
        preUrl = shortUrl;
        String finalShortUrl = HTTP_URL_PREFIX + shortUrl;
        maps.put(longUrl, finalShortUrl);
        shortToLongMap.put(finalShortUrl, longUrl);
        return finalShortUrl;
    }

    private String calcute(String preUrl) {
        int lastIndex = preUrl.length() - 1;
        while (lastIndex >= 0 && preUrl.charAt(lastIndex) == 'z') {
            lastIndex = lastIndex - 1;
        }

        if (lastIndex == -1) {
            StringBuilder ss = new StringBuilder();
            for (int i = 0; i < preUrl.length(); i++) {
                ss.append("1");
            }
            ss.append("1");
            return ss.toString();
        }

        char c = preUrl.charAt(lastIndex);

        StringBuilder s=  new StringBuilder();
        if(lastIndex>=1){
            s.append(preUrl.substring(0,lastIndex-1));
        }
        s.append(addOneForChar(c));
        if(lastIndex<preUrl.length()-1){
            s.append(preUrl.substring(lastIndex+1));
        }
        return s.toString();

    }

    private char addOneForChar(char c) {
        if (c >= '1' && c < '9') {
            int i = c + 1;
            return (char) i;
        }
        if (c == '9') {
            return 'a';
        }

        int s = c + 1;
        return (char) s;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if(shortToLongMap.containsKey(shortUrl)){
            return shortToLongMap.get(shortUrl);
        }
        throw new RuntimeException("short url not exist");
    }


    @Test
    public void testFun(){
        System.out.println(encode("https://leetcode.com/problems/design-tinyurl"));
        System.out.println(encode("https://leetcode.com/problems/design-tinyur2"));
        System.out.println(encode("https://leetcode.com/problems/design-tinyur3"));
        System.out.println(encode("https://leetcode.com/problems/design-tinyur5"));
        System.out.println(encode("https://leetcode.com/problems/design-tinyu7"));
        System.out.println(encode("https://leetcode.com/problems/design-tinyu7"));
        System.out.println(encode("https://leetcode.com/problems/design-tinyu7"));System.out.println(encode("https://leetcode.com/problems/design-tinyu7"));System.out.println(encode("https://leetcode.com/problems/design-tinyu7"));System.out.println(encode("https://leetcode.com/problems/design-tinyu7"));

        System.out.println(encode("https://leetcode.com/problems/design-tinyu7"));System.out.println(encode("https://leetcode.com/problems/design-tinyu7"));System.out.println(encode("https://leetcode.com/problems/design-tinyu7"));System.out.println(encode("https://leetcode.com/problems/design-tinyu7"));

        System.out.println(encode("https://leetcode.com/problems/design-tinyu7"));System.out.println(encode("https://leetcode.com/problems/design-tinyu7"));System.out.println(encode("https://leetcode.com/problems/design-tinyu7"));System.out.println(encode("https://leetcode.com/problems/design-tinyu7"));

        System.out.println(encode("https://leetcode.com/problems/design-tinyu7"));System.out.println(encode("https://leetcode.com/problems/design-tinyu7"));System.out.println(encode("https://leetcode.com/problems/design-tinyu7"));System.out.println(encode("https://leetcode.com/problems/design-tinyu7"));

        System.out.println(encode("https://leetcode.com/problems/design-tinyu7"));System.out.println(encode("https://leetcode.com/problems/design-tinyu7"));System.out.println(encode("https://leetcode.com/problems/design-tinyu7"));System.out.println(encode("https://leetcode.com/problems/design-tinyu7"));

        System.out.println(encode("https://leetcode.com/problems/design-tinyu7"));System.out.println(encode("https://leetcode.com/problems/design-tinyu7"));System.out.println(encode("https://leetcode.com/problems/design-tinyu7"));System.out.println(encode("https://leetcode.com/problems/design-tinyu7"));

        System.out.println(encode("https://leetcode.com/problems/design-tinyu7"));System.out.println(encode("https://leetcode.com/problems/design-tinyu7"));System.out.println(encode("https://leetcode.com/problems/design-tinyu7"));System.out.println(encode("https://leetcode.com/problems/design-tinyu7"));


    }
}
