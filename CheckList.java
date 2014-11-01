import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 14-11-1.
 */
public class CheckList {
    public static void main(String[] args) {
        String s = "hello";
        List<String> strs = new ArrayList<String>();
        strs.add(s);
        s = "hey"; //if i contain object;
        for(String key : strs) {
            System.out.println(key);
        }

        List<List<String>> result = new ArrayList<List<String>>();
        result.add(strs);
        strs.add("himan");  //it changed just reference to the object
        for(String key : result.get(0)) {
            System.out.println(key);
        }


    }
}
