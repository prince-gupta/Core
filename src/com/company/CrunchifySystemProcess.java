package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Crunchify.com
 *
 */

public class CrunchifySystemProcess {
    public static void main(String[] args) throws IOException {
        try {
            String process;
            // getRuntime: Returns the runtime object associated with the current Java application.
            // exec: Executes the specified string command in a separate process.
            Process p = Runtime.getRuntime().exec("ps -few");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((process = input.readLine()) != null) {
                System.out.println(process); // <-- Print all Process here line
                // by line
            }
            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}
