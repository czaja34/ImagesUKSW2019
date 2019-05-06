package pl.uksw.images.section7.tasks;

import java.awt.image.BufferedImage;

public class Task2 {
    public BufferedImage task2(BufferedImage image) {

        BufferedImage output = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixelORG = image.getRGB(x, y);
                int aORG = (pixelORG >> 24) & 0xff;
                int rORG = (pixelORG >> 16) & 0xff;
                int gORG = (pixelORG >> 8) & 0xff;
                int bORG = pixelORG & 0xff;
                int result = 0;

               if (y-1>=0 || y+1<image.getHeight()) {
                   if (y-1>=0){
                       int pixel = image.getRGB(x, y-1);
                       int a = (pixel >> 24) & 0xff;
                       int r = (pixel >> 16) & 0xff;
                       int g = (pixel >> 8) & 0xff;
                       int b = pixel & 0xff;
                       if (r == 0){
                           a = 0;
                           r = 0;
                           g = 0;
                           b = 0;
                           result = 1;
                           pixel = (a << 24) | (r << 16) | (g << 8) | b;
                           output.setRGB(x, y, pixel);
                       }
                   }
                   if (y+1<image.getHeight()){
                       int pixel = image.getRGB(x, y+1);
                       int a = (pixel >> 24) & 0xff;
                       int r = (pixel >> 16) & 0xff;
                       int g = (pixel >> 8) & 0xff;
                       int b = pixel & 0xff;
                       if (r == 0){
                           a = 0;
                           r = 0;
                           g = 0;
                           b = 0;
                           result = 1;
                           pixel = (a << 24) | (r << 16) | (g << 8) | b;
                           output.setRGB(x, y, pixel);
                       }
                       }
                   }
                if(result==0){
                    int a = 255;
                    int r = 255;
                    int g = 255;
                    int b = 255;
                    int pixel = (a << 24) | (r << 16) | (g << 8) | b;
                    output.setRGB(x, y, pixel);
                }
                result=0;
            }
        }
        return output;

    }
}
