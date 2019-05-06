package pl.uksw.images.section2_3.tasks;

import java.awt.image.BufferedImage;

import static java.lang.Math.pow;

public class Task4 {
    public BufferedImage task4(BufferedImage image, int par) {
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixel = image.getRGB(x, y);
                int a = (pixel >> 24) & 0xff;
                int r = (pixel >> 16) & 0xff;
                int g = (pixel >> 8) & 0xff;
                int b = pixel & 0xff;

                a = makePixel(a, par);
                r = makePixel(r, par);
                g = makePixel(g, par);
                b = makePixel(b, par);


                pixel = (a << 24) | (r << 16) | (g << 8) | b;
                image.setRGB(x, y, pixel);
            }
        }
        return image;
    }

    private int makePixel(int r, int par) {
        if (pow(r, par) <= 255 && pow(r, par) >= 0) {
            r = (int) pow(r, par);
        } else if (pow(r, par) < 0) {
            r = 0;
        } else {
            r = 255;
        }
        return r;
    }
}
