package Salary;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Salary2021 {
    public static void main(String[] args) throws Exception {
        List<Double> everyMoon = new ArrayList<>();
        //基本工资
        double basicSalary = 16000d;
        //扣除个人公积金
        double fund = basicSalary*0.07;
        //迭代绩效
        double extraSalary = basicSalary * 0.1;
        //每日工资
        double daySalary = basicSalary/21.75;


        //一月份无迭代绩效 工作日20天 个人公积金0.7
        everyMoon.add(daySalary*20-fund);

        //二月份基本工资-公积金+绩效
        everyMoon.add(basicSalary-fund+extraSalary);

        //三月份发了过年加班的工资 9天份的 无绩效
        everyMoon.add(basicSalary-fund+daySalary*9);

        //四月份涨薪4000 但是公积金还是涨薪前的
        basicSalary = basicSalary + 4000d;
        extraSalary = basicSalary * 0.1;
        everyMoon.add(basicSalary-fund+extraSalary);

        //五月份理论加班一天 双倍
        extraSalary = basicSalary * 0.175;
        everyMoon.add(basicSalary-fund+extraSalary);

        //六月份 理论上没有加班
        everyMoon.add(basicSalary-fund+extraSalary);

        //七月份 理论上没有加班
        everyMoon.add(basicSalary-fund+extraSalary);

        //八月份 理论上没有加班
        everyMoon.add(basicSalary-fund+extraSalary);

        //九月份 理论上没有加班
        everyMoon.add(basicSalary-fund+extraSalary);

        //十月份 理论上没有加班
        everyMoon.add(basicSalary-fund+extraSalary);

        //十一月份 理论上没有加班
        everyMoon.add(basicSalary-fund+extraSalary);

        //十二月份 理论上没有加班
        everyMoon.add(basicSalary-fund+extraSalary);

        //计算后打印
        getSalary(everyMoon);
    }
    /**
     * @param everyMoon 每个月实际税前
     */
    private static void getSalary(List<Double> everyMoon){
        DecimalFormat df = new DecimalFormat("######0.00");
        //免征起点
        double start = 5000d;
        //额外扣除 没有填报
        start = start;

        List<Double> everyTax = SalaryTool.getEveryTab(everyMoon,start);
        //计算五险一金
        for (int i = 0; i < 12; i++) {
            if ((i+1)>everyTax.size()){
                break;
            }
            System.out.println((i+1)+"月税前工资:"+df.format(everyMoon.get(i))+"----要缴纳"+everyTax.get(i)+"元的个税,应得:"+(df.format(everyMoon.get(i)-everyTax.get(i)))+"元");
        }
        double sumGet = everyMoon.stream().collect(Collectors.summarizingDouble(value -> value)).getSum();
        double sumTax = everyTax.stream().collect(Collectors.summarizingDouble(value -> value)).getSum();
        System.out.println("全年税前:"+df.format(sumGet)+"元-----全年共缴纳税款:"+df.format(sumTax)+"元-------"+"全年税后所得(不含五险):"+(df.format(sumGet-sumTax))+"元");
    }
}
