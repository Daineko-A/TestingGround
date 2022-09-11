package algorithms.utils;

import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;

public class ArbitraryArray {

    public static int[] getArbitraryArrayInt(int limit) {
        return new Random().ints(limit, -1000, 1000).toArray();
    }

    @Test
    public void checkGetArbitraryArrayInt() {
        for (int i : getArbitraryArrayInt(10)) {
            System.out.println(i);
        }

    }
}
