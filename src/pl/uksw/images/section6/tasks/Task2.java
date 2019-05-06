package pl.uksw.images.section6.tasks;

import java.awt.image.BufferedImage;

public class Task2 {

    public BufferedImage task2(BufferedImage image, int valueR, int valueG, int valueB){
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixel = image.getRGB(x, y);
                int a = (pixel >> 24) & 0xff;
                int r = (pixel >> 16) & 0xff;
                int g = (pixel >> 8) & 0xff;
                int b = pixel & 0xff;

                if (valueR >=0){
                    r+=valueR;
                    if (r>255){
                        r=255;
                    }
                }
                if (valueR < 0){
                    r-=valueR;
                    if (r<0){
                        r=0;
                    }
                }
                if (valueG >=0){
                    g+=valueG;
                    if (g>255){
                        g=255;
                    }
                }
                if (valueG < 0){
                    g-=valueG;
                    if (g<0){
                        g=0;
                    }
                }
                if (valueB >=0){
                    b+=valueB;
                    if (b>255){
                        b=255;
                    }
                }
                if (valueB < 0){
                    b-=valueB;
                    if (b<0){
                        b=0;
                    }
                }
                pixel = (a << 24) | (r << 16) | (g << 8) | b;
                image.setRGB(x, y, pixel);
            }
        }

        return image;
    }
}
