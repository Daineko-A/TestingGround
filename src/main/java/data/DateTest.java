package data;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.management.ManagementFactory;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateTest {
    private String format = "EEE, dd MM yyyy HH:mm:ss ZZZZ";
    private String longFormat = "EEE, dd MMM yyyy HH:mm:ss ZZZZ";
    private String shortFormat = "yyyy-MM-dd";
    private String stringDate = "Thu, 01 Sep 2022 11:09:23 GMT+03:00";
    private Date date = new Date(968706000000L);
    private DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();

    @Test
    public void dataTest() throws ParseException {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(2000, Calendar.SEPTEMBER, 12);
        gregorianCalendar.getTimeInMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.ROOT);

        System.out.println(simpleDateFormat.parse(stringDate));
        System.out.println("Vendor..: " + ManagementFactory.getRuntimeMXBean().getVmVendor());
        System.out.println("VM......: " + ManagementFactory.getRuntimeMXBean().getVmName());
        System.out.println("Version.: " + ManagementFactory.getRuntimeMXBean().getSpecVersion());
        System.out.println("Build...: " + ManagementFactory.getRuntimeMXBean().getVmVersion());
    }

    @Test
    public void testAllLocations() {
        List<Locale> locales = Arrays.asList(
                Locale.getDefault(),
                Locale.CANADA, Locale.CANADA_FRENCH, Locale.FRANCE, Locale.ITALY,
                Locale.FRENCH, Locale.GERMAN, Locale.GERMANY, Locale.ITALIAN,
                Locale.ROOT, Locale.UK, Locale.US, Locale.ENGLISH);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.SEPTEMBER, 11, 12, 0, 0);

        for (Locale loc : locales) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, loc);
//            simpleDateFormat.setCalendar(calendar);
            System.out.println("Loc:" + loc + " - " + simpleDateFormat.format(calendar.getTime()));
        }

        for (Locale loc : locales) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(shortFormat, loc);
//            simpleDateFormat.setCalendar(calendar);
            System.out.println("Loc:" + loc + " - " + simpleDateFormat.format(calendar.getTime()));
        }
    }

    @Test
    public void calendarToTime() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
    }

    @Test
    public void parse() throws ParseException {
        DateFormat df = new SimpleDateFormat("EEE, dd MM yyyy HH:mm:ss ZZZZ", Locale.ENGLISH);
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        System.out.println(df.parse("Thu, 01 Sep 2022 11:09:23 GMT+03:00"));
    }

    @Test
    public void calendarTest() throws JSONException {
        JSONObject actual = new JSONObject();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.SEPTEMBER, 11, 12, 0, 0);
        actual.put("date", calendar);

        System.out.println(actual);
    }

    @Test
    public void dateTestJson() throws JSONException {
        JSONObject actual = new JSONObject();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.SEPTEMBER, 11, 12, 0, 0);
        EntityWithDate entityWithDate = new EntityWithDate(calendar.getTime(), "first");

        actual.put("first", entityWithDate);

        System.out.println(actual);
    }

    @Test
    public void dateTest() {
        int[] nums = {3, 6, 9, 1, 16, 8, 2, 4, 7};
        int i = maximumGap(nums);
        assertEquals(7, i);
    }

    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i] - nums[i - 1];
            if (tmp > max) {
                max = tmp;
            }
        }
        return max;
    }

    @Test
    public void singleNumberTest() {
        int[] nums = {3, 99, 99, 1, 1, 2, 4, 7, 3, 6, 16, 3, 8, 99, 4, 7};
        assertEquals(16, singleNumber(nums));

        int[] nums2 = {2,2,3,2};
        assertEquals(3, singleNumber(nums2));
    }

    public int singleNumber(int[] nums) {
        Set<Integer> collect = Arrays.stream(nums).boxed().distinct().collect(Collectors.toSet());
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
                collect.remove(num);
            }
        }
        return collect.iterator().next();
    }

    @Test
    public void testSteream() {
        List<String> result =
                Stream.of(1, 2, 2, 3, 4, 4, 5, 6, 7, 7, 8, 9, 10)
                        .skip(2)
                        .limit(10)
                        .filter(n -> n % 2 == 0)
                        .map(n -> n * 10)
                        .filter(n -> n >= 40)
                        .map(n -> (n / 10) - 1)
                        .filter(i -> i >= 0 && i < 26)
                        .map(i -> String.valueOf((char) ('A' + i)))
                        .sorted()
                        .distinct()
                        .peek(s -> System.out.println("peek: " + s))
                        .toList();

        System.out.println(result);
    }

    @Test
    public void testHashMap() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(null, "aa");

        System.out.println(hashMap.get(null));
        System.out.println(hashMap.keySet());
        System.out.println(hashMap.containsKey(null));
    }
}
