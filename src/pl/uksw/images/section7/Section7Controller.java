package pl.uksw.images.section7;

import pl.uksw.images.tiff.TiffFile;
import pl.uksw.images.section7.tasks.Task1;
import pl.uksw.images.section7.tasks.Task2;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Section7Controller {

    public void exercise1() throws IOException {
        File inputFile = new File("resources/7M.tif");

        File outputTask = new File("resources/7_1.tif");

        BufferedImage inputBites;
        TiffFile tiffFile = new TiffFile();

        inputBites = tiffFile.readFile(inputFile);

        Task1 task1 = new Task1();
        BufferedImage result=task1.task1(inputBites);
        for (int i=0;i<10;i++){
            result=task1.task1(result);
        }
        tiffFile.saveFile(outputTask, result);
    }

    public void exercise2() throws IOException {
        File inputFile = new File("resources/test3.tif");

        File outputTask = new File("resources/7_2.tif");

        BufferedImage inputBites;
        TiffFile tiffFile = new TiffFile();

        inputBites = tiffFile.readFile(inputFile);

        Task2 task2 = new Task2();
        BufferedImage result=task2.task2(inputBites);
        for (int i=0;i<25;i++){
            result=task2.task2(result);
        }
        tiffFile.saveFile(outputTask, result);
    }

    public void exercise3() throws IOException {
        File inputFile = new File("resources/test4.tif");

        File outputTask = new File("resources/7_3.tif");

        BufferedImage inputBites;
        TiffFile tiffFile = new TiffFile();

        inputBites = tiffFile.readFile(inputFile);

        Task1 task1 = new Task1();
        BufferedImage result1=task1.task1(inputBites);
        for (int i=0;i<5;i++){
            result1=task1.task1(result1);
        }
        Task2 task2 = new Task2();
        BufferedImage result2 = task2.task2(result1);
        for (int i=0;i<5;i++){
            result2=task2.task2(result1);
        }

        tiffFile.saveFile(outputTask, result2);
    }

    public void exercise4() throws IOException {
        File inputFile = new File("resources/test4.tif");

        File outputTask = new File("resources/7_4.tif");

        BufferedImage inputBites;
        TiffFile tiffFile = new TiffFile();

        inputBites = tiffFile.readFile(inputFile);

        Task2 task2 = new Task2();
        BufferedImage result1 = task2.task2(inputBites);
        for (int i=0;i<5;i++){
            result1=task2.task2(result1);
        }

        Task1 task1 = new Task1();
        BufferedImage result2=task1.task1(result1);
        for (int i=0;i<5;i++){
            result2=task1.task1(result2);
        }


        tiffFile.saveFile(outputTask, result2);
    }
}
