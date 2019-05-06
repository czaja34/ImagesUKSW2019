package pl.uksw.images.section4.tasks;

import java.awt.image.BufferedImage;

public class Task5 {

    public BufferedImage task5(BufferedImage image, int cX, int cY, int c2X, int c2Y){
        for (int x = cX; x < c2X; x++) {
            for (int y = cY; y < c2Y; y++) {
                int pixel = image.getRGB(x, y);
                int a = (pixel >> 24) & 0xff;
                int r = 0xff;
                int g = 0xff;
                int b = 0xff;

                pixel = (a << 24) | (r << 16) | (g << 8) | b;
                image.setRGB(x, y, pixel);
            }
        }
        return image;
    }
}
