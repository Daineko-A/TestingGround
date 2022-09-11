package algorithms;

import algorithms.utils.ArbitraryArray;
import org.junit.Test;

public class InsertionSort {

    @Test
    public void insertionSortTest() {
        for (int element : insertionSort(ArbitraryArray.getArbitraryArrayInt(5))) {
            System.out.println(element);
        }
    }

    private int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && current < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }

        return array;
    }
}
