package common.strings;

import org.junit.Test;
import org.apache.commons.lang3.StringUtils;

public class StringTest {

    String empty = new String();
    String gappString = "   ";
    String someString = "abc";

    @Test
    public void stringTest(){
        System.out.println(StringUtils.isBlank(gappString));
        System.out.println(StringUtils.isBlank(empty));
        System.out.println(StringUtils.isBlank(someString));
    }
}
