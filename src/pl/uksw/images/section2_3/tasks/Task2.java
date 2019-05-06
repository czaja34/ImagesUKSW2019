package pl.uksw.images.section2_3.tasks;

import java.awt.image.BufferedImage;

import static java.awt.image.BufferedImage.TYPE_BYTE_INDEXED;

public class Task2 {

    public BufferedImage task1a(BufferedImage image, int par,int param) {
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixel = image.getRGB(x, y);
                int a = (pixel >> 24) & 0xff;
                int r = (pixel >> 16) & 0xff;
                int g = (pixel >> 8) & 0xff;
                int b = pixel & 0xff;
                int tab[] = new int[4];
                tab[0] = a;
                tab[1] = r;
                tab[2] = g;
                tab[3] = b;
                for (int i = 1; i < 4; i++) {
//                    if (tab[i] * par <= 255 && tab[i] * par >= 0) {
                        tab[i] *= par;
//                    }
//                    else if (tab[i] * par < 0) {
//                        tab[i] = 0;
//                    } else {
//                        tab[i] = 255;
//                    }
                }
//                tab[1]+=param;
//                tab[2]+=param;
//                tab[3]+=param;
                pixel = (tab[0] << 24) | (tab[1] << 16) | (tab[2] << 8) | tab[3];
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
                    pixelA = 1;
                }

                try {
                    pixelB = imageB.getRGB(x, y);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    pixelB = 1;
                }
                int a;
                if (pixelA == 1) {
                    a = (pixelB >> 24) & 0xff;
                } else if (pixelB == 1) {
                    a = (pixelA >> 24) & 0xff;
                } else {
                    a = 255;
                }

                int r = ((pixelA >> 16) & 0xff);
                int r1 = ((pixelB >> 16) & 0xff);
                if (pixelA == 1) {
                    r = r1;
                } else if (pixelB == 1) {
                    r *= 1;
                } else {
                    r *= r1;
                }
                if (r > 255) {
                    r = 255;
                } else if (r < 0) {
                    r = 0;
                }
                int g = (pixelA >> 8) & 0xff;
                int g1 = (pixelB >> 8) & 0xff;
                if (pixelA == 1) {
                    g = g1;
                } else if (pixelB == 1) {
                    g *= 1;
                } else {
                    g *= g1;
                }
                if (g > 255) {
                    g = 255;
                } else if (g < 0) {
                    g = 0;
                }
                int b = (pixelA & 0xff);
                int b1 = (pixelB & 0xff);
                if (pixelA == 1) {
                    b = b1;
                } else if (pixelB == 1) {
                    b *= 1;
                } else {
                    b *= b1;
                }
                if (b > 255) {
                    b = 255;
                } else if (b < 0) {
                    b = 0;
                }
                r+=param;
                g+=param;
                b+=param;
                pixel = (a << 24) | (r << 16) | (g << 8) | b;
                image.setRGB(x, y, pixel);
            }
        }
        return image;

    }

}

