package com.company.test;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.Seconds;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Pgupta on 10/28/2015.
 */
public class DateTest {
    public static void main(String args[]){
        Date d1 = new Date("10/23/2015  11:55:05");
        Date d2 = new Date("Fri Oct 23 11:55:29 PST 2015");
        String d3 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(d2);
        System.out.println(d3);
        DateTime localDateTime1 = new DateTime(d1);
        DateTime localDateTime2 = new DateTime(d2);
        System.out.println(Seconds.secondsBetween(localDateTime1,localDateTime2).getSeconds());
            SimpleDateFormat bpDateFormater = new SimpleDateFormat("HHmm");
            System.out.println(bpDateFormater.format(new Date()));
    }
}
