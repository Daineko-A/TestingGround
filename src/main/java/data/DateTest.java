package data;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class DateTest {
    private String format = "EEE, dd MMM yyyy HH:mm:ss ZZZZ";
    private String shortFormat = "dd MMMM yyyy";
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
}
