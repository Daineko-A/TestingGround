package algorithms.sorts;

import algorithms.utils.ArbitraryArray;
import org.junit.Test;

public class BubbleSort {

    @Test
    public void bubbleSortTest() {
        for (int element : bubbleSort(ArbitraryArray.getArbitraryArrayInt(20))) {
            System.out.println(element);
        }
    }

    @Test
    public void bubbleSortSecondTest() {
        for (int element : bubbleSortSecond(ArbitraryArray.getArbitraryArrayInt(3))) {
            System.out.println(element);
        }
    }

    private int[] bubbleSortSecond(int[] array) {
        boolean isSorted = false;
        int tmp;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    isSorted = false;
                }
            }
        }

        return array;
    }

    private int[] bubbleSort(int[] array) {
        if (array.length < 2) {
            return array;
        }

        int tallPosition = array.length - 1;
        int startPosition = 0;

        while (tallPosition > 0) {
            if (array[startPosition] > array[startPosition + 1]) {
                int tmp = array[startPosition];
                array[startPosition] = array[startPosition + 1];
                array[startPosition + 1] = tmp;
            }
            startPosition++;
            if (startPosition == tallPosition) {
                tallPosition--;
                startPosition = 0;
            }
        }

        return array;
    }
}
