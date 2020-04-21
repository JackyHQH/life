
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class test {

    public static void main(String[] args) throws Exception {

        HashMap map = new HashMap();
        List<String> lists = new ArrayList<>();
        lists.add("1");
        lists.add("2");
        lists.add("3");
        lists.add("4");
        List<String> lists2 = new ArrayList<>();
        lists2.addAll(lists);
        map.put("can",lists2);
        lists.add("5");

        System.out.println(map.get("can"));


    }
}
