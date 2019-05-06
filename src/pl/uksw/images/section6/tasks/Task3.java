package pl.uksw.images.section6.tasks;

import java.awt.image.BufferedImage;

public class Task3 {
    public double[] minMax(BufferedImage image, char type){
        double vMin = 255;
        double vMax = 0;
        double[] minMax = new double[2];

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixel = image.getRGB(x, y);
                int pix = 0;
                if (type=='r'){
                    pix = (pixel >> 16) & 0xff;
                }
                else if (type=='g'){
                    pix = (pixel >> 8) & 0xff;
                }
                else if (type=='b'){
                    pix = pixel & 0xff;
                }
                if(pix > vMax){
                    vMax = pix;
                }
                if (pix < vMin){
                    vMin = pix;
                }

            }
        }
        minMax[0] = vMin;
        minMax[1] = vMax;

        return minMax;
    }

    public BufferedImage task3(BufferedImage image){
        double[] minMaxR = minMax(image, 'r');
        double[] minMaxG = minMax(image, 'g');
        double[] minMaxB = minMax(image, 'b');

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixel = image.getRGB(x, y);
                int a = (pixel >> 24) & 0xff;
                int r = (pixel >> 16) & 0xff;
                int g = (pixel >> 8) & 0xff;
                int b = pixel & 0xff;

                Double tR ;
                tR = (r - minMaxR[0])/(minMaxR[1]-minMaxR[0])*255.0;
                Double tG ;
                tG = (g - minMaxG[0])/(minMaxG[1]-minMaxG[0])*255.0;
                Double tB ;
                tB = (b - minMaxB[0])/(minMaxB[1]-minMaxB[0])*255.0;

                r = tR.intValue();
                g = tG.intValue();
                b = tB.intValue();

                pixel = (a << 24) | (r << 16) | (g << 8) | b;
                image.setRGB(x, y, pixel);
            }
        }

        return image;
    }
}
