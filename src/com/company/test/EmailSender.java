package com.company.test;

import java.util.HashMap;
import java.util.Map;

public class EmailSender {
    public static void main(String[] args) {
        // Declare the object and initialize with

        String[][] emails = new String[][]{
                {"abc@gmail.com", "xyz@gmail.com, trn@gmail.com"},
                {"xyz@gmail.com", "apm@gmail.com, tpm@gmail.com"},
                {"tpm@gmail.com", "htp@gmail.com, yup@gmail.com"}
        };

        HashMap<String, String> emailMap = new HashMap<>();


        for (int row = 0; row < emails.length; row++) {
            emailMap.put(emails[row][0], emails[row][1]);
        }

        EmailSender emailSender = new EmailSender();
        emailSender.sendMail(emailMap, "abc@gmail.com");
    }


    public void sendMail(Map<String, String> emailMap, String fromMail) {

        String toEmails = emailMap.get(fromMail);
        if (toEmails == null) {
            return;
        }

        String[] toEmailsSplitted = toEmails.split(",");
        for (String toEmail : toEmailsSplitted) {
            if (!toEmail.equals(fromMail.trim())) {
                System.out.println("Sending mail to " + toEmail);
                sendMail(emailMap, toEmail.trim());
            }
        }

    }
}
