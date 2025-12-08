package leetcode;

import org.junit.jupiter.api.Test;

public class Factorial {

    @Test
    public void factorialTest() {
        System.out.println(factorial(5));
    }

    private int factorial(int n) {
        if (n == 1) {
            return n;
        }

        return n * factorial(n -1);
    }
}
