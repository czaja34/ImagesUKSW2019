package pl.uksw.images.section1;

import pl.uksw.images.tiff.TiffFile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Section1Controller {

    public void section1Controller() throws IOException {
        File inputFile1 = new File("resources/z4.tif");
        File inputFile2 = new File("resources/z2.tif");

        File outputTask1 = new File("resources/outputSection1Task1.tif");
        File outputTask2 = new File("resources/outputSection1Task2.tif");

        BufferedImage section1InputBites1;
        BufferedImage section1InputBites2;
        BufferedImage section1InputBites3;
        BufferedImage section1InputBites4;


        TiffFile tiffFile = new TiffFile();

        section1InputBites1 = tiffFile.readFile(inputFile1);
        section1InputBites2 = tiffFile.readFile(inputFile2);
        section1InputBites3 = tiffFile.readFile(inputFile1);
        section1InputBites4 = tiffFile.readFile(inputFile1);

        pl.uksw.images.section1.Task1 task1 = new pl.uksw.images.section1.Task1();
        pl.uksw.images.section1.Task2 task2 = new pl.uksw.images.section1.Task2();

        task1.task1(section1InputBites1, section1InputBites2);
        tiffFile.saveFile(outputTask1, section1InputBites1);

        task2.task2(section1InputBites3, section1InputBites2, section1InputBites4);
        tiffFile.saveFile(outputTask2, section1InputBites4);


    }
}
