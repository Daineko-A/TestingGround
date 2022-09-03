package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WeakestRows {

    @Test
    public void testKWeakestRows() {
        int[][] array = {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
        int k = 3;
        int[] answer = {2, 0, 3};
        int[] result = kWeakestRows(array, k);

        assert (Arrays.equals(answer, result));
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, List<Integer>> treeMap = new TreeMap<>();
        int counter = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int intsVertical : mat[i]) {
                counter += intsVertical;
            }
            treeMap.computeIfAbsent(counter, v -> new ArrayList<>()).add(i);
            counter = 0;
        }
        return treeMap.values().stream().flatMap(Collection::stream).limit(k).mapToInt(Integer::intValue).toArray();
    }
}
