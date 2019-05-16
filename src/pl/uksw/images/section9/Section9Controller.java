package pl.uksw.images.section9;

import pl.uksw.images.tiff.TiffFile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Section9Controller {

    public void exercise1() throws IOException {

        File inputFile1 = new File("resources/z4.tif");

        File outputTask1 = new File("resources/outputSection9Task1.tif");
        File outputTask2 = new File("resources/outputSection9Task2.tif");
        File outputTask3 = new File("resources/outputSection9Task3.tif");

        BufferedImage inputBites1;
        BufferedImage inputBites2;
        BufferedImage inputBites3;
        BufferedImage outputBites2;

        TiffFile tiffFile = new TiffFile();

        inputBites1 = tiffFile.readFile(inputFile1);
        inputBites2 = tiffFile.readFile(inputFile1);
        inputBites3 = tiffFile.readFile(inputFile1);
        outputBites2 = tiffFile.readFile(inputFile1);

        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        Task3 task3 = new Task3();
        Kuwahary kuwahary = new Kuwahary();

//        task1.task1(inputBites1, param);
//        tiffFile.saveFile(outputTask1, inputBites1);
//
//
//        task2.task1(inputBites2, outputBites2, 10);
//        tiffFile.saveFile(outputTask2, outputBites2);

//        task3.task1(inputBites3, outputBites2, 0);
//        tiffFile.saveFile(outputTask2, outputBites2);

        kuwahary.kuwahary(inputBites2, outputBites2);
        tiffFile.saveFile(outputTask3, outputBites2);
    }

}
