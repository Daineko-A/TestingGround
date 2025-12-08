package interview;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class Consumer {
    static final Long PERIOD = TimeUnit.MINUTES.toMillis(5);
    //    static final Long PERIOD = 100L;
    private final Map<Long, List<Integer>> acceptedInt = new LinkedHashMap<>();

    public void accept(int number) {
        acceptedInt.computeIfAbsent(System.currentTimeMillis(), k -> new ArrayList<>()).add(number);
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
        System.out.println("Duration HeavyTest Millis: " + (System.currentTimeMillis() - startTime));
        assertNotEquals(0, mean() % 1, 0.0);
    }

    @Test
    public void nonMultiThreadScenarioTest() {
        long startTime = System.currentTimeMillis();
        ArrayList<Double> results = new ArrayList<>();
        Random random = new Random();
        int iteration = 100;
        for (int a = 0; a < iteration; a++) {
            for (int i = 0; i < 100000; i++) {
                accept(random.nextInt(1024));
            }
            results.add(mean());
        }
        System.out.println("Duration Millis: " + (System.currentTimeMillis() - startTime));
        assertEquals(results.size(), iteration);
    }

    @Test
    public void nonMultiThreadScenarioWithOneElementTest() {
        Random random = new Random();
        accept(random.nextInt(1024));
        assertEquals(0, mean() % 1, 0.0);
    }
}
