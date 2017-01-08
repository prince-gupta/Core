package com.company.barcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.pdf417.PDF417Writer;
import com.google.zxing.pdf417.encoder.Dimensions;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

/**
 * Created by Pgupta on 01-07-2016.
 */
public class PDF417Generator {
    public static void main(String[] args) {
        PDF417Generator.generate("hello");
    }

    public static void generate(String content) {
        System.out.println("content : " + content);
        PDF417Writer pdf417Writer = new PDF417Writer();
        BitMatrix matrix;
        try {
            Map<EncodeHintType, Object> hints = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
            hints.put(EncodeHintType.MARGIN, 0);
            matrix = pdf417Writer.encode(content, BarcodeFormat.PDF_417, 0,0,hints);
            MatrixToImageWriter.writeToStream(matrix, "png",
                    new FileOutputStream(("E://Barcode-Test-1.png")));
            BufferedImage buffer = ImageIO.read(new File("E://Barcode-Test-1.png"));
            System.out.println(buffer
            .getWidth());
            BufferedImage buffer1 = scale(buffer,BufferedImage.TYPE_INT_ARGB,100,50,0.48,1);
            ImageIO.write(buffer1, "png", new File("E://Barcode-Test-2.png"));
        } catch (IOException e) {
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage resizeImage(BufferedImage originalImage, int type){
        BufferedImage resizedImage = new BufferedImage(250, 100, originalImage.getType());
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, 100, 100, null);
        g.dispose();

        return resizedImage;
    }

    public static BufferedImage scale(BufferedImage sbi, int imageType, int dWidth, int dHeight, double fWidth, double fHeight) {
        BufferedImage dbi = null;
        if(sbi != null) {
            dbi = new BufferedImage(dWidth, dHeight, imageType);
            Graphics2D g = dbi.createGraphics();
            System.out.println((dWidth/(sbi.getWidth())));
            System.out.println((double)2/5);
            double d = (double) 100/206;
            System.out.println(d);
            AffineTransform at = AffineTransform.getScaleInstance(fWidth, fHeight);
            g.drawRenderedImage(sbi, at);
        }
        return dbi;
    }
}
