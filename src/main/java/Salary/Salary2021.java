package Salary;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Salary2021 {
    private  static  Double willReceive = 0d;
    public static void main(String[] args) throws Exception {
        List<Double> everyMoon = new ArrayList<>();
        //基本工资
        double basicSalary = 16000d;
        //扣除个人公积金
        double fund = basicSalary * 0.07;
        //迭代绩效
        double extraSalary = basicSalary * 0.1;
        //每日工资
        double daySalary = basicSalary / 21.75;

        //一月份无迭代绩效 工作日20天 个人公积金0.7
        everyMoon.add(daySalary * 20 - fund);

        //二月份基本工资-公积金+绩效
        everyMoon.add(basicSalary - fund + extraSalary);

        //三月份发了过年加班的工资 9天份的 无绩效
        everyMoon.add(basicSalary - fund + daySalary * 9);

        //四月份涨薪4000 但是公积金还是涨薪前的
        basicSalary = basicSalary + 4000d;
        extraSalary = basicSalary * 0.1;
        daySalary = basicSalary / 21.75;
        System.out.println("日工资" + daySalary);
        everyMoon.add(basicSalary - fund + extraSalary);

        //五月份
        extraSalary = basicSalary * 0.175;
        everyMoon.add(basicSalary - fund + extraSalary);

        //六月份
        extraSalary = 4667.61d+600d;
        everyMoon.add(basicSalary - fund + extraSalary);

        //七月份 理论上没有加班
        extraSalary = 4681.46d+600;
        fund = basicSalary * 0.07;
        everyMoon.add(basicSalary - fund + extraSalary);

        //八月份 理论上没有加班
        extraSalary = 4000d;
        everyMoon.add(basicSalary - fund + extraSalary);

        //九月份
        extraSalary = 6833.18d;
        everyMoon.add(basicSalary - fund + extraSalary);

        //十月份加了三天班
        extraSalary = daySalary * 7 + 3321;
        System.out.println(extraSalary);
        everyMoon.add(basicSalary - fund + extraSalary);

        //十一月份 理论上没有加班
        extraSalary = 4000d;
        everyMoon.add(basicSalary - fund + extraSalary);

        //十二月份 理论上没有加班
        everyMoon.add(basicSalary - fund + extraSalary);

        //计算后打印
        getSalary(everyMoon,0d);
    }

    /**
     * @param everyMoon 每个月实际税前
     */
    private static void getSalary(List<Double> everyMoon,Double needReduce) {
        DecimalFormat df = new DecimalFormat("######0.00");
        //免征起点
        double start = 5000d;
        //额外扣除 没有填报
        if(needReduce>0){
            start = start + needReduce;
        }
        double total = 0d;
        double totalA = 0d;
        List<Double> everyTax = SalaryTool.getEveryTab(everyMoon, start);
        //计算五险一金
        for (int i = 0; i < 12; i++) {
            if ((i + 1) > everyTax.size()) {
                break;
            }
            total += everyMoon.get(i);
            totalA += everyMoon.get(i) - everyTax.get(i);
            if(needReduce<=0){
                System.out.println((i + 1) + "月税前工资:" + df.format(everyMoon.get(i)+1400d) + "-------扣除公积金:"+df.format(everyMoon.get(i))+"-----累计税前" + df.format(total) + "元-------累计扣除后:"+(df.format(total-5000*(i+1)))+"-------要缴纳" + everyTax.get(i) + "元的个税,应得:" + (df.format(everyMoon.get(i) - everyTax.get(i))) + "元---累计税后" + df.format(totalA));
            }
        }
        double sumGet = everyMoon.stream().collect(Collectors.summarizingDouble(value -> value)).getSum();
        double sumTax = everyTax.stream().collect(Collectors.summarizingDouble(value -> value)).getSum();
        System.out.println("全年税前:" + df.format(sumGet) + "元-----全年共缴纳税款:" + df.format(sumTax) + "元-------" + "全年税后所得(不含五险):" + (df.format(sumGet - sumTax)) + "元");
        if(willReceive>0){
            willReceive = willReceive - sumTax;
            System.out.println("如果填报了"+needReduce+"块钱的退税,你会收到退税:"+df.format(willReceive)+"元");
            willReceive = willReceive + sumTax;
        }else {
            willReceive = sumTax;
        }

        if(needReduce<=0){
            calbytotal(sumGet);
        }
    }



    private static void calbytotal(Double total){
        List<Double> everyMoon = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            everyMoon.add(total/12);
        }
        getSalary(everyMoon,1500d);
        getSalary(everyMoon,3500d);
    }



}
