package jpaparse;

import jpaparse.parser.DeleteParse;
import jpaparse.parser.FindParser;
import jpaparse.parser.UpdateParser;
import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by bruce.ge on 2016/12/4.
 */
public class QueryParser {
    /**
     * Parse methodname in dao, and generate the mybatis xml string.
     *
     * @param methodName the method name
     * @return the string
     */
    public static String parse(String methodName, List<String> props) {
        methodName = methodName.toLowerCase();
        Collections.sort(props, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        if (methodName.startsWith("find")) {
            //user find parser to parse.
            return FindParser.parse(methodName, props);
        } else if (methodName.startsWith("update")) {
            return UpdateParser.parse(methodName, props);
        } else if (methodName.startsWith("delete")) {
            return DeleteParse.parse(methodName, props);
        }
        throw new ParseException("method name not start with find or update or delete");
    }


    //test more than expected.
    public static void main(String[] args) {
        //make it true;
        List<String> props = new ArrayList<String>();
        props.add("username");
        props.add("passworld");
        Assertions.assertThat(parse("findByUserName", props)).isEqualTo("select * from user where username = {0}");
        Assertions.assertThat(parse("findByUserNameAndPassword", props)).isEqualTo("select * from user where username = {0} and password = {1}");
        Assertions.assertThat(parse("findIdByUserNameAndPassword", props)).isEqualTo("select id from user where username = {0} and password = {1}");
        Assertions.assertThat(parse("findByUserNameOrPassword", props)).isEqualTo("select * from user where username = {0} or password = {1}");
        Assertions.assertThat(parse("findByAgeBetween", props)).isEqualTo("select * from user where age >= {0} and age <= {1}");
        Assertions.assertThat(parse("findByUserNameLike", props)).isEqualTo("select * from user where username like {0}");
        Assertions.assertThat(parse("findByAgeLessThan", props)).isEqualTo("select * from user where age <= {0}");
        Assertions.assertThat(parse("findByAgeGreaterThan", props)).isEqualTo("select * from user where age >={0}");
        Assertions.assertThat(parse("findByUserNameIsNotNull", props)).isEqualTo("select * from user where username is not null");
        Assertions.assertThat(parse("findByUserNameIsNull", props)).isEqualTo("select * from user where username is null");
        Assertions.assertThat(parse("findByUserNameNot", props)).isEqualTo("select * from user where username != {0}");
        Assertions.assertThat(parse("findByAgeIn", props)).isEqualTo("select * from user where username in {0}");
        Assertions.assertThat(parse("findByUserNameOrderById", props)).isEqualTo("select * from user where username = {0} order by id");
        Assertions.assertThat(parse("findByUserNameOrderByIdDesc", props)).isEqualTo("select * from user where username = {0} order by id desc");
        Assertions.assertThat(parse("findIdAndUserNameByUserNameOrderByIdDesc", props)).isEqualTo("select id,username from user where username = {0} order by id desc");
    }


}
