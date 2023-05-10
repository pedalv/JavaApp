package no.dfo.whatsnewinjava.records;

import java.time.Duration;

public class MainRecordCourse {

    public static void main(String... args) {

        Course course = new Course("Whats is new us Java 12",
                Duration.ofHours(1), 5);

        Course course2 = new Course("Whats is new us Java 14",
                Duration.ofHours(1), 2);


        System.out.println( course == course2);
        System.out.println( course.equals(course2));

        Course course3 = new Course("Whats is new us Java 14",
                Duration.ofHours(1), 6);
        //throw new IllegalArgumentException("bla.................bla");
    }

}
