package pl.uksw.images.section2_3.tasks;

import java.awt.image.BufferedImage;

import static java.lang.Math.log;
import static java.lang.Math.sqrt;

public class Task7 {

    public BufferedImage task7 (BufferedImage image) {
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixel = image.getRGB(x, y);
                int a = (pixel >> 24) & 0xff;
                int r = (pixel >> 16) & 0xff;
                int g = (pixel >> 8) & 0xff;
                int b = pixel & 0xff;


                r = makePixel(r);
                g = makePixel(g);
                b = makePixel(b);
                pixel = (a << 24) | (r << 16) | (g << 8) | b;
                image.setRGB(x, y, pixel);
            }
        }
        return image;
    }

    private int makePixel(int r) {
        if (log(r) < 255 && log(r) > 0) {
            r = (int) (3*log(r));
        } else if (log(r) < 0) {
            r = 0;
        } else {
            r = 255;
        }
        return r;
    }

}
