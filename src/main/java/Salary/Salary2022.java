package Salary;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Salary2022 {
    private  static  Double willReceive = 0d;
    public static void main(String[] args) throws Exception {
        List<Double> everyMoon = new ArrayList<>();
        //基本工资
        double basicSalary = 20000d;
        //扣除个人公积金
        double fund = basicSalary * 0.07;
        //迭代绩效
        double extraSalary = basicSalary * 0.15;
        basicSalary = 22000d;
        //每日工资
        double daySalary = basicSalary / 21.75;

        everyMoon.add(basicSalary - fund + extraSalary);

        //二月份基本工资-公积金+绩效
        extraSalary = basicSalary * 0.15;
        everyMoon.add(basicSalary - fund + extraSalary);
        //三月份
        everyMoon.add(basicSalary - fund + extraSalary);

        //四月份
        everyMoon.add(basicSalary - fund + extraSalary);
        fund = basicSalary * 0.07;
        //五月份
        everyMoon.add(basicSalary - fund + extraSalary);

        //六月份
        everyMoon.add(basicSalary - fund + extraSalary);

        //七月份
        everyMoon.add(basicSalary - fund + extraSalary);

        //八月份
        everyMoon.add(basicSalary - fund + extraSalary);

        //九月份
        everyMoon.add(basicSalary - fund + extraSalary);

        //十月份
        everyMoon.add(basicSalary - fund + extraSalary);

        //十一月份
        everyMoon.add(basicSalary - fund + extraSalary);

        //十二月份
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
            System.out.println("如果填报了"+needReduce+"块钱的退税,你会收到退税:"+willReceive+"元");
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
        getSalary(everyMoon,3500d);
    }
}
