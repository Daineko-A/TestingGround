package algorithms.sorts;

import algorithms.utils.ArbitraryArray;
import org.junit.Test;

public class MergeSort {

    @Test
    public void mergeSortTest() {
        for (int element : mergeSort(ArbitraryArray.getArbitraryArrayInt(10))) {
            System.out.println(element);
        }
    }

    private int[] mergeSort(int[] array) {
        if (array.length < 2) {
            return array;
        }

        int mid = array.length / 2;
        int midPosition = array.length - mid;
        int[] arrayLeft = new int[mid];
        int[] arrayRight = new int[midPosition];

        for (int i = 0; i < mid; i++) {
            arrayLeft[i] = array[i];
        }
        //System.arraycopy
        for (int i = mid; i < array.length; i++){
            arrayRight[i - mid] = array[i];
        }

        arrayLeft = mergeSort(arrayLeft);
        arrayRight = mergeSort(arrayRight);

        return merge(array, arrayLeft, arrayRight, mid, array.length - mid);
    }

    private int[] merge(int[] array, int[] arrayLeft, int[] arrayRight, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (arrayLeft[i] <= arrayRight[j]) {
                array[k++] = arrayLeft[i++];
            }
            else {
                array[k++] = arrayRight[j++];
            }
        }
        while (i < left) {
            array[k++] = arrayLeft[i++];
        }
        while (j < right) {
            array[k++] = arrayRight[j++];
        }

        return array;
    }
}
