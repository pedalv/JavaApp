package no.dfo.fp.functionalprogramming.functionreactive.examples;

import no.dfo.fp.functionalprogramming.model.City;
import no.dfo.fp.functionalprogramming.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * New methods in the Collection API
 * Iterable, Collection, List
 * Map
 * Patterns, examples
 */
public class MainAPICollectionMap {

    public static void main(String[] args) {

        final Consumer<Person> println = System.out::println;

        Person p1 = new Person("Alice", "lastALI ", 23);
        Person p2 = new Person("Brian", "lastBRI", 56);
        Person p3 = new Person("Chelsea", "lastCHEL", 46);
        Person p4 = new Person("David", "lastDAV", 28);
        Person p5 = new Person("Erica", "lastERI", 37);
        Person p6 = new Person("Francisco", "lastFRA", 18);

        //default void forEach(Consumer<? super T> action);
        //default boolean removeIf(Predicate<? super E> filter) {
        List<Person> persons2 = new ArrayList<>(Arrays.asList(p1, p2,p3, p4, p5, p6));
        persons2.forEach(println);
        List<Person> persons3 = new ArrayList<>(List.of(new Person[]{p1, p2,p3, p4, p5, p6}));
        persons3.forEach(println);
        List<Person> persons4 = new ArrayList<>(List.of(p1, p2, p3, p4)); // mutable list
        persons4.forEach(println);
        List<Person> persons5 = Arrays.asList(p1, p2, p3, p4); // cant add or remove
        persons5.forEach(println);
        persons5.replaceAll( person -> new Person(person.getFirstName().toUpperCase(), person.getLastName().toUpperCase(), person.getAge()));

        List<Person> persons = Stream.of(p1, p2,p3, p4, p5, p6).collect(Collectors.toList());
        persons.forEach(println);
        persons.removeIf(person -> person.getAge() < 20);
        //******************IMPORTANT*****************
        persons.sort(Comparator.comparing(Person::getFirstName).thenComparing(Person::getAge).thenComparing(Person::getLastName));
        persons.sort(Comparator.comparing(Person::getAge).reversed());
        persons.forEach(p -> {
            p.setFirstName(p.getFirstName().toUpperCase());
            System.out.println(p.toString());
        });



        //default void replaceAll(UnaryOperator<E> operator)
        List<String> names = Stream.of("p1", "p2","p3", "p4", "p5", "p6").collect(Collectors.toList());
        names.replaceAll(name -> name.toUpperCase());
        names.replaceAll(String::toUpperCase);

        //--

        City newYork = new City("New York");
        City shanghai = new City("Shanghai");
        City paris = new City("Paris");
        City lisboa = new City("Lisboa");

        Map<City, List<Person>> map = new HashMap<>();

        System.out.println("People from Paris : " + map.get(paris)); // null
        System.out.println("People from Paris : " + map.getOrDefault(paris, Collections.EMPTY_LIST)); // []

        //default V putIfAbsent(K key, V value), if key exist not add otherwise add the value
        map.putIfAbsent(paris, new ArrayList<>());
        map.get(paris).add(p1);


        //default V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)
        // key or null
        // map.compute();

        //default V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)
        //map.computeIfPresent();

        //default V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) { ... }
        map.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p2); // the same as two lines above with putIfAbsent
        map.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p3);

        //Add a collection
        map.get(paris).addAll(persons2);

        System.out.println("People from Paris : " + map.getOrDefault(paris, Collections.EMPTY_LIST));
        System.out.println("People from New York : " + map.getOrDefault(newYork, Collections.EMPTY_LIST));

        Map<City, List<Person>> map1 = new HashMap<>();
        map1.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p1);
        map1.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p2);
        map1.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p3);

        System.out.println("Map 1");
        //default void forEach(BiConsumer<? super K, ? super V> action)
        map1.forEach((city, people) -> System.out.println(city + " : " + people));

        //default V getOrDefault(Object key, V defaultValue), return value of key when exist otherwise the defaultvalue
        map1.getOrDefault(newYork, Collections.emptyList());


        Map<City, List<Person>> map2 = new HashMap<>();
        map2.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p4);
        map2.computeIfAbsent(paris, city -> new ArrayList<>()).add(p5);
        map2.computeIfAbsent(paris, city -> new ArrayList<>()).add(p6);

        //******************IMPORTANT*****************
        //key, newValue
        //default V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        Map<String, Map<String, Person>> map3 = new HashMap<>();
        map3.computeIfAbsent("one", key -> new HashMap<String, Person>()).put("two", p3);

        System.out.println("Map 2");
        map2.forEach((city, people) -> System.out.println(city + " : " + people));

        //******************IMPORTANT*****************
        map2.forEach(
                (city, people) -> {
                    //default V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
                    map1.merge(
                            city, people,
                            (peopleFromMap1 /*existingPeople*/, peopleFromMap2 /*newPeople*/) -> {
                                peopleFromMap1.addAll(peopleFromMap2);
                                return peopleFromMap1;
                            });
                }
        );

        System.out.println("Merged map1 from map2");
        map1.forEach(
                (city, people) -> System.out.println(city + " : " + people)
        );

        //default boolean replace(K key, V oldValue, V newValue)
        //default V replace(K key, V value) {
        //map2.replace();

        //default void replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
        //map2.replaceAll();

        //default boolean remove(Object key, Object value)
        //V remove(Object key);
        //map2.remove();

        //default void replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
        //map2.replaceAll();
    }

}
