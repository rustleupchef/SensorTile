package com.youhaveavisitor;

import java.io.BufferedOutputStream;
import java.io.File;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

import net.sourceforge.tess4j.Tesseract;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;


/**
 * Hello world!
 *
 */
public class App {
    static { System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }
    public static void main( String[] args ) throws Exception {
        while(true) {
            BufferedImage ScreenCapture = new Robot().createScreenCapture(new Rectangle(0, 0, 1920, 1080));
            ImageIO.write(ScreenCapture, "png", new File("capture.png"));
            HighGui.imshow("capture", Imgcodecs.imread("capture.png"));
            Tesseract tesseract = new Tesseract();
            tesseract.setDatapath("path/to/tesseract/folder");
            System.out.println(tesseract.doOCR(ImageIO.read(new File("capture.png"))));
            if(HighGui.waitKey(1) == 'q') {
                break;
            }
        }
        HighGui.destroyAllWindows();
    }
}
