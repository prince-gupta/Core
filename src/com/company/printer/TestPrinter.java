package com.company.printer;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by Pgupta on 21-06-2016.
 */
public class TestPrinter {
    public static void main(String[] args) throws IOException {
        try {

            FileOutputStream os = new FileOutputStream("COM3");

            PrintStream ps = new PrintStream(os);

            ps.println("Hello world!");

            // use f for form feed -- may be needed at end of text block

            ps.print("f");

            ps.close();

        }

        catch (Exception e)

        {
            e.printStackTrace();

        }
    }
}
