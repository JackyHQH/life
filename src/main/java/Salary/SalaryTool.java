package Salary;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class SalaryTool {
    static List<Double> getEveryTab(List<Double> everyMoon,double start){
        DecimalFormat df = new DecimalFormat("######0.00");
        List<Double> everyTax = new ArrayList<>();
        for (int i = 1; i <= everyMoon.size(); i++) {
            double one = (getSum(everyMoon,i) - start*i);
            if(one <= 36000){
                one = one * 0.03 - everyTax.stream().collect(Collectors.summarizingDouble(value -> value)).getSum();
            }else if(one > 36000 && one <= 144000 ){
                one = one * 0.1 - 2520 - everyTax.stream().collect(Collectors.summarizingDouble(value -> value)).getSum();
            }else if(one > 144000 && one <= 300000){
                one = one * 0.2 - 16920 - everyTax.stream().collect(Collectors.summarizingDouble(value -> value)).getSum();
            }else if(one > 300000 && one <= 420000){
                one = one * 0.25 - 31920 - everyTax.stream().collect(Collectors.summarizingDouble(value -> value)).getSum();
            }else if(one > 420000 && one <= 660000){
                one = one * 0.3 - 52920 - everyTax.stream().collect(Collectors.summarizingDouble(value -> value)).getSum();
            }else if(one > 660000 && one <= 960000){
                one = one * 0.35 - 85920 - everyTax.stream().collect(Collectors.summarizingDouble(value -> value)).getSum();
            }else if(one > 960000){
                one = one * 0.35 - 181920 - everyTax.stream().collect(Collectors.summarizingDouble(value -> value)).getSum();
            }
            everyTax.add(Double.parseDouble(df.format(one)));
        }
        return everyTax;
    }
    private static double getSum(List<Double> list , int end){
        double sum = 0d;
        for (int i = 0; i < end; i++) {
            sum += list.get(i);
        }
        return sum;
    }
}
