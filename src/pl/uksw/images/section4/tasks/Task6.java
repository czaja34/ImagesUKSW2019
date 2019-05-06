package pl.uksw.images.section4.tasks;

import java.awt.image.BufferedImage;

public class Task6 {

    public BufferedImage task6(BufferedImage image, BufferedImage cutImage, int cX, int cY, int c2X, int c2Y){
        for (int x = cX; x < c2X; x++) {
            for (int y = cY; y < c2Y; y++) {
                int pixel = image.getRGB(x, y);

                int a = (pixel >> 24) & 0xff;
                int r = (pixel >> 16) & 0xff;
                int g = (pixel >> 8) & 0xff;
                int b = pixel & 0xff;

                pixel = (a << 24) | (r << 16) | (g << 8) | b;

                cutImage.setRGB(x-cX,y-cY,pixel);
            }
        }
        return cutImage;
    }
}
