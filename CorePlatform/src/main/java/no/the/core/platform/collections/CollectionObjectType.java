package no.the.core.platform.collections;

import java.util.ArrayList;

public class CollectionObjectType {

    private ArrayList list;


    public CollectionObjectType() {
        list = new ArrayList();
    }


    public void listofthings() {

        populateShowSize();

    }

    private void populateShowSize() {
        list.add("Foo");
        list.add("Bar");

        System.out.println("Elements: " + list.size());

        for(Object o:list)
            System.out.println(o.toString());

        String s = (String) list.get(0);

        SomeClassIMadeUp c = new SomeClassIMadeUp();

        list.add(c);
    }
}

class SomeClassIMadeUp {

}