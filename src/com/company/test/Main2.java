package com.company.test;

/**
 * Created by Pgupta on 9/22/2014.
 */
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Main2 {
    String parsedTime;
    String noOfCompeleteDays;
    String noOfHoursLess;
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdfTime = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        Main2 m = new Main2();
        Date now = new Date(Time.valueOf("21:00:00").getTime());
        String strTime = sdfTime.format(m.parse("01:00:00"));
        System.out.println(strTime);
        System.out.println("Time: " + strTime);
        System.out.println("Time 1: " + now.getTime());
        System.out.println("Time Day: " + now.getDay());
        System.out.println("Time Hours: " + now.getHours());
        System.out.println("Time Min: " + now.getMinutes());
        System.out.println(Time.valueOf("00:00:00").getTime());
        //System.out.println(Time.valueOf().getTime());

            String target = "192:00:00";
            DateFormat df = new SimpleDateFormat("kkk:mm:ss", Locale.ENGLISH);
            Date result =  df.parse(target);
            System.out.println(191%24);

        Date firstDate = m.parse("191:00:00");
        Date secondDate = m.parse("750:12:21");
        System.out.println(firstDate.before(secondDate));
        System.out.println(m.parse("332:59:59"));
    }
    public Date parse(String dateToParse){
        String hours = dateToParse.substring(0,dateToParse.indexOf(':'));
        Integer noOfHours = calculateNoOfHoursToCompleteNearestDay(hours);
        Integer noOfDays = calculateNoOfDays(hours);
        Integer noOfMinutes = Integer.valueOf(dateToParse.substring(dateToParse.indexOf(':')+1,dateToParse.lastIndexOf(':')));
        Integer noOfSeconds = Integer.valueOf(dateToParse.substring(dateToParse.lastIndexOf(':')+1,dateToParse.length()));
      //  String parsedDate = noOfHours+dateToParse.substring(dateToParse.indexOf(':'),dateToParse.length());
        Date newDate = new Date(70,0,noOfDays,noOfHours,noOfMinutes,noOfSeconds);
        return newDate;
    }
    public Integer calculateNoOfHoursToCompleteNearestDay(String hours){
        return (Integer.valueOf(hours) % 24);
    }

    public Integer calculateNoOfDays(String hours){
        return Integer.valueOf(hours) / 24;
    }
}