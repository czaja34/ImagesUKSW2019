package pl.uksw.images.section5.tasks;

import java.awt.image.BufferedImage;

public class Task5 {

    public double[] minMax(BufferedImage image){
        double vMin = 255;
        double vMax = 0;
        double[] minMax = new double[2];

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixel = image.getRGB(x, y);
                int r = (pixel >> 16) & 0xff;

                if(r > vMax){
                    vMax = r;
                }
                if (r < vMin){
                    vMin = r;
                }

            }
        }
        minMax[0] = vMin;
        minMax[1] = vMax;

        return minMax;
    }

    public BufferedImage task5(BufferedImage image){
        int[] tab = new int[256];

        double[] minMax = minMax(image);
        int vMin = 255;
        int vMax = 0;
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixel = image.getRGB(x, y);
                int a = (pixel >> 24) & 0xff;
                int r = (pixel >> 16) & 0xff;
                int g = (pixel >> 8) & 0xff;
                int b = pixel & 0xff;

                if(r > vMax){
                    vMax = r;
                }
                if (r < vMin){
                    vMin = r;
                }

                Double t ;
                t = (minMax[0] + minMax[1])/2;
                if(r>t){
                    r=255;
                }else{
                    r=0;
                }
                g = r;
                b = r;

                pixel = (a << 24) | (r << 16) | (g << 8) | b;
                image.setRGB(x, y, pixel);
            }
        }

        return image;
    }
}
