package algorithms.searches;

import algorithms.utils.ArbitraryArray;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class Binary {

    @Test
    public void binaryTest() {
        int limit = 100000;
        for (int i = 0; i < 20; i++) {
        int[] arbitraryArrayInt = ArbitraryArray.getArbitraryArrayInt(limit);
        int element = arbitraryArrayInt[new Random().nextInt(limit - 1)];
        Arrays.sort(arbitraryArrayInt);
            System.out.println(element + " : " + binary(arbitraryArrayInt, element));
        }
    }

    private int binary(int[] array, int element) {
        int minPosition = 0;
        int maxPosition = array.length - 1;
        int mid = 0;
        int iteeration = 0;
        while (minPosition <= maxPosition) {
            mid = (minPosition + maxPosition) / 2;
            if (element == array[mid]) {
                iteeration++;
                break;
            } else if (element < array[mid]) {
                iteeration++;
                maxPosition = mid - 1;
            } else if (element > array[mid]) {
                iteeration++;
                minPosition = mid + 1;
            }
        }
        System.out.println("iterations: " + iteeration);
        return array[mid];
    }
}
