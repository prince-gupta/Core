package com.company.test;

import java.sql.Time;
import java.util.Date;

/**
 * Created by Pgupta on 9/16/2014.
 */
public class TimeTest {
    public static final String SCORING_TIME_FORMAT = "%1$tH:%1$tM:%1$tS";
    public static void main(String[] args) {
        Time time = new Time(234,59,59);
        System.out.println(time.getTime());

        String timeL = new String("72");
        System.out.println(String.format("%03d", Long.parseLong(timeL)));

    }
}
