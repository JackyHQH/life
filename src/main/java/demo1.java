import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class demo1 {
    private static final String SYMBOL = ".";

    public static void main(String[] args) {

        String c = "123123123123123123000.0";
        long t1 = System.currentTimeMillis();
        for (int j = 0; j < 1000; j++) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 500; i++) {
                list.add(c);
            }
            list.forEach(li-> list.forEach(demo1::filterZeroAndDecimal));
        }
        System.out.println(System.currentTimeMillis()-t1);
    }

    private static String filterZeroAndDecimal(String s) {
        if (StringUtils.isNotEmpty(s) && s.indexOf(SYMBOL) > 0) {
            //去掉多余的0
            s = s.replaceAll("0+?$", "");
            //去除0之后如最后一位是.则去掉 .
            s = s.replaceAll("[.]$", "");
        }
        return s;
    }
}
