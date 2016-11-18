package code_2016.compileBook;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruce.ge on 2016/10/27.
 */
public class GetCommaFromCode {

    public static List<Token> getTokensFromCode(String code){
        List<Token> tokens = new ArrayList<Token>();
        int start = 0;
        parseBase(start,code,tokens);
        return tokens;
    }

    private static void parseBase(int start, String code, List<Token> tokens) {
        int forward= start;
        while(start<code.length()&&isNoUse(code.charAt(start))){
            start++;
            forward++;
        }
        if(start==code.length()){
            return;
        }
        int state = 0;
        ParseMode mode = ParseMode.NONE;

        //every time it only parse one word
        while(forward<code.length()){
            char c = code.charAt(forward);
            forward++;
            switch (state){
                case 0:
                    if(isCoolStart(c)){
                        state=1;
                    } else if(c=='/'){
                        state=2;
                    } else {
                        state=100;
                    }
                    break;
                case 1:
                    if(c==' '){
                        Token token = new Token(code.substring(start,forward),TokenType.ID);
                        tokens.add(token);
                        //设置一个值来控制
                        mode=ParseMode.BASE;
                    } else if(c=='.'){
                        state=0;
                    } else if(c=='/'){
                        Token token = new Token(code.substring(start,forward),TokenType.ID);
                        tokens.add(token);
                        state=2;
                    } else if(coolsecond(c)){
                        state=1;
                    } else if(c=='('){
                        Token token = new Token(code.substring(start,forward),TokenType.ID);
                        tokens.add(token);
                        mode=ParseMode.BRACKET;
                    } else if(c=='{'){
                        Token token = new Token(code.substring(start,forward),TokenType.ID);
                        tokens.add(token);
                        mode=ParseMode.BIGBRACKET;
                    }
                    else {
                        state=100;
                    }
                    break;
                case 2:
                    if(c=='*'){
                        mode=ParseMode.COMMENT;
                    } else{
                        state=100;
                    }
                    break;
                case 100:
                    return;
            }
            if(mode!=ParseMode.NONE){
                break;
            }
        }

        switch (mode){
            case NONE:
                break;
            case BASE:
                parseBase(forward,code,tokens);
                break;
        }
    }

    private static boolean coolsecond(char c) {
        if(Character.isLetterOrDigit(c)||c=='$'||c=='_'){
            return true;
        }
        return false;
    }

    private static boolean isCoolStart(char c) {
        if(Character.isLetter(c)||c=='$'||c=='_'){
            return true;
        }
        return false;
    }

    private static boolean isNoUse(char c) {
        if(c==' '||c=='\n'){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String code="package code_2016.compileBook;\n" +
                "\n" +
                "/**\n" +
                " * Created by bruce.ge on 2016/10/27.\n" +
                " */\n" +
                "public class MarkCode {\n" +
                "    public static void main(String[] args) {\n" +
                "        /*hi you guys*/\n" +
                "        /* \"hi you guys\"*/\n" +
                "        System.out.println(\"/*hello*/\");\n" +
                "        System.out.println(/*hello*/\"hey\");\n" +
                "    }\n" +
                "}";
        //first get the most leetcode things done.

        String simple = "  hello   world ";
//        GsonUtils.printToGson(getTokensFromCode(code));
    }
}
