package interview;

import com.mysql.cj.util.TimeUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class ConsumerMulti {
    static final Long PERIOD = TimeUnit.MINUTES.toMillis(5);
    private final Map<Long, List<Integer>> acceptedInt = new LinkedHashMap<>();

    public void accept(int number) {
        synchronized (this) {
            acceptedInt.merge(
                    System.currentTimeMillis(),
                    List.of(number),
                    (oldVal, newVal) -> Stream.concat(oldVal.stream(), newVal.stream()).collect(Collectors.toList()));
        }
    }

    public Double mean() {
        long startTime = System.currentTimeMillis() - PERIOD;
        List<Integer> numbers = new ArrayList<>();

        synchronized (this) {
            Iterator<Map.Entry<Long, List<Integer>>> iterator = acceptedInt.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Long, List<Integer>> nextIterator = iterator.next();
                if (nextIterator.getKey() >= startTime) {
                    numbers.addAll(nextIterator.getValue());
                }
            }
        }

        return numbers.stream()
                .mapToDouble(d -> d)
                .average()
                .orElse(0.0);
    }

    @Test
    public void nonMultiThreadScenarioHeavyTest() {
        long start = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < 10000000; i++) {
            accept(random.nextInt(1024));
        }
        System.out.println("result: " + mean());
        System.out.print("\n" + "Common time nonMultiThreadScenarioHeavyTest: Sec: " + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - start));
        System.out.println(" or MiliSec: " + (System.currentTimeMillis() - start) + "\n");
    }

    @Test
    public void nonMultiThreadScenarioTest() {
        long start = System.currentTimeMillis();
        Random random = new Random();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20, 20, 0L, TimeUnit.SECONDS, new SynchronousQueue<>());
        for (int i = 0; i < 100; i++) {
            Runnable runnable = accept(1);
            threadPoolExecutor.execute(runnable);
        }
    }
}
