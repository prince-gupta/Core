package com.company.test;

import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Pgupta on 1/13/2015.
 */
public class Test {
    public static final String SQL_WILDCARD ="%";
    public static final String SQL_ESCAPE = "";
    public static final String SQL_WILDCARD_REGEX = "["+ SQL_WILDCARD +","+SQL_ESCAPE+"].*";
    public static void main(String args[]) throws ParseException {
        /*Double gross = new Double(425);
        Double dscntPrcnt = new Double(7.5/100);
        Double cost = new Double(393.125);
        System.out.println(BigDecimal.valueOf((gross - (gross * dscntPrcnt))));
        System.out.println(BigDecimal.valueOf(cost));
        System.out.println(BigDecimal.valueOf((gross - (gross * dscntPrcnt))).setScale(2, BigDecimal.ROUND_HALF_UP));
        System.out.println(BigDecimal.valueOf(cost).setScale(2, BigDecimal.ROUND_HALF_UP));
        System.out.println(BigDecimal.valueOf((gross - (gross * dscntPrcnt))).setScale(2, BigDecimal.ROUND_HALF_UP)
                .equals(BigDecimal.valueOf(cost).setScale(2, BigDecimal.ROUND_HALF_UP)));
        StringBuffer buffer = new StringBuffer();
        buffer.append("(");
        System.out.println(buffer.length());
        WeakHashMap weakHashMap = new WeakHashMap();
        HashMap hashMap = new HashMap();
        Long one = new Long(1);
        weakHashMap.put(one,1);
        hashMap.put(one, 1);
        System.gc();
        System.out.println(weakHashMap);
        System.out.println(hashMap);*/

        String s = "insert OR ";
        System.out.println(s.substring(0,s.indexOf(" OR ")));


        User u = new User("Ron",43);
        User u2 = new User("Mark",43);
        System.out.println(System.identityHashCode(u) < System.identityHashCode(u2));

        Date stationActualDateTime = new Date(1425801600000L+14400000L);
        System.out.println(stationActualDateTime.toString());

        Date rdDateTime = new Date(stationActualDateTime.getTime() + 10800000L);
        System.out.println(stationActualDateTime.getTime());
        System.out.println("rdDateTime : " + rdDateTime.toString());

        Date t = new Date("Sun March 8 1:00:00 PST 2015");

        //Date tr2 = new Date(t.getTime()+(1*60*60*1000) + (60*60*1000));
        Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("EST"));

        cal.setTimeInMillis(t.getTime());
        //cal.setTimeZone(TimeZone.getTimeZone("EST"));
        System.out.println("->>>>>"+cal.get(Calendar.HOUR));
        System.out.println(t.toString());
       // System.out.println(new Date(tr2.getTime()-60*60*1000));


        TimeZone zi = TimeZone.getDefault();
        //System.out.println(zi.getDisplayName(cal.getTimeZone().inDaylightTime(tr2), zi.SHORT, Locale.US));
        System.out.println(zi.getDisplayName(cal.getTimeZone().inDaylightTime(t), zi.SHORT, Locale.US));
        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        isoFormat.setTimeZone(TimeZone.getTimeZone("EST"));
        Date date = isoFormat.parse("2010-05-23T09:01:02");
        System.out.println(date.toString());



        TimeZone stationTimeZone = TimeZone.getTimeZone("MST");
        Date actualDatePart = new Date("Sun March 8 2:00:00 PST 2015");
        Date actualDateTime = new Date(actualDatePart.getTime()+9000000L);
        TimeZone time = TimeZone.getTimeZone("US/Alaska");
        System.out.println(time.inDaylightTime(actualDatePart));
        TimeZone timeZ = TimeZone.getDefault();
        System.out.println(timeZ.getDisplayName());

        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("US/Alaska")); // omit timezone for default tz
        c.setTime(actualDatePart); // your date; omit this line for current date
        System.out.println(c.get(Calendar.DST_OFFSET));

        Date d2 = new Date("Sun Nov 01 00:00:00 PDT 2015");
        Date d3 = new Date("Sun Nov 02 00:00:00 PDT 2015");
        System.out.println(d2.before(d3) + " before");
        DateTime dt = new DateTime(d2.getTime()).plusDays(1);

        System.out.println(dt.toString());
        int x = 127;
        Integer y = 127;
        System.out.println(x==y);

        String a = new String("N");
        String b = "N";

        Map m = new HashMap();
        m.put(a,23);
        m.put(b,23);
        System.out.println(m.size());
    }
}
