import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AnotherJSONObject extends JSONObject{
    public static  int i = 1;
    public static void main(String[] args) {

        ConcurrentHashMap<String, String> sqlCache =  new ConcurrentHashMap<>();
        String s = sqlCache.computeIfAbsent("name", (key) -> getsql("name"));
        String s1 = sqlCache.computeIfAbsent("name", (key) -> getsql("name"));
        String s2 = sqlCache.computeIfAbsent("name", (key) -> getsql("name"));
        String s3 = sqlCache.computeIfAbsent("name", (key) -> getsql("name"));
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }

    private static String getsql(String name ){
        System.out.println("laile");
        if (i==1){
            i++;
            return null;
        }
        return name+i;
    }

}
