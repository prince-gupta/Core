package com.company.dateTime;

import org.joda.time.LocalDateTime;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Pgupta on 11/19/2015.
 */
public class MainTest {
    public static void main(String[] args) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        //get current date time with Date()
        Date date = new Date();
        System.out.println(dateFormat.format(date));

        //get current date time with Calendar()
        Calendar cal = Calendar.getInstance();
        System.out.println(Time.valueOf(dateFormat.format(cal.getTime())).getTime());

        LocalDateTime localDateTime = new LocalDateTime(date);
        Date d1 = localDateTime.withHourOfDay(00).withMinuteOfHour(00).withSecondOfMinute(00).toDate();
        System.out.println( d1.getTime() + Time.valueOf(dateFormat.format(cal.getTime())).getTime());
        System.out.println(new Date().getTime());

        DateFormat df = new SimpleDateFormat();
        Date d2 = df.parse("11/22/2015 07:00:00");
        System.out.println(d2);




    }
}
