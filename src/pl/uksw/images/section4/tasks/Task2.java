package pl.uksw.images.section4.tasks;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Task2 {

    public BufferedImage task2(BufferedImage image, BufferedImage resized, double cX, double cY){

                Graphics2D g = resized.createGraphics();
                AffineTransform at = AffineTransform.getScaleInstance(cX, cY);
                g.drawRenderedImage(image, at);

        return resized;
    }
}
