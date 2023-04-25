package no.dfo.whatsnewinjava.instanceofpattern;

public record Person(String name) {


    @Override
    public boolean equals(Object obj) {
        //return (obj instanceof Person) && ((Person) obj).name.equals(name);
        return obj instanceof Person p && p.name.equals(name);
    }
}
