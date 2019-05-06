package pl.uksw.images.section4;

import pl.uksw.images.section4.tasks.Task1;
import pl.uksw.images.section4.tasks.Task2;
import pl.uksw.images.section4.tasks.Task3;
import pl.uksw.images.section4.tasks.Task5;
import pl.uksw.images.section4.tasks.Task6;
import pl.uksw.images.tiff.TiffFile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Section4Controller {

    public void exercise1(int cX, int cY) throws IOException {
        File inputFile = new File("resources/file1.tif");
        File outputTask = new File("resources/4_1.bmp");

        BufferedImage inputBites;
        TiffFile tiffFile = new TiffFile();

        inputBites = tiffFile.readFile(inputFile);

        BufferedImage resized = new BufferedImage(inputBites.getWidth()+cX, inputBites.getHeight()+cY, Image.SCALE_SMOOTH);


        Task1 task1 = new Task1();
        BufferedImage result=task1.task1(inputBites, resized, cX, cY);
        tiffFile.saveFile(outputTask, result);
    }

    public void exercise2(double cX, double cY, int newWidth, int newHeight) throws IOException {
        File inputFile = new File("resources/file1.tif");
        File outputTask = new File("resources/4_2.bmp");

        BufferedImage inputBites;
        TiffFile tiffFile = new TiffFile();

        inputBites = tiffFile.readFile(inputFile);

        BufferedImage resized = new BufferedImage(newWidth, newHeight, Image.SCALE_SMOOTH);


        Task2 task2 = new Task2();
        BufferedImage result=task2.task2(inputBites, resized, cX, cY);
        tiffFile.saveFile(outputTask, result);
    }

    public void exercise3(int angle, int newWidth, int newHeight) throws IOException {
        File inputFile = new File("resources/file1.tif");
        File outputTask = new File("resources/4_3.bmp");

        BufferedImage inputBites;
        TiffFile tiffFile = new TiffFile();

        inputBites = tiffFile.readFile(inputFile);

        BufferedImage resized = new BufferedImage(newWidth, newHeight, Image.SCALE_SMOOTH);


        Task3 task3 = new Task3();
        BufferedImage result=task3.task3(inputBites, resized, angle);
        tiffFile.saveFile(outputTask, result);
    }

    public void exercise5(int cX, int cY, int c2X, int c2Y) throws IOException {
        File inputFile = new File("resources/file1.tif");
        File outputTask = new File("resources/4_5.bmp");

        BufferedImage inputBites;
        TiffFile tiffFile = new TiffFile();

        inputBites = tiffFile.readFile(inputFile);

        Task5 task5 = new Task5();
        BufferedImage result=task5.task5(inputBites, cX, cY, c2X, c2Y);
        tiffFile.saveFile(outputTask, result);
    }

    public void exercise6(int cX, int cY, int c2X, int c2Y) throws IOException {
        File inputFile = new File("resources/file1.tif");
        File outputTask = new File("resources/4_6.bmp");

        BufferedImage inputBites;
        TiffFile tiffFile = new TiffFile();

        inputBites = tiffFile.readFile(inputFile);

        BufferedImage cutImage = new BufferedImage(500, 500, Image.SCALE_SMOOTH);


        Task6 task6 = new Task6();
        BufferedImage result=task6.task6(inputBites, cutImage, cX, cY, c2X, c2Y);
        tiffFile.saveFile(outputTask, result);
    }

}
