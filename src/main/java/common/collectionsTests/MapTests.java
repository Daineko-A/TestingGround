package common.collectionsTests;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapTests {
    @Test
    public void treeMapTest() {
        Map<Long, List<Integer>> acceptedIn = new TreeMap<>();
        acceptedIn.put(1L, Arrays.asList(1, 2, 3));
        acceptedIn.put(2L, Arrays.asList(1, 2, 3));
        acceptedIn.put(3L, Arrays.asList(1, 2, 3));

        int size = acceptedIn.size();
        System.out.println(size);
    }

    @Test
    public void name() {
        List<? super Number> supNum = new ArrayList<>();
        Integer integer = 1;
        supNum.add(integer);
    }
}
