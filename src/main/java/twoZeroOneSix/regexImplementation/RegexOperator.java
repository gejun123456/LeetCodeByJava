package twoZeroOneSix.regexImplementation;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bruce.ge on 2016/10/28.
 */
public class RegexOperator {
    private static Set<Character> linkOperator = new HashSet<Character>(){{
        add('|');
        add('-');
    }};

    private static Set<Character> singleOperator = new HashSet<Character>(){{
        add('*');
    }};

    public static  boolean isOperator(char c){
        return linkOperator.contains(c)||singleOperator.contains(c);
    }

    public static  boolean isLinkOperator(char c){
        return linkOperator.contains(c);
    }

    public static  boolean isSingleOperator(char c){
        return singleOperator.contains(c);
    }
}
