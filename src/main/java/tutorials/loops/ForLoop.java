package tutorials.loops;

import java.util.concurrent.TimeUnit;

public class ForLoop {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("Sec: " + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - start));
        System.out.println("MiliSec: " + (System.currentTimeMillis() - start));
    }
}
