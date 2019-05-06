package pl.uksw.images.section2_3.tasks;

import java.awt.image.BufferedImage;

import static java.awt.image.BufferedImage.TYPE_BYTE_INDEXED;

public class Task5 {


    public BufferedImage task1a(BufferedImage image, int par) {
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixel = image.getRGB(x, y);
                int a = (pixel >> 24) & 0xff;
                int r = (pixel >> 16) & 0xff;
                int g = (pixel >> 8) & 0xff;
                int b = pixel & 0xff;

                a = makePixels(a, par);
                r = makePixels(r, par);
                g = makePixels(g, par);
                b = makePixels(b, par);

                pixel = (a << 24) | (r << 16) | (g << 8) | b;
                image.setRGB(x, y, pixel);
            }
        }
        return image;
    }

    private int makePixels(int r, int par) {
        if (r / par <= 255 && r / par >= 0) {
            r /= par;
        } else if (r / par < 0) {
            r = 0;
        } else {
            r = 255;
        }
        return r;
    }

    public BufferedImage task1b(BufferedImage imageA, BufferedImage imageB) {


        int width;
        int hight;

        if (imageA.getWidth() > imageB.getWidth())
            width = imageA.getWidth();
        else
            width = imageB.getWidth();

        if (imageA.getHeight() > imageB.getHeight())
            hight = imageA.getHeight();
        else
            hight = imageB.getHeight();

        BufferedImage image = new BufferedImage(width, hight, TYPE_BYTE_INDEXED);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < hight; y++) {
                int pixel;
                int pixelA;
                int pixelB;
                try {
                    pixelA = imageA.getRGB(x, y);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    pixelA = 0;
                }

                try {
                    pixelB = imageB.getRGB(x, y);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    pixelB = 0;
                }
                double pix;

                int a = (pixelA >> 24) & 0xff;

                double r = (pixelA >> 16) & 0xff;
                double r1 = (pixelB >> 16) & 0xff;
                if (r1 != 0) {
                    pix = r / r1;
                    r = 100 * pix;                }
                double g = (pixelA >> 8) & 0xff;
                double g1 = (pixelB >> 8) & 0xff;
                if (g1 != 0) {
                    pix = g / g1;
                    g = 100 * pix;
                }
                double b = pixelA & 0xff;
                double b1 = pixelB & 0xff;
                if (b1 != 0) {
                    pix = b / b1;
                    b = 100 * pix;
                }
                pixel = (a << 24) | ((int)r << 16) | ((int)g << 8) | (int)b;
                image.setRGB(x, y, pixel);
            }
        }
        return image;

    }

}
