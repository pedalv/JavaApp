package no.dfo.whatsnewinjava.instanceofpattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public record Person(String name) {


    @Override
    public boolean equals(Object obj) {
        //return (obj instanceof Person) && ((Person) obj).name.equals(name);
        return obj instanceof Person p && p.name.equals(name);
    }
}
