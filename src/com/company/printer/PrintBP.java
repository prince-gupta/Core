package com.company.printer;

import com.lowagie.text.DocumentException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pgupta on 21-06-2016.
 */
public class PrintBP {

    public static final String HTML = "F:\\BoardingPassTest.html";
    public static final String PDF = "F:\\BoardingPassTest.pdf";

    public void printPdf() throws DocumentException, IOException {
        String url = new File(HTML).toURI().toURL().toString();
        OutputStream os = new FileOutputStream(PDF);

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(url);
        renderer.layout();
        renderer.createPDF(os);

        os.close();
    }

    public void prepareHTML(){
        //Freemarker configuration object
        Configuration cfg = new Configuration();
        try {
            //Load template from source folder
            Template template = cfg.getTemplate("src/BoardingPass.ftl");

            // Build the data-model
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("full_name", "GUPTA/PRINCE");
            data.put("dateOfFlight","17JUN16");
            data.put("recordLocator","45s54d");

            // Console output
            Writer out = new OutputStreamWriter(System.out);
            template.process(data, out);
            out.flush();

            // File output
            Writer file = new FileWriter (new File(HTML));
            template.process(data, file);
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    public void printBP() throws IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.print(new File(PDF));
    }

    public static void main(String[] args) throws IOException, DocumentException {
        PrintBP printBP = new PrintBP();
        printBP.prepareHTML();
        printBP.printPdf();
        printBP.printBP();
    }
}
