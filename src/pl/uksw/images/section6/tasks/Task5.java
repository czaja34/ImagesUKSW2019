package pl.uksw.images.section6.tasks;

import java.awt.image.BufferedImage;

public class Task5 {

    public BufferedImage task5(BufferedImage image, int prog, int prog2){

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixel = image.getRGB(x, y);
                int a = (pixel >> 24) & 0xff;
                int r = (pixel >> 16) & 0xff;
                int g = (pixel >> 8) & 0xff;
                int b = pixel & 0xff;
                if(r>prog && r<prog2){
                    r=255;
                }else{
                    r=0;
                }
                if(g>prog && g<prog2){
                    g=255;
                }else{
                    g=0;
                }
                if(b>prog && b<prog2){
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
