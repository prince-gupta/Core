package com.company.reverEngineering;

import java.io.*;
import java.text.DecimalFormat;

/**
 * Created by Pgupta on 08-03-2016.
 */
public class VS {

    public static void main (String args[]){
        VS vs = new VS();
        vs.loadLogo("F:\\Workspace\\Core\\src\\com\\company\\reverEngineering\\logo.pcx", "0E", 1);
    }

    public void loadLogo(String paramString1, String paramString2, int paramInt) {
        StringBuffer localStringBuffer = null;
        int i = -1;
        int j = paramInt;
        int k = 0;
        do {
            k++;
            try {
                DecimalFormat localDecimalFormat = new DecimalFormat("0000");
                byte[] arrayOfByte1 = loadResource(paramString1);
                if (arrayOfByte1 != null) {
                    localStringBuffer = new StringBuffer("LT");
                    localStringBuffer.append(paramString2);
                    localStringBuffer.append(localDecimalFormat.format(arrayOfByte1.length));
                    byte[] arrayOfByte2 = new byte[localStringBuffer.length() + arrayOfByte1.length];
                    System.arraycopy(localStringBuffer.toString().getBytes(), 0, arrayOfByte2, 0, localStringBuffer.length());
                    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, localStringBuffer.length(), arrayOfByte1.length);

                    //System.out.print(arrayOfByte2);
                }
                j--;
                if ((i != 0) && (j > 0))
                    Thread.sleep(1000L);
            } catch (Exception localException) {
            }
        }
        while ((i != 0) && (j > 0));
    }

    public byte[] loadResource(String paramString){
        byte[] arrayOfByte = null;
        File logoFile = new File(paramString);
        InputStream localInputStream;
        try {
            localInputStream = new BufferedInputStream(new FileInputStream(logoFile));
            if (localInputStream != null) {
                int i = localInputStream.available();
                arrayOfByte = new byte[i];
                int j = 0;
                int k = 0;
                while (((k = localInputStream.read(arrayOfByte, j, i - j)) != -1) && (j < i))
                    j += k;
                if (j != i)
                    localInputStream.close();
            } else {
            }
        } catch (IOException localIOException) {
            localIOException.printStackTrace();
        }
        return arrayOfByte;
    }
}
