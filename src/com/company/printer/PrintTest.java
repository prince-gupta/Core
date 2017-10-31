package com.company.printer;

/**
 * Created by Pgupta on 23-06-2016.
 */

import org.apache.pdfbox.pdmodel.PDDocument;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.*;
import javax.print.*;
import javax.print.attribute.*;

public class PrintTest{

    public static void main(String args[]) throws PrinterException, IOException {

        FileInputStream psStream = null;
        try {
            psStream = new FileInputStream("F:\\BoardingPassTest.pdf");
        } catch (FileNotFoundException ffne) {
            ffne.printStackTrace();
        }
        if (psStream == null) {
            return;
        }
        DocFlavor psInFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
        Doc myDoc = new SimpleDoc(psStream, psInFormat, null);
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();

        PrintService[] services = PrintServiceLookup.lookupPrintServices(psInFormat, aset);

        // this step is necessary because I have several printers configured
        PrintService myPrinter = null;
        for (int i = 0; i < services.length; i++){
            System.out.println("service found: "+services[i].getName());
            String svcName = services[i].toString();
            if (svcName.contains("HP LaserJet P1007")){
                myPrinter = services[i];
                System.out.println("my printer found: "+svcName);
                break;
            }
        }

        if (myPrinter != null) {
            //DocPrintJob job = myPrinter.createPrintJob();
            //PrintJobWatcher pjDone = new PrintJobWatcher(job);
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintService(myPrinter);
            PDDocument document = PDDocument.load(new File("F:\\BagtagTest.pdf"));
            try {
              //  job.print(myDoc, aset);
                //pjDone.waitForDone();
               // document.silentPrint(job);
                psStream.close();

            } catch (Exception pe) {pe.printStackTrace();}
        } else {
            System.out.println("no printer services found");
        }
    }

    public static void printPDF(String fileName, PrintService printer)
            throws IOException, PrinterException {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintService(printer);
        PDDocument doc = PDDocument.load(new File(""));
       // doc.silentPrint(job);
    }
}
