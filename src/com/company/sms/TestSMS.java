package com.company.sms;

/**
 * Created by Pgupta on 04-12-2016.
 */
class TestSMS {

    public static void main(String[] args) {

        SMS smsClient=new SMS();
        smsClient.send( "9718042666", "P6225A", "8130768666", "Hello", "");
    }
}