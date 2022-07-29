package interview;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Common {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("Sec: " + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - start));
        System.out.println("MiliSec: " + (System.currentTimeMillis() - start));
    }
}
