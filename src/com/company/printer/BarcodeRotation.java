package com.company.printer;

import com.sun.javafx.iio.ImageStorage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Pgupta on 30-06-2016.
 */
public class BarcodeRotation {
    public static void main(String[] args) throws IOException {
        BufferedImage buffer = ImageIO.read(new File("C:\\CUSSUSERS\\SG\\Barcode.png"));
        /*AffineTransform tx = new AffineTransform();

        tx.rotate(0.5 * 90 * Math.PI, 10, 100);

        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        buffer = op.filter(buffer, null);
        //BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("C:\\CUSSUSERS\\SG\\Barcode-rotated.png"));*/
        buffer = rotate(buffer,0.5 * 45 * Math.PI);
        ImageIO.write(buffer,"png",new File("C:\\CUSSUSERS\\SG\\Barcode-rotated.png"));
    }

    public static BufferedImage rotate(BufferedImage image, double angle) {
        double sin = Math.abs(Math.sin(angle)), cos = Math.abs(Math.cos(angle));
        int w = image.getWidth(), h = image.getHeight();
        int neww = (int)Math.floor(w*cos+h*sin), newh = (int) Math.floor(h * cos + w * sin);
        GraphicsConfiguration gc = getDefaultConfiguration();
        BufferedImage result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
        Graphics2D g = result.createGraphics();
        g.translate((neww - w) / 2, (newh - h) / 2);
        g.rotate(angle, w / 2, h / 2);
        g.drawRenderedImage(image, null);
        g.dispose();
        return result;
    }

    private static GraphicsConfiguration getDefaultConfiguration() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        return gd.getDefaultConfiguration();
    }
}
