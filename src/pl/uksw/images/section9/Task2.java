package pl.uksw.images.section9;

import java.awt.image.BufferedImage;

public class Task2 {

    public BufferedImage task1(BufferedImage imageIn, BufferedImage imageOut, int param) {


        for (int x = 1; x < (imageIn.getWidth() - 1); x++) {
            for (int y = 1; y < (imageIn.getHeight() - 1); y++) {
                int pixel = imageIn.getRGB(x, y);
                int a = (pixel >> 24) & 0xff;
                int r = getLowPassValue16(x, y, imageIn, param);
                int g = getLowPassValue8(x, y, imageIn, param);
                int b = getLowPassValue1(x, y, imageIn, param);

                r += param;
                g += param;
                b += param;

                pixel = (a << 24) | (r << 16) | (g << 8) | b;
                imageOut.setRGB(x, y, pixel);
            }
        }
        return imageOut;
    }


    private int getLowPassValue16(int x, int y, BufferedImage image, int param) {
        int sum = 0;
        int paramD = (param - 1) / 2;


        int value1;
        int value2;
        int value3;

        int value4;
        int value5;
        int value6;

        int value7;
        int value8;
        int value9;


        int pixel1 = image.getRGB(x - 1, y - 1);
        int pixel2 = image.getRGB(x, y - 1);
        int pixel3 = image.getRGB(x + 1, y - 1);

        int pixel4 = image.getRGB(x - 1, y);
        int pixel5 = image.getRGB(x, y);
        int pixel6 = image.getRGB(x + 1, y);

        int pixel7 = image.getRGB(x - 1, y + 1);
        int pixel8 = image.getRGB(x, y + 1);
        int pixel9 = image.getRGB(x + 1, y + 1);
        value1 = (pixel1 >> 16) & 0xff;
        value2 = (pixel2 >> 16) & 0xff;
        value3 = (pixel3 >> 16) & 0xff;

        value4 = (pixel4 >> 16) & 0xff;
        value5 = (pixel5 >> 16) & 0xff;
        value6 = (pixel6 >> 16) & 0xff;

        value7 = (pixel7 >> 16) & 0xff;
        value8 = (pixel8 >> 16) & 0xff;
        value9 = (pixel9 >> 16) & 0xff;

//        sum = value1 + value2 - value3 + (value4) -(2*value5) - value6 + value7 + value8 - value9;
//        sum = -value1 - value2 + value3 - (value4) - (2 * value5) + value6 + value7 + value8 + value9;
        sum = -value1 + value2 + value3 - (value4) -(2*value5) + value6 - value7 + value8 + value9;

////        for (int i = x - paramD; i <= x + paramD; i++) {
////            for (int j = y - paramD; j <= y + paramD; j++) {
//        int pixel1 = image.getRGB(x - 1, y);
//        int pixel2 = image.getRGB(x, y + 1);
//        value = (pixel1 >> 16) & 0xff;
//        value2 = (pixel2 >> 16) & 0xff;
////                if (i == x - 1 && j == y) {
////                    value *= 1;
////                } else if (i == x && j == y + 1) {
////                    value *= -1;
////                }else {
////                    value *= 0;
////                }
//        sum += value - value2;
////            }
////        }

        if (sum < 0)
            sum = 0;
        else if (sum > 255)
            sum = 255;
        return sum;
    }

    private int getLowPassValue8(int x, int y, BufferedImage image, int param) {
        int sum = 0;
        int paramD = (param - 1) / 2;
//        int value;
//        for (int i = x - paramD; i <= x + paramD; i++) {
//            for (int j = y - paramD; j <= y + paramD; j++) {
//                int pixel = image.getRGB(i, j);
//                value = (pixel >> 8) & 0xff;
//                if (i == x - 1 && j == y) {
//                    value *= 1;
//                } else if (i == x && j == y + 1) {
//                    value *= -1;
//                }
//                    else{
//                    value *= 0;
//                }
//                sum += value;
//            }
//        }

//        int value;
//        int value2;
//        int pixel1 = image.getRGB(x - 1, y);
//        int pixel2 = image.getRGB(x, y + 1);
//        value = (pixel1 >> 8) & 0xff;
//        value2 = (pixel2 >> 8) & 0xff;
//        sum += value - value2;


        int value1;
        int value2;
        int value3;

        int value4;
        int value5;
        int value6;

        int value7;
        int value8;
        int value9;


        int pixel1 = image.getRGB(x - 1, y - 1);
        int pixel2 = image.getRGB(x, y - 1);
        int pixel3 = image.getRGB(x + 1, y - 1);

        int pixel4 = image.getRGB(x - 1, y);
        int pixel5 = image.getRGB(x, y);
        int pixel6 = image.getRGB(x + 1, y);

        int pixel7 = image.getRGB(x - 1, y + 1);
        int pixel8 = image.getRGB(x, y + 1);
        int pixel9 = image.getRGB(x + 1, y + 1);
        value1 = (pixel1 >> 8) & 0xff;
        value2 = (pixel2 >> 8) & 0xff;
        value3 = (pixel3 >> 8) & 0xff;

        value4 = (pixel4 >> 8) & 0xff;
        value5 = (pixel5 >> 8) & 0xff;
        value6 = (pixel6 >> 8) & 0xff;

        value7 = (pixel7 >> 8) & 0xff;
        value8 = (pixel8 >> 8) & 0xff;
        value9 = (pixel9 >> 8) & 0xff;


//        sum = value1 + value2 - value3 + (value4) -(2*value5) - value6 + value7 + value8 - value9;
//        sum = -value1 - value2 + value3 - (value4) - (2 * value5) + value6 + value7 + value8 + value9;
        sum = -value1 + value2 + value3 - (value4) -(2*value5) + value6 - value7 + value8 + value9;

        if (sum < 0)
            sum = 0;
        else if (sum > 255)
            sum = 255;
        return sum;
    }

    private int getLowPassValue1(int x, int y, BufferedImage image, int param) {
        int sum = 0;
        int paramD = (param - 1) / 2;
//        int value;
//        for (int i = x - paramD; i <= x + paramD; i++) {
//            for (int j = y - paramD; j <= y + paramD; j++) {
//                int pixel = image.getRGB(i, j);
//                value = (pixel) & 0xff;
//                if (i == x - 1 && j == y) {
//                    value *= 1;
//                } else if (i == x && j == y + 1) {
//                    value *= -1;
//                }else {
//                    value *= 0;
//                }
//                sum += value;
//            }
//        }

//        int value;
//        int value2;
//        int pixel1 = image.getRGB(x - 1, y);
//        int pixel2 = image.getRGB(x, y + 1);
//        value = (pixel1) & 0xff;
//        value2 = (pixel2) & 0xff;
//        sum += value - value2;


        int value1;
        int value2;
        int value3;

        int value4;
        int value5;
        int value6;

        int value7;
        int value8;
        int value9;


        int pixel1 = image.getRGB(x - 1, y - 1);
        int pixel2 = image.getRGB(x, y - 1);
        int pixel3 = image.getRGB(x + 1, y - 1);

        int pixel4 = image.getRGB(x - 1, y);
        int pixel5 = image.getRGB(x, y);
        int pixel6 = image.getRGB(x + 1, y);

        int pixel7 = image.getRGB(x - 1, y + 1);
        int pixel8 = image.getRGB(x, y + 1);
        int pixel9 = image.getRGB(x + 1, y + 1);
        value1 = (pixel1) & 0xff;
        value2 = (pixel2) & 0xff;
        value3 = (pixel3) & 0xff;

        value4 = (pixel4) & 0xff;
        value5 = (pixel5) & 0xff;
        value6 = (pixel6) & 0xff;

        value7 = (pixel7) & 0xff;
        value8 = (pixel8) & 0xff;
        value9 = (pixel9) & 0xff;



//        sum = value1 + value2 - value3 + (value4) - (2 * value5) - value6 + value7 + value8 - value9;
//        sum = -value1 - value2 + value3 - (value4) - (2 * value5) + value6 + value7 + value8 + value9;
        sum = -value1 + value2 + value3 - (value4) -(2*value5) + value6 - value7 + value8 + value9;

        if (sum < 0)
            sum = 0;
        else if (sum > 255)
            sum = 255;
        return sum;
    }
}
