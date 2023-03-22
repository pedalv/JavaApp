package no.dfo.whatsnewinjava.textblocks;

import lombok.extern.slf4j.Slf4j;

/**
 * Multi-line Strings
 */
@Slf4j
public class MainTextBlocks {

    public static void main(String ...args) {
        String json_old = "{\n \"key1\": \"value1\",\n \"key2\": \"value2\"}";
        log.info(json_old);

        String json_old2 = "{\n " +
                " \"key1\": \"value1\",\n" +
                " \"key2\": \"value2\" \n" +
                "}";
        log.info(json_old2);

        String json_old3 = new StringBuilder()
                .append("{\n ")
                .append(" \"key1\": \"value1\",\n")
                .append(" \"key2\": \"value2\" \n")
                .append("}")
                .toString();
        log.info(json_old3);

        String json = """
                {
                    "key1" : "value1"  ,
                    "key2": "value2"
                }""";
        log.info(json);

    }

}
