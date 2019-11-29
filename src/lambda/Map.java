package lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @program: Hello
 * @author: hejiacun
 * @create: 2019-01-22 10:14
 **/
public class Map {
    public static void main(String[] args) {
        System.out.println("====================");
        // 不使用lambda表达式为每个订单加上12%的税
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        for (Integer cost : costBeforeTax) {
            double price = cost + .12*cost;
            System.out.println(price);
        }
        System.out.println();
        List<Integer> costBeforeTax1 = Arrays.asList(100, 200, 300, 400, 500);
        // 使用lambda表达式
        costBeforeTax1.stream().map((cost) -> cost + .12*cost).forEach(System.out::println);
        System.out.println("======================");
        double total = 0;
        for (Integer cost : costBeforeTax) {
            double price = cost + .12*cost;
            total = total + price;
        }
        System.out.println("Total : " + total);
        System.out.println();
        double bill = costBeforeTax1.stream().map((cost) -> cost + .12*cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total : " + bill);
    }
}
