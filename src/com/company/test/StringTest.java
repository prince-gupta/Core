package com.company.test;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Pgupta on 8/5/2015.
 */
public class StringTest {
    public static void main(String[] args) throws ParseException {
        String regex = "\\d+(\\.)?(\\d{1,2})?";
        System.out.println("4".matches(regex));
        System.out.println((new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("Fri Aug 07 00:00:00 IST 2015")).toString());
    }
}
