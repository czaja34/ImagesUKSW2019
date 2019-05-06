package pl.uksw.images.tiff;

import   javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TiffFile {

    public BufferedImage readFile(File inputFile) throws IOException {
        BufferedImage image = ImageIO.read(inputFile);
        return image;
    }

    public void saveFile(File outputFile, BufferedImage image) throws IOException {
        ImageIO.write(image, "bmp", outputFile);
    }
}
