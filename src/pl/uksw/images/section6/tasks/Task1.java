package pl.uksw.images.section6.tasks;

import java.awt.image.BufferedImage;

public class Task1 {

    public int[][] task1(BufferedImage image){
        int[][] tab = new int[3][256];

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int pixel = image.getRGB(x, y);
                int a = (pixel >> 24) & 0xff;
                int r = (pixel >> 16) & 0xff;
                int g = (pixel >> 8) & 0xff;
                int b = pixel & 0xff;

                tab[0][r]+=1;
                tab[1][g]+=1;
                tab[2][b]+=1;
            }
        }

        return tab;
    }
}