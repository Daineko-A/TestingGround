package data

import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*


class DateKtTest {

    var pattern: String? = "EEE, dd MMM yyyy HH:mm:ss ZZZZ"
    val stringDate = "Thu, 01 Sep 2022 11:09:23 GMT+03:00"

    @Test
    fun dataTest() {
        val gregorianCalendar = GregorianCalendar(2000, Calendar.SEPTEMBER, 12)
        gregorianCalendar.timeInMillis
        val simpleDateFormat = SimpleDateFormat(pattern, Locale.US)
        println(simpleDateFormat.parse(stringDate).toString())
//        println("Vendor..: " + ManagementFactory.getRuntimeMXBean().vmVendor)
//        println("VM......: " + ManagementFactory.getRuntimeMXBean().vmName)
//        println("Version.: " + ManagementFactory.getRuntimeMXBean().specVersion)
//        println("Build...: " + ManagementFactory.getRuntimeMXBean().vmVersion)
    }

    @Test
    fun name() {
        val dateFormat: Date = SimpleDateFormat(pattern).parse(stringDate)!!
        println(SimpleDateFormat(pattern).format(dateFormat))
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val out = findViewById<TextView>(R.id.out)
//        out.text = getCurrentDate("dd-MMM-yyyy")
//    }

    @Test
    fun getCurrentDate(format: String): String {
        var result = ""

        val locales = listOf<Locale>(Locale.CANADA, Locale.CANADA_FRENCH, Locale.CHINA, Locale.CHINESE,
            Locale.ENGLISH, Locale.FRANCE, Locale.FRENCH, Locale.GERMAN, Locale.GERMANY, Locale.ITALIAN,
            Locale.ITALY, Locale.JAPAN, Locale.JAPANESE, Locale.KOREA, Locale.KOREAN, Locale.PRC,
            Locale.ROOT, Locale.SIMPLIFIED_CHINESE, Locale.TAIWAN, Locale.TRADITIONAL_CHINESE, Locale.UK, Locale.US)

        locales.forEach {
            val sdf = SimpleDateFormat(format, it)
            result += sdf.format(Date()) + "\n"
        }
        return result
    }
}