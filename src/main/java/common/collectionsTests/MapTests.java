package common.collectionsTests;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapTests {
    @Test
    public void treeMapTest() {
        Map<Long, List<Integer>> acceptedIn = new TreeMap<>();
        new HashSet<>();
        acceptedIn.put(1L, Arrays.asList(1, 2, 3));
        acceptedIn.put(2L, Arrays.asList(1, 2, 3));
        acceptedIn.put(3L, Arrays.asList(1, 2, 3));

        int size = acceptedIn.size();
        System.out.println(size);
    }
}
