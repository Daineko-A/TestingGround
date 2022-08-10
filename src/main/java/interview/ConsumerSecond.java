package interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsumerSecond {
    //    static final Long PERIOD = TimeUnit.MINUTES.toMillis(5);
    static final Long PERIOD = 30L;
    private static final Map<Long, List<Integer>> acceptedInt = new LinkedHashMap<>();

    public static void accept(int number) {
        acceptedInt.merge(
                System.currentTimeMillis(),
                List.of(number),
                (oldVal, newVal) -> Stream.concat(oldVal.stream(), newVal.stream()).collect(Collectors.toList()));
    }

    public static Double mean() {
        long currentTime = System.currentTimeMillis();
        long startTime = currentTime - PERIOD;
        ArrayList<Long> keys = new ArrayList<>(acceptedInt.keySet());
        Collections.reverse(keys);
        List<Integer> numbers = new ArrayList<>();

        for (Long keyTime : keys) {
            if (keyTime >= startTime && keyTime <= currentTime) {
                numbers.addAll(acceptedInt.get(keyTime));
            } else {
                break;
            }
        }

        return numbers.stream()
                .mapToDouble(d -> d)
                .average()
                .orElse(0.0);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < 10000000; i++) {
            accept(random.nextInt(1024));
        }
        System.out.println(mean());
        System.out.println("Sec: " + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - start));
        System.out.println("MiliSec: " + (System.currentTimeMillis() - start));
    }
}
