package code_2016.regexImplementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by bruce.ge on 2016/10/28.
 */

/*
*将正则表达式转换为带有并操作符的表达式
*  "* ? +"为 此处只是先带有 * | ( 这些操作服
*
* */
public class RegexMatchToBack {
    public static String addAnd(String regex){
        StringBuilder andRegex = new StringBuilder();
        //remove tab out and between.
        andRegex.append(regex.charAt(0));
        char before = regex.charAt(0);
        for (int i = 1; i < regex.length(); i++) {
            char cur = regex.charAt(i);
            // 当前位是开始符 且前一个是结束符
            if(Character.isLetterOrDigit(cur)||cur=='('){
                if(before==')'||Character.isLetterOrDigit(before)||before=='*'){
                    andRegex.append("-");
                }
            }
            andRegex.append(cur);
            before=cur;
        }
        return andRegex.toString();
    }

    //all text has passed. next step is to build with the NFA to continue.
    //support with * | or anything that can be converted to such pattern. with ( to use with.
    public static String getBackRegex(String regex){
        String midWithAnd=addAnd(regex);
        Map<Character,Integer> rightMap = new HashMap<Character, Integer>(){{
            put('|',1);
            put('-',3);
            put('*',5);
            put('(',0);
        }};
        Map<Character,Integer> leftMap= new HashMap<Character, Integer>(){{
            put('|',2);
            put('-',4);
            put('*',6);
            put('(',7);
            put(')',0);
        }};
        Stack<String> letterStack = new Stack<String>();
        Stack<Character> operatorStack = new Stack<Character>();
        for (int i = 0; i < midWithAnd.length(); i++) {
            char c = midWithAnd.charAt(i);
            if(!leftMap.containsKey(c)){
                letterStack.push(c+"");
            } else {
                if(operatorStack.isEmpty()){
                    operatorStack.push(c);
                }else if(leftMap.get(c)>rightMap.get(operatorStack.peek())){
                    operatorStack.push(c);
                } else if(leftMap.get(c)<rightMap.get(operatorStack.peek())){
                    while(!operatorStack.isEmpty()&&leftMap.get(c)<rightMap.get(operatorStack.peek())){
                        char operator = operatorStack.pop();
                        if(operator=='-'||operator=='|'){
                            String a = letterStack.pop();
                            String b=  letterStack.pop();
                            letterStack.push(a+b+operator);
                        } else if(operator=='*'){
                            String a = letterStack.pop();
                            letterStack.push(a+operator);
                        }
                    }
                    if(operatorStack.isEmpty()){
                        operatorStack.push(c);
                        //说明是)匹配到了
                    } else if(leftMap.get(c)==rightMap.get(operatorStack.peek())){
                        operatorStack.pop();
                    } else {
                        operatorStack.push(c);
                    }
                } else {
                    operatorStack.pop();
                }
            }

        }
        while(!operatorStack.isEmpty()){
            char operator = operatorStack.pop();
            if(operator=='-'||operator=='|'){
                String a = letterStack.pop();
                String b=  letterStack.pop();
                letterStack.push(a+b+operator);
            } else if(operator=='*'){
                String a = letterStack.pop();
                letterStack.push(a+operator);
            }
        }
        return letterStack.pop();
    }


    public static void main(String[] args) {
        assertThat("a-b").isEqualTo(addAnd("ab"));
        assertThat("a-b|c-d").isEqualTo(addAnd("ab|cd"));
        assertThat("(a-c|b)-(d|e-a)").isEqualTo(addAnd("(ac|b)(d|ea)"));
        assertThat("a|b-c*").isEqualTo(addAnd("a|bc*"));
        assertThat("a|b-(b|c*)").isEqualTo(addAnd("a|b(b|c*)"));
        assertThat("a-b-c|e").isEqualTo(addAnd("abc|e"));
        assertThat("((a-b|c-d))-(a|b)").isEqualTo(addAnd("((ab|cd))(a|b)"));
        assertThat("(a-b-c-d)-(e-f-g)").isEqualTo(addAnd("(abcd)(efg)"));
        assertThat("a-b-c-d-(e-f-g)").isEqualTo(addAnd("abcd(efg)"));
        assertThat("a-b-c-d-e-f-g").isEqualTo(addAnd("abcdefg"));

        //mid to back test
        assertThat("ba-").isEqualTo(getBackRegex("ab"));
        assertThat("dc-ba-|").isEqualTo(getBackRegex("ab|cd"));
        assertThat("ae-d|bca-|-").isEqualTo(getBackRegex("(ac|b)(d|ea)"));
        assertThat("c*b-a|").isEqualTo(getBackRegex("a|bc*"));
        assertThat("c*b|b-a|").isEqualTo(getBackRegex("a|b(b|c*)"));
        assertThat("ecb-a-|").isEqualTo(getBackRegex("abc|e"));
        assertThat("ba|dc-ba-|-").isEqualTo(getBackRegex("((ab|cd))(a|b)"));
        assertThat("gf-e-dc-b-a--").isEqualTo(getBackRegex("(abcd)(efg)"));

    }
}
