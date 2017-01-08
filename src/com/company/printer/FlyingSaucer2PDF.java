package com.company.printer;

import com.lowagie.text.DocumentException;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.print.*;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.Sides;
import java.awt.*;
import java.io.*;

/**
 * Created by Pgupta on 20-06-2016.
 */
public class FlyingSaucer2PDF {
    public static final String HTML = "F:\\SpiceJet-Test-Docs\\Bagtag.html";
    public static final String PDF = "F:\\SpiceJet-Test-Docs\\BagTag.pdf";

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FlyingSaucer2PDF f = new FlyingSaucer2PDF();
        try {
            f.printPdf();
            f.print(null);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (PrintException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public void printPdf() throws DocumentException, IOException {
        String url = new File(HTML).toURI().toURL().toString();
        OutputStream os = new FileOutputStream(PDF);

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(url);
        renderer.layout();
        renderer.createPDF(os);

        os.close();
    }

    public void print(File file) throws FileNotFoundException, PrintException {
        //PrinterService ps = new PrinterService();
        // get the printer service by printer name
        PrintService pss = PrintServiceLookup.lookupDefaultPrintService();// ps.getCheckPrintService("Samsung ML-2850 Series PCL6 Class Driver");
        System.out.println("Printer - " + pss.getName());
        DocPrintJob job = pss.createPrintJob();
        DocAttributeSet das = new HashDocAttributeSet();
        Doc document = new SimpleDoc(new FileInputStream(new File(PDF)), DocFlavor.INPUT_STREAM.AUTOSENSE, das);
        // new htmldo
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        job.print(document, pras);
        //print2(new File(PDF));
    }


    public void print2(File doc) throws PrintException, FileNotFoundException {
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        aset.add(new Copies(1));
        aset.add(Sides.ONE_SIDED);
        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
        PrintService service = ServiceUI.printDialog(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration(), 200, 200,
                printService, defaultService, flavor, pras);
        if (service != null) {
            DocPrintJob job = service.createPrintJob();
            FileInputStream fis = new FileInputStream(doc);
            DocAttributeSet das = new HashDocAttributeSet();
            Doc document = new SimpleDoc(fis, flavor, das);
            job.print(document, pras);
        }
    }


}
