import com.wondersgroup.oms.api.openapi.common.Certificate;


import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class demo {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, -1);
        String date = sdf.format(c.getTime());
        System.out.println(date);
    }

    public static void operator(StringBuffer x, StringBuffer y) {
        x.append(y);
        y = x;
    }

    private static void jiami() throws Exception{
        String str = "F97x66mxEWDYtcXAYWQnMFZLhmFQgt8N";
        String timesss = String.valueOf(System.currentTimeMillis());
        System.out.println(timesss);
        Certificate cert = new Certificate
                .CertificateBuilder()
                .setAccessKey(str)
                .setSecretKey("R1ElHyMG")
                .setCharset(StandardCharsets.UTF_8)
                .setRequestNonce("123123")
                .setRequestTimestamp(timesss)
                .builder();

        LinkedHashMap<String, String> param = new LinkedHashMap<>();
        param.put("posOutSn","123123");
        param.put("orderSn","123123123");
        param.put("result","success");
        param.put("storeCode","123");

        String sign = cert.getSign(param);
        System.out.println(sign);
    }

    private static void demo() throws ParseException {

        List<UserVo> userVos = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            UserVo userVo = new UserVo();
            userVo.setName("hqh");
            userVo.setSex("boy");
            userVo.setAge(18);
            int index = userVos.indexOf(userVo);
            userVo.setNum(1);
            if (index != -1) {
                userVo.setNum(userVos.get(index).getNum() + 1);
                userVos.remove(userVos.get(index));
            }else {

            }
            userVos.add(userVo);
        }



        for (UserVo u : userVos) {
            System.out.println(u.toString());
        }

    }

    public static void timeStampToString() {

        String t = "1578036577205";
        Long timestamp = Long.valueOf(t);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(timestamp));
    }

    public static void stack() {
        Stack stack = new Stack();
        stack.push("1");//入栈
        stack.push("2");
        stack.push("3");


        System.out.println(stack.peek());//查看栈顶
        System.out.println(stack.pop());//出栈
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }


    public static void doubleStr() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            String st1 = sc.nextLine();
            if (st1.equals("quit")) {
                System.out.println("已退出");
                break;
            }
            String[] a = st1.split("");
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < a.length; i++) {
                String s2 = a[i];
                s2 = s2 + s2;
                result.append(s2);
            }
            System.out.println(result);
        }
    }
}
