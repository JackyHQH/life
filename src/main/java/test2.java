import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test2 {


    public static void main(String[] args) {
        Set<String> strings = new HashSet<>();
        List<String> string2s = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < 10000 ; i++) {
            strings.add(i*2+"");
            string2s.add(i*2+"");
        }

        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 7000; i++) {
            if(strings.contains(i*3+"1")){
                count1++;
                System.out.println("set-"+count1);
            };
        }
        long t2 = System.currentTimeMillis();
//        Set<String> string3s = new HashSet<>(string2s);
        long t3 = System.currentTimeMillis();


        for (int i = 0; i < 7000; i++) {
            if(string2s.contains(i*3+"")){
                count2++;
                System.out.println("list-"+count2);
            };
        }

        System.out.println(t2-t1+"---"+count1);
        System.out.println(System.currentTimeMillis()-t2+"---"+count2);
        System.out.println("转换时间"+(t3-t2));
    }
}
