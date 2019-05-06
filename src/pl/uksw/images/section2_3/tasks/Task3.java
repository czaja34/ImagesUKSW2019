package pl.uksw.images.section2_3.tasks;

import java.awt.image.BufferedImage;

import static java.awt.image.BufferedImage.TYPE_BYTE_INDEXED;

public class Task3 {
    public BufferedImage task3(BufferedImage imageA, BufferedImage imageB, float wsp) {


        int width;
        int hight;

        if (imageA.getWidth() > imageB.getWidth())
            width = imageA.getWidth();
        else
            width = imageB.getWidth();

        if (imageA.getHeight() > imageB.getHeight())
            hight = imageA.getHeight();
        else
            hight = imageB.getHeight();

        BufferedImage image = new BufferedImage(width, hight, TYPE_BYTE_INDEXED);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < hight; y++) {
                int pixel;
                int pixelA;
                int pixelB;
                try {
                    pixelA = imageA.getRGB(x, y);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    pixelA = 0;
                }

                try {
                    pixelB = imageB.getRGB(x, y);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    pixelB = 0;
                }


                int a = (pixelA >> 24) & 0xff;
                int a1 = (pixelB >> 24) & 0xff;
                a = (int) ((a*wsp)+(a1*(1-wsp)));
                if(a>255)
                    a=255;
                int r = (pixelA >> 16) & 0xff;
                int r1 = (pixelB >> 16) & 0xff;
                r= (int) ((r * wsp)+(r1*(1-wsp)));
                if(r>255)
                    r=255;
                int g = (pixelA >> 8) & 0xff;
                int g1 =(pixelB >> 8) & 0xff;
                g= (int) ((g * wsp)+(g1*(1-wsp)));
                if(g>255)
                    g=255;
                int b = pixelA & 0xff;
                int b1 = pixelB & 0xff;
                b= (int) ((b * wsp)+(b1*(1-wsp)));
                if(b>255)
                    b=255;
                pixel = (a << 24) | (r << 16) | (g << 8) | b;
                image.setRGB(x, y, pixel);
            }
        }
        return image;

    }
}
