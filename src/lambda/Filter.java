package lambda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @program: Hello
 * @author: hejiacun
 * @create: 2019-01-22 10:22
 **/
public class Filter {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList(new String[]{"abc", "", "bcd", "", "defg", "jk"});
        // 创建一个字符串列表，每个字符串长度大于2
        Predicate<String> aaa = (x)->x.length() > 2;
        List<String> filtered = strList.stream().filter(aaa).collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n",strList,filtered);
        //获取数字的个数、最小值、最大值、总和以及平均值
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        System.out.println(primes);
        List<Double> newPrimes = primes.stream().map((c)->c+c*0.12).collect(Collectors.toList());
        System.out.println(newPrimes);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> (int) x).summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
        char a = 0x5750;
        System.out.println(a);
    }
}
