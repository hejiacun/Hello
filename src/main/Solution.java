package main;

/**
 * @program: Hello
 * @author: hejiacun
 * @create: 2019-01-18 11:03
 **/
public class Solution {
    private static int fib(int N) {
        if(N == 0 || N == 1) {
            return N;
        } else {
            return fib(N-1)+fib(N-2);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(fib(i));
        }
    }
}
