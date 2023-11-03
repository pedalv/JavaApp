package no.the.core.platform.collections;

import java.lang.reflect.Array;
import java.util.*;

public class CollectionGenericTypes {

    private ArrayList<String> list;
    private LinkedList<String> list2;
    private ArrayList<MyClass> list3;

    public CollectionGenericTypes() {
        list = new ArrayList();
        list2 = new LinkedList<>();
        list3 = new ArrayList<>();
    }

    public void listofthings() {

        //populateShowSize();
        //copyList();
        //remMember();
        //java8collectionmethods();
        //convertingCollectionToArray();
        //convertingArrayToCollection();
        //sorting();
        //mapCollections();
        sortingMapCollections();
    }

    private void sortingMapCollections() {
        SortedMap<String, String> map = new TreeMap();
        map.put("2222","ghi");
        map.put("3333","abc");
        map.put("1111","def");
        map.put("6666","xyz");
        map.put("4444","mno");
        map.put("5555","pqr");

        map.forEach( (k, v) -> System.out.println( k + " | " + v));

        SortedMap<String, String> hMap = map.headMap("3333");
        hMap.forEach( (k, v) -> System.out.println( k + " | " + v));

        SortedMap<String, String> tMap = map.tailMap("3333");
        tMap.forEach( (k, v) -> System.out.println( k + " | " + v));
    }

    private void mapCollections() {
        // key/value pairs

        Map<String, String> map = new HashMap();
        map.put("222","ghi");
        map.put("333","abc");
        map.put("111","def");

        String s1 = map.get("333");
        String s2 = map.get("999");
        String s3 = map.getOrDefault("999","xyz");
        System.out.println(s1 + " - " + s2 + " - " + s3 );

        map.forEach( (k, v) -> System.out.println( k + " | " + v));

        map.replaceAll( (k,v) -> v.toUpperCase());
        map.forEach( (k, v) -> System.out.println( k + " | " + v));
    }

    private void sorting() {

        byMyClassComparable();

        byMyComrarator();
    }

    private void byMyComrarator() {
        TreeSet<MyClass> tree = new TreeSet<>(new MyComparator());
        tree.add(new MyClass("222", "ghi"));
        tree.add(new MyClass("333", "abc"));
        tree.add(new MyClass("111", "def"));

        tree.forEach(m -> System.out.println(m)); //toString method
    }

    private void byMyClassComparable() {
        TreeSet<MyClass> tree = new TreeSet<>();
        tree.add(new MyClass("222", "ghi"));
        tree.add(new MyClass("333", "abc"));
        tree.add(new MyClass("111", "def"));

        tree.forEach(m -> System.out.println(m)); //toString method
    }

    private void convertingArrayToCollection() {
        MyClass[] myArray = {
                new MyClass("v1", "abc"),
                new MyClass("v2", "def"),
                new MyClass("v3", "abc")
        };

        Collection<MyClass> list = Arrays.asList(myArray);
        list.forEach(c -> System.out.println(c.getLabel()));

        List<MyClass> list2 = Arrays.asList(myArray);
        list2.forEach(c -> System.out.println(c.getLabel()));

        /*
        java.util
        Interface List<E>

        Type Parameters:
        E - the type of elements in this list
        All Superinterfaces:
        Collection<E>, Iterable<E>

        All Known Implementing Classes:
        AbstractList, AbstractSequentialList,
        ArrayList, AttributeList, CopyOnWriteArrayList,
        LinkedList, RoleList, RoleUnresolvedList,
        Stack, Vector
         */
    }

    private void convertingCollectionToArray() {
        ArrayList<MyClass> list = new ArrayList<>();
        list.add(new MyClass("v1", "abc"));
        list.add(new MyClass("v2", "def"));
        list.add(new MyClass("v3", "abc"));

        //toArray()                -> returns object array
        Object[] objArray = list.toArray();

        //toArray(T[]array) method -> returns array of type T
        MyClass[] a1 = list.toArray(new MyClass[0]);
        MyClass[] a2 = list.toArray(new MyClass[3]);
        MyClass[] a3 = list.toArray(a2);
        if(a2 == a3)
            System.out.println("a2 & a3 reference the same array");
    }

    private void java8collectionmethods() {

        MyClass v1 = new MyClass("v1", "abc");
        MyClass v2 = new MyClass("v2", "def");
        MyClass v3 = new MyClass("v3", "abc");

        ArrayList<MyClass> list = new ArrayList<>();
        list.add(v1);
        list.add(v2);
        list.add(v3);

        //forEach
        list.forEach(m -> System.out.println(m.label));

        //remvelf
        list.removeIf(m -> m.getValue().equals("abc"));
        list.forEach(m -> System.out.println(m.label));
    }

    private void remMember() {
        MyClass v1 = new MyClass("v1", "abc");
        MyClass v2 = new MyClass("v2", "abc");
        MyClass v3 = new MyClass("v3", "abc");

        list3.add(v1);
        list3.add(v2);
        list3.add(v3);

        list3.remove(v3);
        for(MyClass m:list3) {
            System.out.println(m.getLabel());
        }
    }

    private void copyList() {
        list2.add("Baz");
        list2.add("Boo");

        list.addAll(list2);

        for(String s1:list) {
            System.out.println(s1);
        }
    }

    private void populateShowSize() {
        list.add("Foo");
        list.add("Bar");

        System.out.println("Elements: " + list.size());

        for(String o:list)
            System.out.println(o.toString());

        String s = list.get(0);

        SomeClassIMadeUp c = new SomeClassIMadeUp();
        //list.add(c); //no suitable method found for add - only allow String type now
    }

}
