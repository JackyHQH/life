package Salary;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Salary2020 {

    public static void main(String[] args) throws Exception {
        List<Double> everyMoon = new ArrayList<>();


        //基本工资
        double basicSalary = 15000d;
        //公积金
        double fund = basicSalary *0.07;
        //个人承担社保
        double reduce = basicSalary*0.105;
        //每日工资
        double daySalary = basicSalary /21.75;
        System.out.println(basicSalary/23);

        System.out.println("缴纳社保"+reduce+"元");
        System.out.println("缴纳公积金"+fund+"元");

//        everyMoon.add(basicSalary+daySalary*2+652.17d-fund-reduce);
//        everyMoon.add(basicSalary+daySalary*2-fund-reduce);
        everyMoon.add(basicSalary-fund-reduce);



        //计算后打印
        getSalary(everyMoon);
    }
    /**
     * @param everyMoon 每个月实际税前
     */
    private static void getSalary(List<Double> everyMoon){
        double basicSalary = 15000d;
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
            System.out.println((i+1)+"月税前工资(已扣除社保公积金):"+df.format(everyMoon.get(i))+"----要缴纳"+everyTax.get(i)+"元的个税" +
                    ",应得:"+(df.format(everyMoon.get(i)-everyTax.get(i)))+"元");
        }
        double sumGet = everyMoon.stream().collect(Collectors.summarizingDouble(value -> value)).getSum();
        double sumTax = everyTax.stream().collect(Collectors.summarizingDouble(value -> value)).getSum();
        System.out.println("全年税前:"+df.format(sumGet)+"元-----全年共缴纳税款:"+df.format(sumTax)+"元-------"+"全年税后所得(不含五险):"+(df.format(sumGet-sumTax))+"元");
    }


}
