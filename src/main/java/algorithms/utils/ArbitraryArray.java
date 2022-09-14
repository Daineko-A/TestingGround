package algorithms.utils;

import org.junit.Test;

import java.util.Random;

public class ArbitraryArray {

    public static int[] getArbitraryArrayInt(int limit) {
        return new Random().ints(limit, 0, 1000).toArray();
    }

    @Test
    public void checkGetArbitraryArrayInt() {
        for (int i : getArbitraryArrayInt(10)) {
            System.out.println(i);
        }

    }
}
