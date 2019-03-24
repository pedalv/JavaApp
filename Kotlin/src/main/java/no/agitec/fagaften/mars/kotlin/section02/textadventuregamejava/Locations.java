package no.agitec.fagaften.mars.kotlin.section02.textadventuregamejava;

import java.io.*;
import java.util.*;

public class Locations {

    public static Map<Integer, Location> locations = new HashMap();

    static {
        Scanner scanner = null;

        // Read locations
        try {
            scanner = new Scanner(new FileReader(getFilePath() + "locations_big.txt"));
            scanner.useDelimiter(",");
            while(scanner.hasNextLine()) {
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                locations.put(loc, new Location(loc, description));
            }

        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally {
            if(scanner != null) {
                scanner.close();
            }
        }

        // Now read the exits
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(getFilePath() + "directions_big.txt")));
            scanner.useDelimiter(",");
            while(scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);

                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(scanner != null) {
                scanner.close();
            }
        }
    }

    private static String getFilePath() {
        String filePath = new File("").getAbsolutePath();
        //System.out.println("** " + filePath + " **");
        String path = filePath + "/src/files-section2/";
        //System.out.println("** " + path + " **");
        path = filePath + "\\src\\main\\java\\no\\agitec\\fagaften\\mars\\kotlin\\section2\\textadventuregamejava\\files-java\\";
        //System.out.println("** " + path + " **");
        return path;
    }
}
