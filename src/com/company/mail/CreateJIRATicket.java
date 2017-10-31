package com.company.mail;

/**
 * Created by Pgupta on 02-12-2016.
 */

import javax.mail.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.Properties;

public class CreateJIRATicket {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect("outlook.office365.com", "princegupta@xebia.com", "Somu@8111988");
            Folder inbox = store.getFolder("COIN/COIN-ICINGA-NAGIOS");
            inbox.open(Folder.READ_ONLY);
            Message msg = inbox.getMessage(inbox.getMessageCount());
            Address[] in = msg.getFrom();
            for (Address address : in) {
                System.out.println("FROM:" + address.toString());
            }
            String type = msg.getContentType();
            String message = "";
            boolean isText = false;
            BodyPart bp = null;
            if (type.contains("text")) {
                message = msg.getContent().toString();
                isText = true;
            }
            else {
                Multipart mp = (Multipart) msg.getContent();
                 bp= mp.getBodyPart(0);
            }
            System.out.println("SENT DATE:" + msg.getSentDate());
            System.out.println("SUBJECT:" + msg.getSubject());
            if(isText)
                System.out.println("CONTENT:" + msg.getContent());
            else
                System.out.println("CONTENT:" + bp.getContent());
        } catch (Exception mex) {
            mex.printStackTrace();
        }
    }

    public void createJiraTicket(){
        try {
            URL url = new URL ("https://devcoin.atlassian.net/rest/api/2/issue/");
            String encoding = Base64.getEncoder().encodeToString("dev.prince.gupta@outlook.com:goluammu03@014".getBytes("u‌​tf-8"));

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty  ("Authorization", "Basic " + encoding);
            //connection.set
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
