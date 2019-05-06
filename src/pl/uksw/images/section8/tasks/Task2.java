package pl.uksw.images.section8.tasks;

import static pl.uksw.images.utils.Utils.findMax;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Task2 {

    public BufferedImage task2(BufferedImage image) {

        BufferedImage output = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        List<Integer> pixels = new ArrayList<>(Arrays.asList());
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixel = image.getRGB(x, y);
                int a = (pixel >> 24) & 0xff;
                int r = (pixel >> 16) & 0xff;
                int g = (pixel >> 8) & 0xff;
                int b = pixel & 0xff;

                if (y-1>=0) {
                    int pixel0 = image.getRGB(x, y-1);
                    int r0 = (pixel0 >> 16) & 0xff;
                    pixels.add(r0);
                }
                if (y-2>=0) {
                    int pixel0 = image.getRGB(x, y-2);
                    int r0 = (pixel0 >> 16) & 0xff;
                    pixels.add(r0);
                }
                if (y+1<image.getHeight()) {
                    int pixel0 = image.getRGB(x, y+1);
                    int r0 = (pixel0 >> 16) & 0xff;
                    pixels.add(r0);
                }
                if (y+2<image.getHeight()) {
                    int pixel0 = image.getRGB(x, y+2);
                    int r0 = (pixel0 >> 16) & 0xff;
                    pixels.add(r0);
                }
                if (!pixels.isEmpty()){
                    r=findMax(pixels);
                    pixels.clear();
                    g=r;
                    b=r;
                }

                pixel = (a << 24) | (r << 16) | (g << 8) | b;
                output.setRGB(x, y, pixel);
            }
        }

        return output;

    }
}