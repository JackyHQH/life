import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Reflect {

    public static void main(String[] args) {
        UserVo userVo = new UserVo();
        userVo.setName("HQH");
        System.out.println(userVo.getName());

        try {
            Class clz = Class.forName("UserVo");
            Method setNameMethod = clz.getMethod("setName", String.class);
            Constructor constructor = clz.getConstructor();
            Object user = constructor.newInstance();
            setNameMethod.invoke(user,"DSYCBB");
            Method getNameMethod = clz.getMethod("getName");
            System.out.println(getNameMethod.invoke(user));
        }catch (Exception e){

        }



    }
}
