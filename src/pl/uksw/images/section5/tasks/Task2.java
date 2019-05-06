package pl.uksw.images.section5.tasks;

import java.awt.image.BufferedImage;

public class Task2 {

    public BufferedImage task2(BufferedImage image, int value){
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixel = image.getRGB(x, y);
                int a = (pixel >> 24) & 0xff;
                int r = (pixel >> 16) & 0xff;
                int g = (pixel >> 8) & 0xff;
                int b = pixel & 0xff;

                if (value >=0){
                    r+=value;
                    if (r>255){
                        r=255;
                    }
                }
                if (value < 0){
                    r-=value;
                    if (r<0){
                        r=0;
                    }
                }
                pixel = (a << 24) | (r << 16) | (g << 8) | b;
                image.setRGB(x, y, pixel);
            }
        }

        return image;
    }
}
