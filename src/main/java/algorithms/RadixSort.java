package algorithms;

import algorithms.utils.ArbitraryArray;
import org.junit.Test;

public class RadixSort {

    @Test
    public void radixSortTest() {
        for (int element : radixSort(ArbitraryArray.getArbitraryArrayInt(5))) {
            System.out.println(element);
        }
    }

    private int[] radixSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }

        int[][] radixArray = new int[10][array.length];
        int[] buckets = new int[10];

        int numberDigits = checkMaxNumberDigits(array);

        for(int i = 0,n = 1; i < numberDigits; i++, n *= 10) {
            for(int j = 0; j < array.length; j++) {
                int digElem = array[j] / n % 10;
                radixArray[digElem][buckets[digElem]] = array[j];
                buckets[digElem] ++;
            }

            int index = 0;
            for (int k = 0; k < buckets.length; k++) {
                if (buckets[k] > 0) {
                    for (int m = 0; m < buckets[k]; m++, index++) {
                        array[index] = radixArray[k][m];
                    }
                    buckets[k] = 0;
                }
            }
        }

        return array;
    }

    private int checkMaxNumberDigits(int[] array) {
        int response = 0;
        for (int num: array) {
            int ceil = (int) Math.ceil(Math.log10(num));
            if (ceil > response) {
                response = ceil;
            }
        }
        return response;
    }


}
