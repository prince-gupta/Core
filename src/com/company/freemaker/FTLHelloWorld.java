package com.company.freemaker;

/**
 * Created by Pgupta on 21-06-2016.
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FTLHelloWorld {

    public static void main(String[] args) {

        //Freemarker configuration object
        Configuration cfg = new Configuration();
        try {
            //Load template from source folder
            //Template template = cfg.getTemplate("F:/Workspace/Core/src/com/company/freemaker/BoardingPass.ftl");
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
            Writer file = new FileWriter (new File("F:\\BoardingPass.html"));
            template.process(data, file);
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}