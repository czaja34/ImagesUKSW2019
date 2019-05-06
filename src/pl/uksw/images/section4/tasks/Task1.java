package pl.uksw.images.section4.tasks;

import java.awt.image.BufferedImage;

public class Task1 {

    public BufferedImage task1(BufferedImage image, BufferedImage resized, int cX, int cY){
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixel = image.getRGB(x, y);
                int a = (pixel >> 24) & 0xff;
                int r = (pixel >> 16) & 0xff;
                int g = (pixel >> 8) & 0xff;
                int b = pixel & 0xff;

                pixel = (a << 24) | (r << 16) | (g << 8) | b;

                resized.setRGB(x + cX, y+cY, pixel);
            }
        }
        return resized;
    }
}
