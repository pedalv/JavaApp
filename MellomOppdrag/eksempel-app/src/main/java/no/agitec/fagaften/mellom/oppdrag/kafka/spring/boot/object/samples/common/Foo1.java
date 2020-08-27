package no.agitec.fagaften.mellom.oppdrag.kafka.spring.boot.object.samples.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Foo1 {

    private String foo;

/*
    public Foo1() {
    }

    public Foo1(String foo) {
        this.foo = foo;
    }

    public String getFoo() {
        return this.foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    @Override
    public String toString() {
        return "Foo1 [foo=" + this.foo + "]";
    }
*/
}
