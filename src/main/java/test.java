
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class test {

    public static void main(String[] args) throws Exception {
        List<String> strings = new ArrayList<>();
        List<String> string2s = new ArrayList<>();
        List<String> string3s = new ArrayList<>();
        Set<String> string4s = null;

        for (int i = 0; i < 50000; i++) {
            strings.add(""+i*2);
        }
        for (int i = 0; i < 50000; i++) {
            string2s.add(""+i*3);
        }
        for (int i = 0; i < 50000; i++) {
            string4s.add(""+i*3);
        }
        Long l1 = System.currentTimeMillis();
        strings.forEach(str->{
            if(string2s.indexOf(str)!=-1){
                string3s.add(str);
            }
        });
        System.out.println(System.currentTimeMillis()-l1);
        System.out.println(string3s);
    }

    public static void test(List<String> outList){
        System.out.println(outList);
    }
}
