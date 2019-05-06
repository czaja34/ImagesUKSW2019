package pl.uksw.images.section7.tasks;

import java.awt.image.BufferedImage;

public class Task1 {

    public BufferedImage task1(BufferedImage image) {
        BufferedImage output = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
        int i = 0;
        int y2 = 0;
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixel = image.getRGB(x, y);
                int a = (pixel >> 24) & 0xff;
                int r = (pixel >> 16) & 0xff;
                int g = (pixel >> 8) & 0xff;
                int b = pixel & 0xff;

                if (r == 255) {
                    i++;
                }
                if (r == 0) {
                    if (i <3) {
                        i = 0;
                    }
                }
                if (i == 3) {
                    a = 255;
                    r = 255;
                    g = 255;
                    b = 255;

                    pixel = (a << 24) | (r << 16) | (g << 8) | b;
                    if (y - 1 >= 0) {
                        y2=y-1;
                        output.setRGB(x, y2, pixel);
                    }
                    i=2;
                }
            }
            i=0;
        }

        return output;

    }
}