package interview;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Common {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("Sec: " + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - start));
        System.out.println("MiliSec: " + (System.currentTimeMillis() - start));

        List<String> strings = new ArrayList<>(
                Arrays.asList("1", "2", "3", "4")
        );
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.add("f");
        System.out.println(strings);
        strings.remove(0);
        System.out.println(strings);
        strings.removeAll(strings.subList(1, 4));
        System.out.println(strings);
    }
}
