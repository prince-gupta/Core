package com.company.printer;

import java.io.*;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.SimpleDoc;
import javax.print.StreamPrintService;
import javax.print.StreamPrintServiceFactory;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;

public class UseStreamingPrintingServiceInJava {

    private static boolean jobRunning = true;

    public static void main(String[] args) throws Exception {
        // Open the image file
//        InputStream is = new BufferedInputStream(new FileInputStream("myfile.gif"));
        InputStream is = new ByteArrayInputStream("Pradeep Arya PC Default Printer Name :  + serviceDefault.getName()".getBytes());
        // Prepare the output file to receive the postscript
        OutputStream fos = new BufferedOutputStream(new FileOutputStream("myfile.txt"));
        // create a GIF doc flavor
        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        // Locate factories for print services that can be used with
        // a print job to output a stream of data in the GIF format
        StreamPrintServiceFactory[] factories =
                StreamPrintServiceFactory.lookupStreamPrintServiceFactories(
                        DocFlavor.INPUT_STREAM.AUTOSENSE,null);
        // if suitable factory found
        if (factories.length > 0) {
            // get a service that can print to the specified output stream.
            StreamPrintService service = factories[0].getPrintService(fos);
            System.out.println(service.getName());
            // Create and return a PrintJob capable of handling data from
// any of the supported document flavors.
            DocPrintJob printJob = service.createPrintJob();
// register a listener to get notified when the job is complete
            printJob.addPrintJobListener(new JobCompleteMonitor());
// Construct a SimpleDoc with the specified
// print data, doc flavor and doc attribute set.
            Doc doc = new SimpleDoc(is, flavor, null);
// Print a document with the specified job attributes.
            printJob.print(doc, null);
            while (jobRunning) {
                Thread.sleep(1000);
            }
            System.out.println("Exiting app");
            is.close();
            fos.close();
        }
    }

    private static class JobCompleteMonitor extends PrintJobAdapter {
        @Override
        public void printJobCompleted(PrintJobEvent jobEvent) {
            System.out.println("Job completed");
            jobRunning = false;
        }
    }

}