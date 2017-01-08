package com.company.printer;

/**
 * Created by Pgupta on 30-06-2016.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_pdf {
    public static void main(String[] args) throws IOException {
        try
        {
            String htmlFilePath = "E:/SpiceJetTemp.html";
            String pdfFilePath = "E:/SpiceJetTemp.pdf";
            ProcessBuilder pb = new ProcessBuilder("F:\\Workspace\\Core\\src\\com\\company\\printer\\wkhtmltopdf.exe", htmlFilePath, pdfFilePath);
            pb.redirectErrorStream(true);
            Process process = pb.start();
            BufferedReader inStreamReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line = inStreamReader.readLine();

            while(line != null)
            {
                System.out.println(line);
                line = inStreamReader.readLine();
            }
        }
        catch(Exception e)
        {
            System.out.println("coming-->"+e.getMessage() );
        }
    }
}
