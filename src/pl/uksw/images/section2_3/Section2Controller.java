package pl.uksw.images.section2_3;

import pl.uksw.images.section2_3.tasks.*;
import pl.uksw.images.tiff.TiffFile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Section2Controller {

    public void exercise1(int par) throws IOException {
        File zdjecieWejsciowe1 = new File("resources/z1.tif");
        File inputFile1 = new File("resources/z2.tif");

        File outputTask2A = new File("resources/outputTask2A.bmp");
        File outputTask2B = new File("resources/outputTask2B.bmp");


        File inputFileTask5 = new File("resources/z5.tif");


        File outputTask3 = new File("resources/outputTask3.bmp");

        File outputTask4 = new File("resources/outputTask4.bmp");

        File outputTask5A = new File("resources/outputTask5A.bmp");
        File outputTask5B = new File("resources/outputTask5B.bmp");

        File inputFileTask6 = new File("resources/z2Grey.tif");
        File outputTask6 = new File("resources/outputTask6.bmp");
        File outputTask7 = new File("resources/outputTask7.tif");

        BufferedImage inputBitesA;
        BufferedImage inputBitesB;

        BufferedImage inputBitesTask5;
        BufferedImage inputBitesTask6;
        BufferedImage inputBitesTask7;



        TiffFile tiffFile = new TiffFile();

        inputBitesA = tiffFile.readFile(zdjecieWejsciowe1);
        inputBitesB = tiffFile.readFile(inputFile1);

        inputBitesTask5 = tiffFile.readFile(inputFileTask5);
        inputBitesTask6 = tiffFile.readFile(inputFileTask6);
        inputBitesTask7 = tiffFile.readFile(inputFileTask6);

        Task1 task1 = new Task1();
        tiffFile.saveFile(outputTask2B, task1.task1b(inputBitesA, inputBitesB,0));


//        Task2 task2 = new Task2();
//
//        tiffFile.saveFile(outputTask2A,  task2.task1a(inputBitesA, 2,-2));
//        tiffFile.saveFile(outputTask2B, task2.task1b(inputBitesA, inputBitesB,0));

//        tiffFile.saveFile(outputTask2B, task1.task1b(inputBitesA, inputBitesB));


//        Task3 task3 = new Task3();
//        tiffFile.saveFile(outputTask3, task3.task3(inputBitesA, inputBitesB,0.3f));
//
//        Task4 task4 = new Task4();
//        tiffFile.saveFile(outputTask4, task4.task4(inputBitesA,2));
//
//        Task5 task5 = new Task5();
//        tiffFile.saveFile(outputTask5A, task5.task1a(inputBitesTask5,3));
//        tiffFile.saveFile(outputTask5B, task5.task1b(inputBitesTask5, inputBitesB));
//
//        Task6 task6 = new Task6();
//        tiffFile.saveFile(outputTask6, task6.task6(inputBitesTask6));


        Task7 task7 = new Task7();
        tiffFile.saveFile(outputTask7, task7.task7(inputBitesTask6));

    }

}
