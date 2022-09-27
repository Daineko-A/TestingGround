package data;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateTest {
    private String format = "EEE, dd MMM yyyy HH:mm:ss ZZZZ";
    private String shortFormat = "dd MMMM yyyy";
    private String stringDate = "Thu, 01 Sept 2022 11:09:23 GMT+03:00";
    private Date date = new Date(968706000000L);
    private DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();

    @Test
    public void dataTest() throws ParseException {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(2000, Calendar.SEPTEMBER, 12);
        gregorianCalendar.getTimeInMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.US);

        System.out.println(simpleDateFormat.parse(stringDate));
        System.out.println("Vendor..: " + ManagementFactory.getRuntimeMXBean().getVmVendor());
        System.out.println("VM......: " + ManagementFactory.getRuntimeMXBean().getVmName());
        System.out.println("Version.: " + ManagementFactory.getRuntimeMXBean().getSpecVersion());
        System.out.println("Build...: " + ManagementFactory.getRuntimeMXBean().getVmVersion());
    }

    @Test
    public void calendarTest() throws JSONException {
        JSONObject actual = new JSONObject();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.SEPTEMBER, 11, 12, 0, 0);
        actual.put("date", calendar);

        System.out.println(actual);
    }
}
