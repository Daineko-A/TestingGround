package leetcode;

public class Fibonacci {
    public static int fib(int n) {
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

    public static void main(String[] args) {
        int a = 1 / 0;
        System.out.println(fib(3));
    }
}
