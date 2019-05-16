package pl.uksw.images.section9;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Kuwahary {

    public BufferedImage kuwahary(BufferedImage imageIn, BufferedImage imageOut) {


        for (int x = 2; x < (imageIn.getWidth() - 2); x++) {
            for (int y = 2; y < (imageIn.getHeight() - 2); y++) {

                Pixel pixelRGB = kuwaharyRGB(getRegions(x,y,imageIn));

                int pixel = imageIn.getRGB(x, y);
                int a = (pixel >> 24) & 0xff;
                int r = pixelRGB.getR();
                int g = pixelRGB.getG();
                int b = pixelRGB.getB();

                pixel = (a << 24) | (r << 16) | (g << 8) | b;
                imageOut.setRGB(x, y, pixel);
            }
        }
        return imageOut;
    }

    private List<PixelAVG> getRegions(int x, int y, BufferedImage image) {
        List<PixelAVG> result = new ArrayList<>();

        result.add(region1(x, y, image));
        result.add(region2(x, y, image));
        result.add(region3(x, y, image));
        result.add(region4(x, y, image));
        return result;
    }

    private Pixel kuwaharyRGB(List<PixelAVG> pixels) {
        float maxR = pixels.get(0).getWariancjaR();
        float maxG = pixels.get(0).getWariancjaG();
        float maxB = pixels.get(0).getWariancjaB();
        int indexR = pixels.get(0).getAVGr();
        int indexG = pixels.get(0).getAVGg();
        int indexB = pixels.get(0).getAVGb();

        for (int i = 0; i < 4; i++) {

            if (pixels.get(i).getWariancjaR() < maxR) {
                indexR = pixels.get(i).getAVGr();
            }
            if (pixels.get(i).getWariancjaG() < maxG) {
                indexG = pixels.get(i).getAVGg();
            }
            if (pixels.get(i).getWariancjaB() < maxB) {
                indexB = pixels.get(i).getAVGb();
            }


        }
        return new Pixel(indexR, indexG, indexB);
    }

    private PixelAVG region1(int x, int y, BufferedImage image) {
        List<Pixel> pixels = new ArrayList<>();
        for (int i = x - 2; i <= x; i++) {
            for (int j = y - 2; j <= y; j++) {
                pixels.add(new Pixel(i, j, image));
            }
        }
        return new PixelAVG(pixels);
    }

    private PixelAVG region2(int x, int y, BufferedImage image) {
        List<Pixel> pixels = new ArrayList<>();
        for (int i = x; i <= x + 2; i++) {
            for (int j = y - 2; j <= y; j++) {
                pixels.add(new Pixel(i, j, image));
            }
        }
        return new PixelAVG(pixels);
    }

    private PixelAVG region3(int x, int y, BufferedImage image) {
        List<Pixel> pixels = new ArrayList<>();
        for (int i = x - 2; i <= x; i++) {
            for (int j = y; j <= y + 2; j++) {
                pixels.add(new Pixel(i, j, image));
            }
        }
        return new PixelAVG(pixels);
    }

    private PixelAVG region4(int x, int y, BufferedImage image) {
        List<Pixel> pixels = new ArrayList<>();
        for (int i = x; i <= x + 2; i++) {
            for (int j = y; j <= y + 2; j++) {
                pixels.add(new Pixel(i, j, image));
            }
        }
        return new PixelAVG(pixels);
    }


}
