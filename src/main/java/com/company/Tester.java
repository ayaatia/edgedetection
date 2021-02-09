package com.company;

import com.pixelmed.display.ConsumerFormatImageMaker;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Tester {
    //Canny parameters
    private static final double CANNY_THRESHOLD_RATIO = .2; //Suggested range .2 - .4
    private static final int CANNY_STD_DEV = 1;             //Range 1-3

    //I/O parameters
    private static String imgFileName;
    private static String imgOutFile = "";
    private static String imgExt;

    public static void main(String[] args) {
        //Read input file name and create output file name
      //  String dicomFile = "C:\\Users\\user\\Desktop\\documentation PFE\\articlesurcalcul\\1.2.840.113619.2.359.3.17484043.663.1430717400.361.71";
        String outputPngFile = "C:\\Users\\user\\Desktop\\documentation PFE\\articlesurcalcul\\1.2.840.113619.2.359.3.17484043.663.1430717400.361.71.png";
        imgFileName = "C:\\Users\\user\\Desktop\\documentation PFE\\articlesurcalcul\\1.2.840.113619.2.359.3.17484043.663.1430717400.361.71";
        imgExt = "png";
        String[] arr = imgFileName.split("\\.");

        for (int i = 0; i < arr.length - 1; i++) {
            imgOutFile += arr[i];
        }

        imgOutFile += "_canny.";
        imgOutFile += imgExt;

        //Sample JCanny usage
        try {
            ConsumerFormatImageMaker.convertFileToEightBitImage(imgFileName, outputPngFile, "png");
            BufferedImage r = ImageIO.read(new File(outputPngFile));
            BufferedImage rr = JCanny.CannyEdges(r, CANNY_STD_DEV, CANNY_THRESHOLD_RATIO);
          /*  BufferedImage input = ImageIO.read(new File(imgFileName));
            BufferedImage output = JCanny.CannyEdges(input, CANNY_STD_DEV, CANNY_THRESHOLD_RATIO);*/
            System.out.println("rr"+imgOutFile);
         //  ConsumerFormatImageMaker.convertFileToEightBitImage(output, outputPngFile, "png");
         /*   BufferedImage r = ImageIO.read(new File("C:\\Users\\user\\Downloads\\test1.png"));
            ImageIO.write(r, imgExt, new File("C:\\Users\\user\\Downloads\\ee.png"));*/

            ImageIO.write(rr, imgExt, new File(imgOutFile));

        } catch (Exception ex) {
            System.out.println("ERROR ACCESING IMAGE FILE:\n" + ex.getMessage());
        }
    }
}
