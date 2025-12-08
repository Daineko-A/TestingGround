package leetcode;

import org.junit.jupiter.api.Test;

public class Fibonacci {

    @Test
    public void fibTest() {
        System.out.println(fib(17));
    }

    @Test
    public void fibRecursionTest() {
        System.out.println(fibRecursion(17));
    }

    private int fibRecursion(int n) {
        int start = 0;
        if (n == 0 || n == 1) return n;
        return fibRecursion(n - 1) + fibRecursion(n - 2);
    }

    private int fib(int n) {
        int prev = 0;
        int next = 1;
        int i = 1;
        int sum = 0;

        if (n == 0) {
            return sum;
        }
        while (n - 1 > i++) {
            sum = prev + next;
            prev = next;
            next = sum;
        }
        return prev + next;
    }
}
