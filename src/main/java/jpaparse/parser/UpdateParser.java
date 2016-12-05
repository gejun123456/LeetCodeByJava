package jpaparse.parser;

import jpaparse.KeyWordConstants;
import jpaparse.Term;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruce.ge on 2016/12/4.
 */
public class UpdateParser {

    private static String[] compareOp = {KeyWordConstants.BETWEEN, KeyWordConstants.GREATERTHAN, KeyWordConstants.LESSTHAN,
            KeyWordConstants.ISNOTNULL, KeyWordConstants.ISNULL, KeyWordConstants.NOTNULL, KeyWordConstants.NOTLIKE, KeyWordConstants.LIKE
            , KeyWordConstants.NOTIN, KeyWordConstants.NOT, KeyWordConstants.IN};

    public static String parse(String method, List<String> props, String tableName) {
        List<Term> terms = generateTerm(method, props);

        return "";
    }

    private static List<Term> generateTerm(String method, List<String> props) {
        //first go to match with update.
        List<Term> terms = new ArrayList<Term>();


        return terms;
    }
}
