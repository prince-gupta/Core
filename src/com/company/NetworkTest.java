package com.company;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Pgupta on 17-05-2016.
 */
public class NetworkTest {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.google.com");
        System.out.println(url.getContent());
    }
}
