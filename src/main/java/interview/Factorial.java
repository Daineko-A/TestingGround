package interview;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(10));
    }

    private static int factorial(int i) {
//       return i != 1 ? i * factorial(--i) : 1;
        if (i != 1) {
            return i * factorial(--i);
        } else {
            return 1;
        }
    }
}
