package pl.uksw.images.section9;

import java.awt.image.BufferedImage;

public class Pixel {

    private int a = 0;
    private int r = 0;
    private int g = 0;
    private int b = 0;

    public Pixel(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Pixel(int x, int y, BufferedImage image) {
        int pixel = image.getRGB(x, y);
        this.a = (pixel >> 24) & 0xff;
        this.r = (pixel >> 16) & 0xff;
        this.g = (pixel >> 8) & 0xff;
        this.b = pixel & 0xff;
    }


    public int getA() {
        return a;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }
}
