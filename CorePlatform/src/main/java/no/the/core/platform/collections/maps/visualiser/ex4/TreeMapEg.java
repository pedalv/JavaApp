package no.the.core.platform.collections.maps.visualiser.ex4;

import no.the.core.platform.collections.maps.visualiser.Console;
import no.the.core.platform.collections.maps.visualiser.TreeMapVisualiser;

import java.util.TreeMap;

public class TreeMapEg
{
    public static void main(String[] args)
    {
        final Console console = new Console();
        final TreeMapVisualiser visualiser = new TreeMapVisualiser(console);
        final TreeMap<String, String> treeified = new TreeMap<>();

        for (int i = 0; i < 26; i++)
        {
            final String value = String.valueOf(i);
            treeified.put(value, value);
            console.clear();
            visualiser.visualise(treeified);
            console.await();
        }
    }
}
