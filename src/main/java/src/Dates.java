package src;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dates {
    static Date todayDateRaw = new Date();
    static Date tomorrowDateRaw = new Date(todayDateRaw.getTime() + (1000 * 60 * 60 * 24));
    static Date yesterdayDateRaw = new Date(todayDateRaw.getTime() - (1000 * 60 * 60 * 24));
    static SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
    public static final String TODAY_DATE = formatter.format(todayDateRaw);
    public static final String TOMORROW_DATE = formatter.format(tomorrowDateRaw);
    public static final String YESTERDAY_DATE = formatter.format(yesterdayDateRaw);
}
