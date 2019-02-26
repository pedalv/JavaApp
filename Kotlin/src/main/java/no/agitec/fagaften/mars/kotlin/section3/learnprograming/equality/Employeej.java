package no.agitec.fagaften.mars.kotlin.section3.learnprograming.equality;

import java.util.Objects;

public class Employeej {

    private String name;
    private int id;

    public Employeej(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employeej{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (obj instanceof Employeej) {
                return name.equals(((Employeej) obj).name) &&
                        id == ((Employeej) obj).id;
        }

        return false;

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
