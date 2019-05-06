package pl.uksw.images.section6.tasks;

import static pl.uksw.images.utils.Utils.findMax;
import static pl.uksw.images.utils.Utils.findMin;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task7 {

    public List<Integer> r(BufferedImage image){
        List<Integer> pixels = new ArrayList<>(Arrays.asList());
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixel = image.getRGB(x, y);
                int r = (pixel >> 16) & 0xff;
                pixels.add(r);
            }
        }
        return pixels;
    }

    public List<Integer> g(BufferedImage image){
        List<Integer> pixels = new ArrayList<>(Arrays.asList());
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixel = image.getRGB(x, y);
                int g = (pixel >> 8) & 0xff;
                pixels.add(g);
            }
        }
        return pixels;
    }

    public List<Integer> b(BufferedImage image){
        List<Integer> pixels = new ArrayList<>(Arrays.asList());
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixel = image.getRGB(x, y);
                int b = pixel & 0xff;
                pixels.add(b);
            }
        }
        return pixels;
    }

    public BufferedImage task7(BufferedImage image){
        List<Integer> rPix = new ArrayList<>(Arrays.asList());
        rPix=r(image);
        List<Integer> gPix = new ArrayList<>(Arrays.asList());
        gPix=g(image);
        List<Integer> bPix = new ArrayList<>(Arrays.asList());
        bPix=b(image);
        int tR = (findMax(rPix) + findMin(rPix))/2;
        int tG = (findMax(gPix) + findMin(gPix))/2;
        int tB = (findMax(bPix) + findMin(bPix))/2;

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixel = image.getRGB(x, y);
                int a = (pixel >> 24) & 0xff;
                int r = (pixel >> 16) & 0xff;
                int g = (pixel >> 8) & 0xff;
                int b = pixel & 0xff;
                if(r>tR){
                    r=255;
                }else{
                    r=0;
                }
                if(g>tG){
                    g=255;
                }else{
                    g=0;
                }
                if(b>tB){
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
