package pl.uksw.images.section6.tasks;

import static pl.uksw.images.utils.Utils.findMax;
import static pl.uksw.images.utils.Utils.findMin;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task4 {

    public BufferedImage task4(BufferedImage image, int prog){

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixel = image.getRGB(x, y);
                int a = (pixel >> 24) & 0xff;
                int r = (pixel >> 16) & 0xff;
                int g = (pixel >> 8) & 0xff;
                int b = pixel & 0xff;
                if(r>prog){
                    r=255;
                }else{
                    r=0;
                }
                if(g>prog){
                    g=255;
                }else{
                    g=0;
                }
                if(b>prog){
                    b=255;
                }else{
                    b=0;
                }
                int result=r&g&b;
                r=result;
                g=result;
                b=result;
                pixel = (a << 24) | (r << 16) | (g << 8) | b;
                image.setRGB(x, y, pixel);
            }
        }
        return image;

    }
}
