package common.collectionsTests;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class SetTests {

    @Test
    public void differentSets() {
        Set<String> setOne = new HashSet<>();
        Set<String> setTwo = new TreeSet<>();

        String s1 = "one";
        String s2 = "two";
        String s3 = "three";

        setOne.add(s1);
        setOne.add(s2);
        setOne.add(s3);

        setTwo.add(s1);
        setTwo.add(s2);
        setTwo.add(s3);

        assertEquals(setOne, setTwo);
    }


}
