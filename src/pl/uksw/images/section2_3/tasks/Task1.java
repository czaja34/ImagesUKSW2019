package pl.uksw.images.section2_3.tasks;

import java.awt.image.BufferedImage;

import static java.awt.image.BufferedImage.TYPE_BYTE_INDEXED;

public class Task1 {

    public BufferedImage task1a(BufferedImage image, int par) {
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixel = image.getRGB(x, y);
                int a = (pixel >> 24) & 0xff;
                int r = (pixel >> 16) & 0xff;
                int g = (pixel >> 8) & 0xff;
                int b = pixel & 0xff;

                if (r + par <= 255 && r + par >= 0) {
                    r += par;
                    g += par;
                    b += par;
                } else if (r + par < 0) {
                    r = 0;
                    g = 0;
                    b = 0;
                } else {
                    r = 255;
                    g = 255;
                    b = 255;
                }
                pixel = (a << 24) | (r << 16) | (g << 8) | b;
                image.setRGB(x, y, pixel);
            }
        }
        return image;
    }

    public BufferedImage task1b(BufferedImage imageA, BufferedImage imageB, int param) {


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

                int a = ((pixelA >> 24) & 0xff);
                int r = ((pixelA >> 16) & 0xff + (pixelB >> 16) & 0xff)+param;
                int g = ((pixelA >> 8) & 0xff + (pixelB >> 8) & 0xff)+param;
                int b = (pixelA & 0xff + pixelB & 0xff) +param;
                pixel = (a << 24) | (r << 16) | (g << 8) | b;
                image.setRGB(x, y, pixel);
            }
        }
        return image;

    }

}
