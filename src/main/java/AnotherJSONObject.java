import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class AnotherJSONObject extends JSONObject{

    @Autowired
    private Map<String, Object> map;

    @Override
    public Object put(String key, Object value) {
        this.map.put("key", "canm");
        return this.map.put(key, value);
    }

}
