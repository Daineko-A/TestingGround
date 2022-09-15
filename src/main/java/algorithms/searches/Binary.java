package algorithms.searches;

import algorithms.utils.ArbitraryArray;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class Binary {

    @Test
    public void binaryTest() {
        int limit = 10;
        int[] arbitraryArrayInt = ArbitraryArray.getArbitraryArrayInt(limit);
        int element = arbitraryArrayInt[new Random().nextInt(limit - 1)];
        Arrays.sort(arbitraryArrayInt);

        System.out.println(element + " : " + binary(arbitraryArrayInt, element));
    }

    private int binary(int[] array, int element) {
        int minPosition = 0;
        int maxPosition = array.length - 1;
        int mid = 0;
        while (minPosition <= maxPosition) {
            mid = (minPosition + maxPosition) / 2;
            if (element == array[mid]) {
                return array[mid];
            } else if (element < array[mid]) {
                maxPosition = mid - 1;
            } else if (element > array[mid]) {
                minPosition = mid + 1;
            }
        }
        return array[mid];
    }
}
