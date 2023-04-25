package no.dfo.whatsnewinjava.records;

import java.time.Duration;

/**
 * Exception in thread "main" java.lang.IllegalArgumentException
 * 	at no.dfo.whatsnewinjava.records.Course.<init>(Course.java:9)
 * 	at no.dfo.whatsnewinjava.records.MainRecordCourse.main(MainRecordCourse.java:13)
 *
 * Exception in thread "main" java.lang.IllegalArgumentException: bla.................bla
 * 	at no.dfo.whatsnewinjava.records.Course.<init>(Course.java:19)
 * 	at no.dfo.whatsnewinjava.records.MainRecordCourse.main(MainRecordCourse.java:13)
 *
 * @param name
 * @param duration
 * @param rating
 */
public record Course(String name, Duration duration, int rating) {

    public Course {
        if(rating > 5) {
            throw new IllegalArgumentException("bla.................bla");
        }
    }

}
