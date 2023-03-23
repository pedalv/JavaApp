package no.dfo.whatsnewinjava.teeingcollector;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Teeing Collector
 * Collector<T, ?, R> teeing(Collector<? super T, ?, R1> downstream1,
 *                               Collector<? super T, ?, R2> downstream2,
 *                               BiFunction<? super R1, ? super R2, R> merger)
 */
@Slf4j
public class MainTeeinCollectorStreams {

    public static void main(String ...args) {

        var ints = Stream.of(10, 20, 30, 40);
        long average = ints.collect(
                Collectors.teeing(
                        Collectors.summarizingInt(Integer::valueOf),
                        Collectors.counting(),
                        (sum, count) -> sum.getCount() + count
                )
        );
        log.info(String.valueOf(average)); //8
    }

}
