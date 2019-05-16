package pl.uksw.images.section1;

import java.awt.image.BufferedImage;

public class Task2 {

    public BufferedImage task2(BufferedImage imageA, BufferedImage imageB, BufferedImage imageC) {

        int ii = imageA.getWidth() / imageB.getWidth();
        int jj = imageA.getHeight() / imageB.getHeight();

        int resztaI = imageA.getWidth() % imageB.getWidth();
        int resztaJ = imageA.getHeight() % imageB.getHeight();


        int nextI = imageA.getWidth() / resztaI;
        int nextJ = imageA.getHeight() / resztaJ;

        boolean toNextJ = false;
        int minusNextJ = 0;

        if (resztaJ > imageB.getHeight() - resztaJ) {
            minusNextJ = imageA.getHeight() / (imageB.getHeight() - resztaJ);
            toNextJ = true;
        }
        minusNextJ = minusNextJ * 2;

        boolean toNextI = false;
        int minusNextI = 0;

        if (resztaI > imageB.getWidth() - resztaI) {
            minusNextI = imageA.getWidth() / (imageB.getWidth() - resztaI);
            toNextI = true;
        }
        int count = 0;
        int t = 0;
        for (int y = 0; y < imageB.getHeight(); y++) {
            int ee = count;
            int rr = count + jj;
            int plus = 0;

            for (int u = 0; u < imageB.getWidth(); u++) {
                plus = 0;
                int pixel = imageB.getRGB(u, y);
                for (int i = ee; i < rr; i++) {
                    if (i < imageA.getHeight()) {
                        imageA.setRGB(u, i, pixel);
                        if (minusNextJ != 0 && i % minusNextJ == 0 && i != 0 && toNextJ) {
                            toNextJ = false;
                            System.out.println(i);
                        }
                        if (i == 120)
                            toNextJ = true;
                        if (i % nextJ == 0 && i != 0 && toNextJ) {
                            if(i + 1< imageA.getHeight())
                                imageA.setRGB(u, ++i, pixel);
                            plus++;
                        }
                    }
                }
                toNextJ = true;
            }
            count += plus;
            count += jj;
        }
        int gg = 0;

        int count1 = 0;
        boolean plusPixel = false;
        for (int x = 0; x < imageB.getWidth(); x++) {
            int ee = count1;
            int rr = count1 + ii;
            int plus = 0;

            for (int u = 0; u < imageA.getHeight(); u++) {
                plus = 0;
                int pixel = imageA.getRGB(x, u);
                for (int i = ee; i < rr; i++) {
                    if (i < imageA.getWidth()) {
                        imageC.setRGB(i, u, pixel);
                        if (i % nextI == 0 && i != 0) {
                            plusPixel = true;
                        }
                    }
                }
                if (plusPixel) {
                    int i = count1 + ii;
                    try {
                        imageC.setRGB(i, u, pixel);
                        plus++;
                    } catch (Exception e) {

                    }
                    plusPixel = false;

                }
                toNextI = true;
            }
            count1 += plus;
            count1 += ii;
        }


        return imageB;
    }


}
