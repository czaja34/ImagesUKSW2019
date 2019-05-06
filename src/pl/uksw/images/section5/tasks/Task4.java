package pl.uksw.images.section5.tasks;

import static pl.uksw.images.utils.Utils.findMax;
import static pl.uksw.images.utils.Utils.findMin;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task4 {

    public BufferedImage task4(BufferedImage image){

        BufferedImage output = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
        List<Integer> pixels1 = new ArrayList<>(Arrays.asList());
        List<Integer> pixels2 = new ArrayList<>(Arrays.asList());
        List<Integer> pixels3 = new ArrayList<>(Arrays.asList());
        List<Integer> pixels4 = new ArrayList<>(Arrays.asList());

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                if (x<=image.getWidth()/2 && y<=image.getHeight()/2){
                    int pixel = image.getRGB(x, y);
                    int r = (pixel >> 16) & 0xff;
                    pixels1.add(r);
                }
                if (x>image.getWidth()/2 && y<=image.getHeight()/2){
                    int pixel = image.getRGB(x, y);
                    int r = (pixel >> 16) & 0xff;
                    pixels2.add(r);
                }
                if (x<=image.getWidth()/2 && y>image.getHeight()/2){
                    int pixel = image.getRGB(x, y);
                    int r = (pixel >> 16) & 0xff;
                    pixels3.add(r);
                }
                if (x>image.getWidth()/2 && y>image.getHeight()/2){
                    int pixel = image.getRGB(x, y);
                    int r = (pixel >> 16) & 0xff;
                    pixels4.add(r);
                }
            }
        }
        for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    int pixel = image.getRGB(x, y);
                    int a = (pixel >> 24) & 0xff;
                    int r = (pixel >> 16) & 0xff;
                    int g = (pixel >> 8) & 0xff;
                    int b = pixel & 0xff;
                    if (x<=image.getWidth()/2 && y<=image.getHeight()/2){
                        double t = (findMin(pixels1) + findMax(pixels1))/2;
                        if(r>t){
                            r=255;
                        }else{
                            r=0;
                        }
                        g = r;
                        b = r;
                    }
                    if (x>image.getWidth()/2 && y<=image.getHeight()/2){
                        double t = (findMin(pixels2) + findMax(pixels1))/2;
                        if(r>t){
                            r=255;
                        }else{
                            r=0;
                        }
                        g = r;
                        b = r;
                    }
                    if (x<=image.getWidth()/2 && y>image.getHeight()/2){
                        double t = (findMin(pixels3) + findMax(pixels1))/2;
                        if(r>t){
                            r=255;
                        }else{
                            r=0;
                        }
                        g = r;
                        b = r;
                    }
                    if (x>image.getWidth()/2 && y>image.getHeight()/2){
                        double t = (findMin(pixels4) + findMax(pixels1))/2;
                        if(r>t){
                            r=255;
                        }else{
                            r=0;
                        }
                        g = r;
                        b = r;
                    }
                    pixel = (a << 24) | (r << 16) | (g << 8) | b;
                    output.setRGB(x, y, pixel);
                }
        }

        return output;
    }
}
