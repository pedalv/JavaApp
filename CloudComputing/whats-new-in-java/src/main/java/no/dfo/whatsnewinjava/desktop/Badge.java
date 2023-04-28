package no.dfo.whatsnewinjava.desktop;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Work for Windows
 */
public class Badge {

    public static void main(String[] args) throws Exception {

        Frame frame = new Frame();
        frame.setSize(400, 400);
        frame.setVisible(true);


        if(Taskbar.isTaskbarSupported()) {
            Taskbar taskbar = Taskbar.getTaskbar();
            if(taskbar.isSupported(Taskbar.Feature.ICON_BADGE_TEXT)) {
                Thread.sleep(2000);
                taskbar.setIconBadge("test!");
            }
        }

    }
}
