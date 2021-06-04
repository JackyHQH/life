import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class demo2 {

    public static void main(String[] args) {
        List<UserVo> li = new ArrayList<>();
        List<UserVo> li2 = new ArrayList<>();
        UserVo userVo = new UserVo();
        userVo.setName("A");
        userVo.setAge(123);
        li.add(userVo);
        li2.add(userVo);
        userVo = new UserVo();
        userVo.setName("B");
        userVo.setAge(1223);
        li.add(userVo);
        li2.add(userVo);

//        userVo = new UserVo();
//        userVo.setName("B");
//        userVo.setAge(11);
//        li2.add(userVo);
//
//        userVo = new UserVo();
//        userVo.setName("C");
//        userVo.setAge(1225);
//        li2.add(userVo);

        System.out.println(li);
        System.out.println(li2);
        List<UserVo> li3 = li2.stream().filter(str-> li.stream().noneMatch(st -> str.getName().equals(st.getName()))).collect(Collectors.toList());
        System.out.println(li3);
        ;
    }

}
