package pl.uksw.images.section9;

import java.awt.image.BufferedImage;

public class Task1 {


    public BufferedImage task1(BufferedImage image, int param) {
        int paramD = (param - 1) / 2;

        for (int x = paramD; x < (image.getWidth() - paramD); x++) {
            for (int y = paramD; y < (image.getHeight() - paramD); y++) {
                int pixel = image.getRGB(x, y);
                int a = (pixel >> 24) & 0xff;

                int r = getLowPassValue16(x, y, image, param);
                int g = getLowPassValue8(x, y, image, param);
                int b = getLowPassValue1(x, y, image, param);

                pixel = (a << 24) | (r << 16) | (g << 8) | b;
                image.setRGB(x, y, pixel);
            }
        }
        return image;
    }


    private int getLowPassValue16(int x, int y, BufferedImage image, int param) {
        int sum = 0;
        int paramD = (param - 1) / 2;
        for (int i = x - paramD; i <= x + paramD; i++) {
            for (int j = y - paramD; j <= y + paramD; j++) {
                int pixel = image.getRGB(i, j);
                int s = (pixel >> 16) & 0xff;
//                if(i==x&&j==y)
//                    s*=2;
                sum += s;
            }
        }
        sum = sum / (param * param);
        if (sum < 0)
            sum = 0;
        else if (sum > 255)
            sum = 255;
        return sum;
    }

    private int getLowPassValue8(int x, int y, BufferedImage image, int param) {
        int sum = 0;
        int paramD = (param - 1) / 2;

        for (int i = x - paramD; i <= x + paramD; i++) {
            for (int j = y - paramD; j <= y + paramD; j++) {
                int pixel = image.getRGB(i, j);
                int s = (pixel >> 8) & 0xff;
//                if(i==x&&j==y)
//                    s*=2;
                sum += s;
            }
        }
        sum = sum / (param * param);
        if (sum < 0)
            sum = 0;
        else if (sum > 255)
            sum = 255;
        return sum;
    }

    private int getLowPassValue1(int x, int y, BufferedImage image, int param) {
        int sum = 0;
        int paramD = (param - 1) / 2;

        for (int i = x - paramD; i <= x + paramD; i++) {
            for (int j = y - paramD; j <= y + paramD; j++) {
                int pixel = image.getRGB(i, j);
                int s = (pixel) & 0xff;
//                if(i==x&&j==y)
//                    s*=2;
                sum += s;
            }
        }
        sum = sum / (param * param);
        if (sum < 0)
            sum = 0;
        else if (sum > 255)
            sum = 255;
        return sum;
    }


}
