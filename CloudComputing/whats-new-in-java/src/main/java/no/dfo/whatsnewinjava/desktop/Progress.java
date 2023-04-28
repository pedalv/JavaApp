package no.dfo.whatsnewinjava.desktop;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Set;

public class Progress {

    public static void main(String[] args) throws Exception {

        Taskbar bar = Taskbar.getTaskbar();
        if (bar.isSupported(Taskbar.Feature.ICON_IMAGE)) {
            Image icon = ImageIO.read(new File("C:\\workspace2\\JavaApp\\CloudComputing\\whats-new-in-java\\src\\main\\resources\\icon.jpg"));
            bar.setIconImage(icon);
        }

        Thread.sleep(1000);
        for (int i = 0; i <= 100; i++) {
            bar.setProgressValue(i);
            //Exception in thread "main" java.lang.UnsupportedOperationException: The PROGRESS_VALUE feature is not supported on the current platform!
            Thread.sleep(30);
        }

        bar.setIconBadge("Done!");

        // Only works if application doesn't have focus
        bar.requestUserAttention(true, true);


        Thread.sleep(7000);
    }
}
