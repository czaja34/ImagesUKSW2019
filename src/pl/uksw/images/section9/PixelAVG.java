package pl.uksw.images.section9;

import java.util.List;

public class PixelAVG {

    private int AVGr = 0;
    private int AVGg = 0;
    private int AVGb = 0;

    private float wariancjaR = 0;
    private float wariancjaG = 0;
    private float wariancjaB = 0;

    public PixelAVG(List<Pixel> pixels) {
       avgList(pixels);
    }


    public float getWariancjaR() {
        return wariancjaR;
    }

    public float getWariancjaG() {
        return wariancjaG;
    }

    public float getWariancjaB() {
        return wariancjaB;
    }

    public int getAVGr() {
        return AVGr;
    }

    public void setAVGr(int AVGr) {
        this.AVGr = AVGr;
    }

    public int getAVGg() {
        return AVGg;
    }

    public void setAVGg(int AVGg) {
        this.AVGg = AVGg;
    }

    public int getAVGb() {
        return AVGb;
    }

    public void setAVGb(int AVGb) {
        this.AVGb = AVGb;
    }

    private void avgList(List<Pixel> pixels) {

        int sumR = 0;
        int sumG = 0;
        int sumB = 0;

        for (Pixel pixel : pixels) {
            sumR += pixel.getR();
            sumG += pixel.getG();
            sumB += pixel.getB();
        }

        this.AVGr = sumR / 9;
        this.AVGg = sumG / 9;
        this.AVGb = sumB / 9;

        sumR = 0;
        sumG = 0;
        sumB = 0;

        for (Pixel pixel : pixels) {
            sumR += Math.pow(AVGr - pixel.getR(), 2);
            sumG += Math.pow(AVGg - pixel.getG(), 2);
            sumB += Math.pow(AVGb - pixel.getB(), 2);
        }

        this.wariancjaR = sumR / 9;
        this.wariancjaG = sumG / 9;
        this.wariancjaB = sumB / 9;


    }
}
