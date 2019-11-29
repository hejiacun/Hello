package lambda;

import com.jollycorp.worksheet.facade.customerService.SheetFacade;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @program: Hello
 * @author: hejiacun
 * @create: 2019-01-21 11:59
 **/
public class T {
    public static void main(String[] args) {
        SheetFacade sheetFacade;
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        // Java 8之前：
        for (String feature : features) {
            System.out.println(feature);
        }
        System.out.println();
        // Java 8之后：
        features.forEach(n -> System.out.println(n));
        System.out.println();
        // 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
        // 看起来像C++的作用域解析运算符
        features.forEach(System.out::println);
        System.out.println("=======================");
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        filter(languages, (str)->str.toString().startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter(languages, (str)->str.toString().endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, (str)->true);

        System.out.println("Print no language : ");
        filter(languages, (str)->false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str)->str.toString().length() > 4);

        System.out.println("=======================");
        Predicate startsWithJ = (n) -> n.toString().startsWith("J");
        Predicate fourLetterLong = (n) -> n.toString().length() == 4;
        languages.stream()
                .filter(startsWithJ.and(fourLetterLong))
                .forEach((n) -> System.out.print("nName, which starts with 'J' and four letter long is : " + n));
    }
    public static void filter2(List<String> names, Predicate condition) {
        for(Object name: names)  {
            if(condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }

    // 更好的办法
    public static void filter(List names, Predicate condition) {
        names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
            System.out.println(name + " ");
        });
    }
}
