package interview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Consumer {
    /**
         * Called periodically to consume an integer.
     */
    static final Long PERIOD = TimeUnit.MINUTES.toMillis(1);
    private static final Map<Long, List<Integer>> acceptedInt = new LinkedHashMap<>();

    public static void accept( int number ) {
        acceptedInt.merge(
                System.currentTimeMillis(),
                List.of(number),
                (oldVal, newVal) -> Stream.concat(oldVal.stream(), newVal.stream()).collect(Collectors.toList()));
    };

    /**
     * Returns the mean (aka average) of numbers consumed in the
     * last 5 minute period.
     */

    public static Double mean(){
        long startTime = System.currentTimeMillis() - PERIOD;
        List<Integer> numbers = new ArrayList<>();

        Iterator<Map.Entry<Long, List<Integer>>> iterator = acceptedInt.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Long, List<Integer>> next = iterator.next();
            if(next.getKey() > startTime) {
                numbers.addAll(next.getValue());
            } else {
                acceptedInt.remove(next.getKey());
            }
        }

        return numbers.stream()
                .mapToDouble(d -> d)
                .average()
                .orElse(0.0);
    };

    public static void main(String[] args) {
        accept(1);
        accept(2);
        accept(3);
        accept(4);
        System.out.println(mean());
    }
}
