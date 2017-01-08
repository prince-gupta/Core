package com.company.printer;

/**
 * Created by Pgupta on 20-06-2016.
 */
import java.io.*;

import java.net.*;
import java.nio.charset.StandardCharsets;

public class PrintToPrinter{

    public static void main(String [] args) throws Exception {

        Socket socket = new Socket("localhost", 9100);

        //InputStream is = new FileInputStream(new File("/opt/PDF/test.ps"));

        DataOutputStream os = new DataOutputStream(socket.getOutputStream());

        byte [] byte_array = "<html><body><table><tr><td>Hello</td></tr></table></body></html>".getBytes(StandardCharsets.UTF_8);


        InputStream stream = new ByteArrayInputStream(byte_array);

        BufferedInputStream bis = new BufferedInputStream(stream);

        DataInputStream dis = new DataInputStream(bis);


        while(stream.available() != 0) {

            os.write(dis.readByte());

        }



        os.close();

        dis.close();

        bis.close();

        stream.close();


    }

}