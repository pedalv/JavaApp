package no.dfo.whatsnewinjava.desktop;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TIFFSupport {
    public static void main(String... args) throws IOException {
        // The easy way
        BufferedImage img = ImageIO.read(new File("C:\\workspace2\\JavaApp\\CloudComputing\\whats-new-in-java\\src\\main\\resources\\sander.tiff"));
        System.out.println("Height: " + img.getHeight());
        System.out.println("Width: " + img.getWidth());

        // The hard way
        ImageInputStream inputStream = ImageIO.createImageInputStream(new File("C:\\workspace2\\JavaApp\\CloudComputing\\whats-new-in-java\\src\\main\\resources\\sander.tiff"));
        ImageReader tiffReader = ImageIO.getImageReadersByFormatName("tiff").next();
        tiffReader.setInput(inputStream);
        BufferedImage image = tiffReader.read(0);

        System.out.println("Height: " + image.getHeight());
        System.out.println("Width: " + image.getWidth());


    }
}
