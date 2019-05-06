package pl.uksw.images.section5;

import pl.uksw.images.section5.tasks.Task1;
import pl.uksw.images.section5.tasks.Task2;
import pl.uksw.images.section5.tasks.Task3;
import pl.uksw.images.section5.tasks.Task4;
import pl.uksw.images.section5.tasks.Task5;
import pl.uksw.images.tiff.TiffFile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Section5Controller {

    public void exercise1() throws IOException{

        File inputFile = new File("resources/fileGrey1.tif");

        Path file = Paths.get("resources/histogram_5_1.dat");

        BufferedImage inputBites;
        TiffFile tiffFile = new TiffFile();

        inputBites = tiffFile.readFile(inputFile);

        Task1 task1 = new Task1();

        int[] histogram = task1.task1(inputBites);

        String line = new String();
        List<String> lines = new ArrayList(256);

        for (int i = 0;i<=255;i++){
            line = i + " " +  "\"" + i + "\""+ " " +  histogram[i];
            lines.add(line);
        }
        Files.write(file, lines);

    }

    public void exercise2() throws IOException{

        File inputFile = new File("resources/fileGrey3.tif");
        File outputTask = new File("resources/5_2.tif");

        Path file = Paths.get("resources/histogram_5_2.dat");

        BufferedImage inputBites;
        TiffFile tiffFile = new TiffFile();

        inputBites = tiffFile.readFile(inputFile);

        Task2 task2 = new Task2();

        BufferedImage result=task2.task2(inputBites, 70);
        tiffFile.saveFile(outputTask, result);

        Task1 task1 = new Task1();
        inputBites = tiffFile.readFile(outputTask);
        int[] histogram = task1.task1(inputBites);

        String line = new String();
        List<String> lines = new ArrayList(256);

        for (int i = 0;i<=255;i++){
            line = i + " " +  "\"" + i + "\""+ " " +  histogram[i];
            lines.add(line);
        }
        Files.write(file, lines);
    }

    public void exercise3() throws IOException{

        File inputFile = new File("resources/53.tif");
        File outputTask = new File("resources/5_3.tif");

        Path file = Paths.get("resources/histogram_5_3.dat");

        BufferedImage inputBites;
        TiffFile tiffFile = new TiffFile();

        inputBites = tiffFile.readFile(inputFile);

        Task3 task3 = new Task3();

        BufferedImage result=task3.task3(inputBites);
        tiffFile.saveFile(outputTask, result);

        Task1 task1 = new Task1();
        inputBites = tiffFile.readFile(outputTask);
        int[] histogram = task1.task1(inputBites);

        String line = new String();
        List<String> lines = new ArrayList(256);

        for (int i = 0;i<=255;i++){
            line = i + " " +  "\"" + i + "\""+ " " +  histogram[i];
            lines.add(line);
        }
        Files.write(file, lines);
    }

    public void exercise4() throws IOException{

        File inputFile = new File("resources/fileGrey3.tif");
        File outputTask = new File("resources/5_4.tif");

        BufferedImage inputBites;
        TiffFile tiffFile = new TiffFile();

        inputBites = tiffFile.readFile(inputFile);

        Task4 task4 = new Task4();

        BufferedImage result=task4.task4(inputBites);
        tiffFile.saveFile(outputTask, result);
    }

    public void exercise5() throws IOException{

        File inputFile = new File("resources/fileGrey3.tif");
        File outputTask = new File("resources/5_5.tif");

        BufferedImage inputBites;
        TiffFile tiffFile = new TiffFile();

        inputBites = tiffFile.readFile(inputFile);

        Task5 task5 = new Task5();

        BufferedImage result=task5.task5(inputBites);
        tiffFile.saveFile(outputTask, result);
    }
}
