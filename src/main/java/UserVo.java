import java.util.Objects;

public class UserVo {

    private String name;

    private String sex;

    private Integer age;

    private Integer num;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        System.out.println("sb");
        return "UserVo{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", num=" + num +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserVo userVo = (UserVo) o;
        return Objects.equals(name, userVo.name) &&
                Objects.equals(sex, userVo.sex) &&
                Objects.equals(age, userVo.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex, age);
    }
}
