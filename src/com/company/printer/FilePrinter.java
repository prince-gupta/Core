package com.company.printer;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Pgupta on 20-06-2016.
 */
public class FilePrinter {
    public static void main(String[] args) throws IOException {
        File ff = new File("f:\\hello.html");

        Desktop desktop = Desktop.getDesktop();
        desktop.print(ff);
    }
}
