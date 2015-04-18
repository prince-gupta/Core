import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Pgupta on 4/1/2015.
 */
public class JODATimeTest {
    public static void main(String[] args) {
      /*  for (String dateTimeZone : DateTimeZone.getAvailableIDs()) {
            System.out.println("----- " + dateTimeZone + " ---------");
            DateTimeZone zone = DateTimeZone.forID(dateTimeZone);
            // DateTimeZone zone = DateTimeZone.forTimeZone(TimeZone.getTimeZone("MST"));
            DateTimeFormatter format = DateTimeFormat.mediumDateTime();
            DateTimeFormatter formatter1 = DateTimeFormat.fullDateTime();
            long current = System.currentTimeMillis();
            for (int i = 0; i < 2; i++) {
                long next = zone.nextTransition(current);
                if (current == next) {
                    break;
                }
                System.out.println("Next : " + formatter1.print(next) + " Into DST? "
                        + !zone.isStandardOffset(next));
                current = next;
            }
        }*/

        // LocalDateTime dt = new LocalDateTime(System.currentTimeMillis());
        DateTime dt1 = new LocalDateTime(new Date("Sun Mar 08 00:00:00 PST 2015")).toDateTime(DateTimeZone.forTimeZone(TimeZone.getTimeZone("PST")));
        DateTimeFormatter formatter1 = DateTimeFormat.fullDateTime();
      //  TimeZone.setDefault(TimeZone.getTimeZone("MST"));
        DateTime dt = new LocalDateTime(new Date("Sun Mar 08 00:00:00 PST 2015")).toDateTime(DateTimeZone.forTimeZone(TimeZone.getTimeZone("PST")));

        System.out.println(formatter1.print(dt));
        System.out.println(formatter1.print(dt1));

        DateTime dateTimeNew = new DateTime(new Date().getTime(), DateTimeZone.forTimeZone(TimeZone.getTimeZone("US/Alaska")));
       // Date dateTimeZone = dateTime.toDateTimeAtStartOfDay(timeZone).toDate();
        System.out.println(formatter1.print(dateTimeNew));

/*
        System.out.print(TimeZone.getDefault().toString());
        System.out.print(TimeZone.getDefault().getRawOffset());
        System.out.println(TimeZone.getTimeZone("EST").inDaylightTime(new Date("Mon Apr 06 03:00:00 EST 2015")));
*/
        float value = 3.5f;
        long longV = (long)(3.5*60*60*1000);
        System.out.print(longV);

        for(String timeZone : TimeZone.getAvailableIDs()){
            System.out.println(TimeZone.getTimeZone(timeZone).getDisplayName() + " : " + TimeZone.getTimeZone(timeZone).getID());
        }
    }
}
