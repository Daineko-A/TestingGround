package algorithms.sorts;

import algorithms.utils.ArbitraryArray;
import org.junit.Test;

public class SelectionSort {

    @Test
    public void selectionSortTest() {
        for (int element : selectionSortSort(ArbitraryArray.getArbitraryArrayInt(5))) {
            System.out.println(element);
        }
    }

    private int[] selectionSortSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minCursor = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minCursor = j;
                }
            }
            int tmp = array[i];
            array[i] = min;
            array[minCursor] = tmp;
        }

        return array;
    }
}
