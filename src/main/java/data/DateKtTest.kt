package data

import org.junit.Test
import java.lang.management.ManagementFactory
import java.sql.DriverManager.println
import java.text.SimpleDateFormat
import java.util.*

class DateKtTest {

    @Test
    fun dataTest() {
        var format: String? = "EEE, dd MMM yyyy HH:mm:ss ZZZZ"
        val stringDate = "Thu, 01 Sep 2022 11:09:23 GMT+03:00"

        val gregorianCalendar = GregorianCalendar(2000, Calendar.SEPTEMBER, 12)
        gregorianCalendar.timeInMillis
        val simpleDateFormat = SimpleDateFormat(format, Locale.US)
        println(simpleDateFormat.parse(stringDate).toString())
        println("Vendor..: " + ManagementFactory.getRuntimeMXBean().vmVendor)
        println("VM......: " + ManagementFactory.getRuntimeMXBean().vmName)
        println("Version.: " + ManagementFactory.getRuntimeMXBean().specVersion)
        println("Build...: " + ManagementFactory.getRuntimeMXBean().vmVersion)
    }
}