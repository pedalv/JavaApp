package no.dfo.application;

import org.apache.commons.lang3.StringUtils;

/**
 * https://mvnrepository.com/artifact/org.apache.commons/commons-lang3
 * - fra Mar 02, 2021
 * // https://mvnrepository.com/artifact/org.apache.commons/commons-lang3
 * implementation 'org.apache.commons:commons-lang3:3.12.0'
 *
 * // https://mvnrepository.com/artifact/org.apache.commons/commons-lang3
 * implementation group: 'org.apache.commons', name: 'commons-lang3', version: '3.12.0'
 *
 * <!-- https://mvnrepository.com/artifact/org.apache.commons/commons-lang3 -->
 * <dependency>
 *     <groupId>org.apache.commons</groupId>
 *     <artifactId>commons-lang3</artifactId>
 *     <version>3.12.0</version>
 * </dependency>
 *
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String output = StringUtils.leftPad("Leftpad FTW!", 20);
        System.out.println(output);
    }
}