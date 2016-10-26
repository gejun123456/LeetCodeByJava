package twoZeroOneSix.fortyfour;

/**
 * Created by bruce.ge on 2016/10/26.
 */
public class KMPWildCardMatch {
    private static final int NOT_FOUND = -1;
    private static char WILDCARD = '?';

    public static int findMatch(String source, String pattern)
    {
        int match = NOT_FOUND;
        int source_ix = 1, pattern_ix = 1;
        int source_len = source.length(), pattern_len = pattern.length();
        int[] next = getNext(pattern);

        while (source_ix < source_len && pattern_ix < pattern_len)
        {
            if (pattern_ix == 0 || source.charAt(source_ix) == pattern.charAt(pattern_ix)
                    || pattern.charAt(pattern_ix) == WILDCARD)
            {
                source_ix++; pattern_ix++;
            }
            else
            {
                pattern_ix = next[pattern_ix-1];
            }
        }

        if (pattern_ix == pattern_len)
        {
            match = source_ix - pattern_len;
        }

        return match;
    }

    public static int[] getNext(String pattern)
    {
        int[] next = new int[pattern.length()];
        int i = 2, j = 0;

        next[0] = 0;

        while (i <= next.length)
        {
            if (pattern.charAt(i-1) == pattern.charAt(j)
                    || pattern.charAt(i-1) == WILDCARD || pattern.charAt(j) == WILDCARD)
            {
                next[i-1] = ++j;
                i++;
            }
            else if (j == 0)
            {
                next[i-1] = 0;
                i++;
            }
            else
            {
                j = next[j-1];
            }
        }

        return next;
    }


    public static void main(String[] args) {
        System.out.println(findMatch("acbdafbdagbde","acbda?bde"));
    }


}
