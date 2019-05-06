package pl.uksw.images.section6;


import pl.uksw.images.section6.tasks.Task1;
import pl.uksw.images.section6.tasks.Task2;
import pl.uksw.images.section6.tasks.Task3;
import pl.uksw.images.section6.tasks.Task4;
import pl.uksw.images.section6.tasks.Task5;
import pl.uksw.images.section6.tasks.Task6;
import pl.uksw.images.section6.tasks.Task7;
import pl.uksw.images.tiff.TiffFile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Section6Controller {

    public void exercise1() throws IOException{

        File inputFile = new File("resources/file1.tif");

        Path fileR = Paths.get("resources/histogram_6_1R.dat");
        Path fileG = Paths.get("resources/histogram_6_1G.dat");
        Path fileB = Paths.get("resources/histogram_6_1B.dat");

        BufferedImage inputBites;
        TiffFile tiffFile = new TiffFile();

        inputBites = tiffFile.readFile(inputFile);

        Task1 task1 = new Task1();

        int[][] histogram = task1.task1(inputBites);

        String line = new String();
        List<String> lines = new ArrayList(256);

        // R
        for (int i = 0;i<=255;i++){
            line = i + " " +  "\"" + i + "\""+ " " +  histogram[0][i];
            lines.add(line);
        }
        Files.write(fileR, lines);
        lines.clear();
        // G
        for (int i = 0;i<=255;i++){
            line = i + " " +  "\"" + i + "\""+ " " +  histogram[1][i];
            lines.add(line);
        }
        Files.write(fileG, lines);
        lines.clear();

        // B
        for (int i = 0;i<=255;i++){
            line = i + " " +  "\"" + i + "\""+ " " +  histogram[2][i];
            lines.add(line);
        }
        Files.write(fileB, lines);

    }

    public void exercise2() throws IOException{

        File inputFile = new File("resources/file4.tif");
        File outputTask = new File("resources/6_2.tif");

        Path fileR = Paths.get("resources/histogram_6_2R.dat");
        Path fileG = Paths.get("resources/histogram_6_2G.dat");
        Path fileB = Paths.get("resources/histogram_6_2B.dat");

        BufferedImage inputBites;
        TiffFile tiffFile = new TiffFile();

        inputBites = tiffFile.readFile(inputFile);

        Task2 task2 = new Task2();

        BufferedImage result=task2.task2(inputBites, 10, 20, 30);
        tiffFile.saveFile(outputTask, result);

        Task1 task1 = new Task1();
        inputBites = tiffFile.readFile(outputTask);
        int[][] histogram = task1.task1(inputBites);

        String line = new String();
        List<String> lines = new ArrayList(256);

        // R
        for (int i = 0;i<=255;i++){
            line = i + " " +  "\"" + i + "\""+ " " +  histogram[0][i];
            lines.add(line);
        }
        Files.write(fileR, lines);
        lines.clear();
        // G
        for (int i = 0;i<=255;i++){
            line = i + " " +  "\"" + i + "\""+ " " +  histogram[1][i];
            lines.add(line);
        }
        Files.write(fileG, lines);
        lines.clear();

        // B
        for (int i = 0;i<=255;i++){
            line = i + " " +  "\"" + i + "\""+ " " +  histogram[2][i];
            lines.add(line);
        }
        Files.write(fileB, lines);
    }

    public void exercise3() throws IOException{

        File inputFile = new File("resources/file4.tif");
        File outputTask = new File("resources/6_3.tif");

        BufferedImage inputBites;
        TiffFile tiffFile = new TiffFile();

        inputBites = tiffFile.readFile(inputFile);

        Task3 task3 = new Task3();

        BufferedImage result=task3.task3(inputBites);
        tiffFile.saveFile(outputTask, result);
    }

    public void exercise4() throws IOException{

        File inputFile = new File("resources/file3.tif");
        File outputTask = new File("resources/6_4.tif");

        BufferedImage inputBites;
        TiffFile tiffFile = new TiffFile();

        inputBites = tiffFile.readFile(inputFile);

        Task4 task4 = new Task4();

        BufferedImage result=task4.task4(inputBites, 40);
        tiffFile.saveFile(outputTask, result);
    }

    public void exercise5() throws IOException{

        File inputFile = new File("resources/file7.tif");
        File outputTask = new File("resources/6_5.tif");

        BufferedImage inputBites;
        TiffFile tiffFile = new TiffFile();

        inputBites = tiffFile.readFile(inputFile);

        Task5 task5 = new Task5();

        BufferedImage result=task5.task5(inputBites, 40,180);
        tiffFile.saveFile(outputTask, result);
    }
    public void exercise6() throws IOException{

        File inputFile = new File("resources/file3.tif");
        File outputTask = new File("resources/6_6.tif");

        BufferedImage inputBites;
        TiffFile tiffFile = new TiffFile();

        inputBites = tiffFile.readFile(inputFile);

        Task6 task6 = new Task6();

        BufferedImage result=task6.task6(inputBites);
        tiffFile.saveFile(outputTask, result);
    }

    public void exercise7() throws IOException{

        File inputFile = new File("resources/file7.tif");
        File outputTask = new File("resources/6_7.tif");

        BufferedImage inputBites;
        TiffFile tiffFile = new TiffFile();

        inputBites = tiffFile.readFile(inputFile);

        Task7 task7 = new Task7();

        BufferedImage result=task7.task7(inputBites);
        tiffFile.saveFile(outputTask, result);
    }
}
