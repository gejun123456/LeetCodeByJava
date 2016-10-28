package twoZeroOneSix.compileBook;

/**
 * Created by bruce.ge on 2016/10/27.
 */
public class Token {
    private String value;

    private TokenType tokenType;

    public Token(String value,TokenType tokenType){
        this.value= value;
        this.tokenType=tokenType;
    }
}
