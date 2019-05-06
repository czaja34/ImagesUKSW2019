package pl.uksw.images.section6.tasks;

import static pl.uksw.images.utils.Utils.findMax;
import static pl.uksw.images.utils.Utils.findMin;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task6 {
    public BufferedImage task6(BufferedImage image){

        BufferedImage output = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
        List<Integer> pixels1R = new ArrayList<>(Arrays.asList());
        List<Integer> pixels2R = new ArrayList<>(Arrays.asList());
        List<Integer> pixels3R = new ArrayList<>(Arrays.asList());
        List<Integer> pixels4R = new ArrayList<>(Arrays.asList());
        List<Integer> pixels1G = new ArrayList<>(Arrays.asList());
        List<Integer> pixels2G = new ArrayList<>(Arrays.asList());
        List<Integer> pixels3G = new ArrayList<>(Arrays.asList());
        List<Integer> pixels4G = new ArrayList<>(Arrays.asList());
        List<Integer> pixels1B = new ArrayList<>(Arrays.asList());
        List<Integer> pixels2B = new ArrayList<>(Arrays.asList());
        List<Integer> pixels3B = new ArrayList<>(Arrays.asList());
        List<Integer> pixels4B = new ArrayList<>(Arrays.asList());

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                if (x<=image.getWidth()/2 && y<=image.getHeight()/2){
                    int pixel = image.getRGB(x, y);
                    int r = (pixel >> 16) & 0xff;
                    int g = (pixel >> 8) & 0xff;
                    int b = pixel & 0xff;
                    pixels1R.add(r);
                    pixels1G.add(g);
                    pixels1B.add(b);
                }
                if (x>image.getWidth()/2 && y<=image.getHeight()/2){
                    int pixel = image.getRGB(x, y);
                    int r = (pixel >> 16) & 0xff;
                    int g = (pixel >> 8) & 0xff;
                    int b = pixel & 0xff;
                    pixels2R.add(r);
                    pixels2G.add(g);
                    pixels2B.add(b);
                }
                if (x<=image.getWidth()/2 && y>image.getHeight()/2){
                    int pixel = image.getRGB(x, y);
                    int r = (pixel >> 16) & 0xff;
                    int g = (pixel >> 8) & 0xff;
                    int b = pixel & 0xff;
                    pixels3R.add(r);
                    pixels3G.add(g);
                    pixels3B.add(b);
                }
                if (x>image.getWidth()/2 && y>image.getHeight()/2){
                    int pixel = image.getRGB(x, y);
                    int r = (pixel >> 16) & 0xff;
                    int g = (pixel >> 8) & 0xff;
                    int b = pixel & 0xff;
                    pixels4R.add(r);
                    pixels4G.add(g);
                    pixels4B.add(b);
                }
            }
        }
        double tR1 = (findMin(pixels1R) + findMax(pixels1R))/2;
        double tG1 = (findMin(pixels1G) + findMax(pixels1G))/2;
        double tB1 = (findMin(pixels1B) + findMax(pixels1B))/2;
        double tR2 = (findMin(pixels2R) + findMax(pixels2R))/2;
        double tG2 = (findMin(pixels2G) + findMax(pixels2G))/2;
        double tB2 = (findMin(pixels2B) + findMax(pixels2B))/2;
        double tR3 = (findMin(pixels3R) + findMax(pixels3R))/2;
        double tG3 = (findMin(pixels3G) + findMax(pixels3G))/2;
        double tB3 = (findMin(pixels3B) + findMax(pixels3B))/2;
        double tR4 = (findMin(pixels4R) + findMax(pixels4R))/2;
        double tG4 = (findMin(pixels4G) + findMax(pixels4G))/2;
        double tB4 = (findMin(pixels4B) + findMax(pixels4B))/2;

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixel = image.getRGB(x, y);
                int a = (pixel >> 24) & 0xff;
                int r = (pixel >> 16) & 0xff;
                int g = (pixel >> 8) & 0xff;
                int b = pixel & 0xff;

                if (x<=image.getWidth()/2 && y<=image.getHeight()/2){
                    if(r>tR1){
                        r=255;
                    }else{
                        r=0;
                    }
                    if(g>tG1){
                        g=255;
                    }else{
                        g=0;
                    }
                    if(b>tB1){
                        b=255;
                    }else{
                        b=0;
                    }
                    int result = r&g&b;
                    r = result;
                    g = result;
                    b = result;
                }
                if (x>image.getWidth()/2 && y<=image.getHeight()/2){
                    if(r>tR2){
                        r=255;
                    }else{
                        r=0;
                    }
                    if(g>tG2){
                        g=255;
                    }else{
                        g=0;
                    }
                    if(b>tB2){
                        b=255;
                    }else{
                        b=0;
                    }
                    int result = r&g&b;
                    r = result;
                    g = result;
                    b = result;
                }
                if (x<=image.getWidth()/2 && y>image.getHeight()/2){
                    if(r>tR3){
                        r=255;
                    }else{
                        r=0;
                    }
                    if(g>tG3){
                        g=255;
                    }else{
                        g=0;
                    }
                    if(b>tB3){
                        b=255;
                    }else{
                        b=0;
                    }
                    int result = r&g&b;
                    r = result;
                    g = result;
                    b = result;
                }
                if (x>image.getWidth()/2 && y>image.getHeight()/2){
                    if(r>tR4){
                        r=255;
                    }else{
                        r=0;
                    }
                    if(g>tG4){
                        g=255;
                    }else{
                        g=0;
                    }
                    if(b>tB4){
                        b=255;
                    }else{
                        b=0;
                    }
                    int result = r&g&b;
                    r = result;
                    g = result;
                    b = result;
                }
                pixel = (a << 24) | (r << 16) | (g << 8) | b;
                output.setRGB(x, y, pixel);
            }
        }

        return output;
    }
}
