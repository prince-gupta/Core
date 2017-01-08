package com.company.printer;

import javax.print.*;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.PrintQuality;
import java.io.IOException;

public class CustomPrinter {
    public static void main(String[] args) throws IOException, PrintException {

//        DocFlavor flavor = DocFlavor.URL.GIF;

//        AttributeSet attrs = new HashAttributeSet();
//        attrs.add(ColorSupported.SUPPORTED);
//        attrs.add(OrientationRequested.LANDSCAPE);


//        PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
//        PrintService svc = PrintServiceLookup.lookupDefaultPrintService();
//        PrintRequestAttributeSet attrss = new HashPrintRequestAttributeSet();
//        PrintService selection = ServiceUI.printDialog(
//                null, 100, 100, services, svc, null, attrss);
//        System.out.println(".........All Printers...........");
//        for (int i = 0; i < services.length; i++) {
//            System.out.println(services[i].getName());
//        }
//        PrintService serviceMultiDoc = PrintServiceLookup.lookupMultiDocPrintServices();

        PrintService serviceDefault = PrintServiceLookup.lookupDefaultPrintService();
        System.out.println("Default Printer Name : " + serviceDefault.getName());
        //InputStream in = new ByteArrayInputStream("3CP#1C01#01V#05HU/HAISHENGMR      #06INF/BABYNAME        #08CA #10984  #11@12#14MFFPXK#151400#1713#1821JUL#191330#2029C#2123A #22016#28ETKT#299994132451592/1#30LOS ANGELES#31LAX#32R#33Y#35BEIJING#36PEK#39XXX#40SOLD AS#41UA #427617 #43UA NGX85073#44G#50135734244#53R#5529B#56SSSS#57TCI#61CA984  2129CLAX016#63北京#64UA*G#663#69API#71M1HU/HAISHENGMR       EMFFPXK LAXPEKCA 0984 202S029C0016 100#72M1HU/HAISHENGMR               LAXPEKCA 0984 293Y029C0002 15C>3181O 3293BCA              29999          00CA                     2PC*30600000K0900       #77155#A1@@03#$\f".getBytes());
//        FileInputStream in = new FileInputStream(new File("D:/foo.txt"));
          byte[] in ="<html><h1>Hello</h1></html>".getBytes();
//        DocFlavor flavor = DocFlavor.INPUT_STREAM.PCL;
//        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        System.out.println("Media Sub Type : " + flavor.getMediaSubtype());
        System.out.println("Media Type : "+flavor.getMediaType());
        System.out.println("MIME Type : "+flavor.getMimeType());
        System.out.println("Representation Class Name : "+flavor.getRepresentationClassName());
        DocAttributeSet attrs = new HashDocAttributeSet();
        attrs.add(PrintQuality.HIGH);
        Doc doc = new SimpleDoc(in, flavor, attrs);
//        Pageable pageable = new Book();
//        Doc doc = new PageableDoc(pageable);

        System.out.println("Stream : "+doc.getStreamForBytes().read());
        PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
        printRequestAttributeSet.add(new Copies(2));
        DocPrintJob job = serviceDefault.createPrintJob();
        // in.close();
        job.print(doc, null);

    }
}
