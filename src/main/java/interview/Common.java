package interview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Common {

    @Test
    public void subListTest() {
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

    @Test
    public void name() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        integerList.stream().map(i -> i + 10).forEach(System.out::println);

        System.out.println(integerList);
    }

    @Test
    public void name1() {

    }
}
