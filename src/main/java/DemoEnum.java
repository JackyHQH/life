import java.util.function.Function;
import java.util.function.Supplier;

public enum DemoEnum {



    AGE((key)-> key+"ageStr"),
    NAME((key)-> key+"nameStr");

    private final Function<String,String> f;

    DemoEnum(Function<String,String> fun) {
        f = fun;
    }

    public String toApply(String name){
        return f.apply(name);
    }

}
