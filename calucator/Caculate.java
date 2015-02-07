package calucator;

import java.util.*;

/**
 * Created by bruce on 2/7/2015.
 */
public class Caculate {
    private static Map<Character, Integer> priority = new HashMap<Character, Integer>() {{
        put('+', 1);
        put('-', 1);
        put('*', 2);
        put('/', 2);
        put('(',3);
    }};

    private static Set<Character> numbers = new HashSet<Character>() {{
        add('0');
        add('1');
        add('2');
        add('3');
        add('4');
        add('5');
        add('6');
        add('7');
        add('8');
        add('9');
    }};


    public static double caculating(String input) {
        Stack<Character> operators = new Stack<Character>();
        List<Object> postFix = new ArrayList<Object>();
        String currentNum = "";
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if(cur==' ') {
                continue;
            }
            if (numbers.contains(cur)) {
                currentNum += cur;
            } else {
                if(currentNum!="") {
                    postFix.add(Integer.valueOf(currentNum));
                    currentNum = "";
                }
                if(priority.containsKey(cur)) {
                    if(operators.empty()) {
                        operators.push(cur);
                    } else {
                        if(priority.get(operators.peek())<priority.get(cur)||priority.get(cur)==3) {
                            operators.push(cur);
                        } else {
                            if(priority.get(operators.peek())==3) {
                                operators.push(cur);
                            } else {
                                postFix.add(operators.pop());
                                operators.push(cur);
                            }
                        }
                    }
                } else {
                         while(operators.peek()!='(') {
                        postFix.add(operators.peek());
                        operators.pop();
                    }
                    operators.pop();
                }

            }
        }
        if(currentNum!=null) {
            postFix.add(Integer.valueOf(currentNum));
        }
        while(!operators.empty()){
            Character s = operators.pop();
            postFix.add(s);
        }
        double result = countValue(postFix);
        return result;
    }

    private static double countValue(List<Object> postFix) {
        Stack<Integer> res = new Stack<Integer>();
        for(Object cur : postFix) {
            if(cur instanceof Integer) {
                res.push((Integer)cur);
            } else if(cur instanceof Character) {
                char c = (Character)cur;
                Integer two = res.pop();
                Integer one = res.pop();
                Integer midRes = 0;
                switch (c) {
                    case '+' :
                        midRes = one+two;
                        break;
                    case '-' :
                        midRes = one-two;
                        break;
                    case '*':
                        midRes = one*two;
                        break;
                    case '/':
                        midRes = one/two;
                        break;
                }
                res.push(midRes);
            }
        }
        return res.pop();
    }
}
