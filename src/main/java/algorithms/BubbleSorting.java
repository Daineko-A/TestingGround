package algorithms;

import algorithms.utils.ArbitraryArray;
import org.junit.Test;

public class BubbleSorting {

    @Test
    public void bubbleSortingTest() {
        for (int element : bubbleSorting(ArbitraryArray.getArbitraryArrayInt(20))) {
            System.out.println(element);
        }
    }

    private int[] bubbleSorting(int[] arbitraryArrayInt) {
        if (arbitraryArrayInt.length < 2) {
            return arbitraryArrayInt;
        }

        int tallPosition = arbitraryArrayInt.length - 1;
        int startPosition = 0;

        while (tallPosition > 0) {
            if (arbitraryArrayInt[startPosition] > arbitraryArrayInt[startPosition + 1]) {
                int tmp = arbitraryArrayInt[startPosition];
                arbitraryArrayInt[startPosition] = arbitraryArrayInt[startPosition + 1];
                arbitraryArrayInt[startPosition + 1] = tmp;
            }
            startPosition++;
            if (startPosition == tallPosition) {
                tallPosition--;
                startPosition = 0;
            }
        }

        return arbitraryArrayInt;
    }
}
