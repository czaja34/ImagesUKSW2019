package pl.uksw.images.section4.tasks;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Task3 {

    public BufferedImage task3(BufferedImage image, BufferedImage resized, int angle){
        double theta = Math.toRadians(angle);
        Graphics2D g = resized.createGraphics();
//        double rotationRequired = Math.toDegrees(15);
//        AffineTransform at = AffineTransform.getRotateInstance(rotationRequired,0,200);
//        AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
//        g.drawRenderedImage(image,at);

//        g.drawImage(op.filter(image, null), 200, 200, null);
        g.rotate(theta, image.getHeight(), image.getWidth());
        g.drawImage(image,null,0,0);
        return resized;
    }
}
