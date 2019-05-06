package pl.uksw.images.section8;

import pl.uksw.images.section8.tasks.Task1;
import pl.uksw.images.section8.tasks.Task2;
import pl.uksw.images.tiff.TiffFile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Section8Controller {

    public void exercise1() throws IOException {
        File inputFile = new File("resources/8.tif");

        File outputTask = new File("resources/8_1.tif");

        BufferedImage inputBites;
        TiffFile tiffFile = new TiffFile();

        inputBites = tiffFile.readFile(inputFile);


        Task1 task1 = new Task1();
        BufferedImage result=task1.task1(inputBites);
        for (int i=0;i<2;i++){
            result=task1.task1(result);
        }
        tiffFile.saveFile(outputTask, result);
    }

    public void exercise2() throws IOException {
        File inputFile = new File("resources/8.tif");

        File outputTask = new File("resources/8_2.tif");

        BufferedImage inputBites;
        TiffFile tiffFile = new TiffFile();

        inputBites = tiffFile.readFile(inputFile);


        Task2 task2 = new Task2();
        BufferedImage result=task2.task2(inputBites);
        for (int i=0;i<2;i++){
            result=task2.task2(result);
        }
        tiffFile.saveFile(outputTask, result);
    }

    public void exercise3() throws IOException {
        File inputFile = new File("resources/8.tif");

        File outputTask = new File("resources/8_3.tif");

        BufferedImage inputBites;
        TiffFile tiffFile = new TiffFile();

        inputBites = tiffFile.readFile(inputFile);

        Task1 task1 = new Task1();
        BufferedImage result1=task1.task1(inputBites);
        for (int i=0;i<2;i++){
            result1=task1.task1(result1);
        }
        Task2 task2 = new Task2();
        BufferedImage result2 = task2.task2(result1);
        for (int i=0;i<2;i++){
            result2=task2.task2(result1);
        }

        tiffFile.saveFile(outputTask, result2);
    }

    public void exercise4() throws IOException {
        File inputFile = new File("resources/8.tif");

        File outputTask = new File("resources/8_4.tif");

        BufferedImage inputBites;
        TiffFile tiffFile = new TiffFile();

        inputBites = tiffFile.readFile(inputFile);

        Task2 task2 = new Task2();
        BufferedImage result1 = task2.task2(inputBites);
        for (int i=0;i<2;i++){
            result1=task2.task2(result1);
        }

        Task1 task1 = new Task1();
        BufferedImage result2=task1.task1(result1);
        for (int i=0;i<2;i++){
            result2=task1.task1(result2);
        }


        tiffFile.saveFile(outputTask, result2);
    }
}
