package interview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class Consumer {
    static final Long PERIOD = TimeUnit.MINUTES.toMillis(5);
    private final Map<Long, List<Integer>> acceptedInt = new LinkedHashMap<>();

    public void accept(int number) {
        acceptedInt.merge(
                System.currentTimeMillis(),
                List.of(number),
                (oldVal, newVal) -> Stream.concat(oldVal.stream(), newVal.stream()).collect(Collectors.toList()));
    }

    public Double mean() {
        long startTime = System.currentTimeMillis() - PERIOD;
        List<Integer> numbers = new ArrayList<>();

        Iterator<Map.Entry<Long, List<Integer>>> iterator = acceptedInt.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Long, List<Integer>> nextIterator = iterator.next();
            if (nextIterator.getKey() >= startTime) {
                numbers.addAll(nextIterator.getValue());
            } else {
                iterator.remove();
            }
        }

        return numbers.stream()
                .mapToDouble(d -> d)
                .average()
                .orElse(0.0);
    }

    @Test
    public void nonMultiThreadScenarioHeavyTest() {
        long startTime = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < 10000000; i++) {
            accept(random.nextInt(1024));
        }
        System.out.println("Duration HeavyTest MiliSec: " + (System.currentTimeMillis() - startTime));
        assertNotEquals(0, mean() % 1, 0.0);
    }

    @Test
    public void nonMultiThreadScenarioTest() {
        long startTime = System.currentTimeMillis();
        ArrayList<Double> results = new ArrayList<>();
        Random random = new Random();
        int iteration = 10;
        for (int a = 0; a < iteration; a++) {
            for (int i = 0; i < 1000; i++) {
                accept(random.nextInt(1024));
            }
            results.add(mean());
        }
        System.out.println("Duration MiliSec: " + (System.currentTimeMillis() - startTime));
        assertTrue(results.size() == iteration);
    }

    @Test
    public void nonMultiThreadScenarioWithOneElementTest() {
        long start = System.currentTimeMillis();
        Random random = new Random();
        accept(random.nextInt(1024));
        assertEquals(0, mean() % 1, 0.0);
    }
}
