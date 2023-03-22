package no.dfo.whatsnewinjava.records;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainRecordOthers {

    public static void main(String ...args) {
        Person p = new Person("name", "address");
        log.info(p.toString());
        PersonLombok plambok = new PersonLombok("name", "address");
        log.info(plambok.toString());
        PersonRecord precord = new PersonRecord("name", "address");
        log.info(precord.toString());
    }

}
