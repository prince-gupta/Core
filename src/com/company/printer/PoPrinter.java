/*
package com.company.printer;

*/
/**
 * Created by Pgupta on 01-07-2016.
 *//*


import java.io.OutputStream;


        import java.io.IOException;
        import java.io.OutputStream;
        import java.util.Enumeration;

        import javax.comm.CommPortIdentifier;
        import javax.comm.SerialPort;

public class PosPrinter {
    public static Enumeration printport = CommPortIdentifier
            .getPortIdentifiers();

    */
/**
     * This method is used to create the stream to the printer.
     *//*

    public static OutputStream getStream(String port) throws Exception {
        while (printport.hasMoreElements()) {
            CommPortIdentifier portid = (CommPortIdentifier) printport
                    .nextElement();
            if (portid.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                if (portid.getName().equals(port)) {
                    SerialPort com = (SerialPort) portid.open("ListPortClass",
                            300);
                    com.setSerialPortParams(9600, SerialPort.DATABITS_8,
                            SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                    OutputStream output = com.getOutputStream();
                    return output;
                }
            }
        }
        return null;
    }

    */
/**
     * This method can be used to create a line
     *//*

    public void printLine(String line, OutputStream outputStream)
            throws IOException {
        final byte[] bytes = line.getBytes("UTF-8");
        outputStream.write(bytes);
        newLine(outputStream);
    }

    */
/**
     * Writes a new line in the printer
     *//*

    public void newLine(OutputStream outputStream) throws IOException {
        outputStream.write(new byte[] { 10, 13 });
    }

    private static final byte PRINTER = 1;
    private static final byte DRAWER = 1;
    private static final byte DISPLAY = 2;

    */
/**
     * Since the printer is connected to the customer display we need to switch
     * between. below code is necessary for that purpose.
     *//*

    public void prepareResource(OutputStream outputStream) {
        try {
            outputStream.write(new byte[] { 27, 61, PRINTER });
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}*/
