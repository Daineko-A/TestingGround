package common.streamsTests;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsTest {

    @Test
    public void stringsByLengthTest() {
        List<String> list = Arrays.asList("a", "bb", "c", "dd", "eee", "ab", "bd", "da");
        System.out.println(stringsByLength(list));
        System.out.println(stringsByLengthWithJoining(list));
        System.out.println(stringsByLengthAndFirstLetter(list));
    }

    private Map<Integer, List<String>> stringsByLength(List<String> listStrings) {
        return listStrings
                .stream()
                .collect(Collectors.groupingBy(String::length));
    }

    private Map<Integer, String> stringsByLengthWithJoining(List<String> listStrings) {
        return listStrings
                .stream()
                .collect(
                        Collectors.groupingBy(
                                String::length,
                                Collectors.joining("+")));
    }

    private Map<Integer, Map<Character, List<String>>> stringsByLengthAndFirstLetter(List<String> listStrings) {
        return listStrings
                .stream()
                .collect(
                        Collectors.groupingBy(
                                String::length,
                                Collectors.groupingBy(s -> s.charAt(0))));
    }
}
