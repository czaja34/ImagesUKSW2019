package pl.uksw.images.section1;

import java.awt.image.BufferedImage;

public class Task1 {

    public BufferedImage task1(BufferedImage imageA, BufferedImage imageB) {

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

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < imageA.getHeight() - imageB.getHeight(); y++) {
                int pixel = imageA.getRGB(x, y);
                int a = (pixel >> 24) & 0xff;
                int r = 0;
                int g = 0;
                int b = 0;
                pixel = (a << 24) | (r << 16) | (g << 8) | b;
                imageA.setRGB(x, y, pixel);
            }
        }

        for (int x = 0; x < width; x++) {
            for (int y = imageA.getHeight() - imageB.getHeight(); y < hight; y++) {
                int pixel = imageA.getRGB(x, y);
                int a = (pixel >> 24) & 0xff;
                int r = 0;
                int g = 0;
                int b = 0;

                if (x < imageB.getWidth()) {
                    pixel = imageB.getRGB(x, y-(imageA.getHeight() - imageB.getHeight()));
                    r = (pixel >> 16) & 0xff;
                    g = (pixel >> 8) & 0xff;
                    b = pixel & 0xff;
                }
                pixel = (a << 24) | (r << 16) | (g << 8) | b;
                imageA.setRGB(x, y, pixel);
            }
        }

        return imageB;
    }

}
