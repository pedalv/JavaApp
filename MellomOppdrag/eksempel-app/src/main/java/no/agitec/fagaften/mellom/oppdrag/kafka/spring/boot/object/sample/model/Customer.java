package no.agitec.fagaften.mellom.oppdrag.kafka.spring.boot.object.sample.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {

    private String name;
    private int age;



/*
    public Customer(){
    }

    public Customer(String name, int age){
        this.name = name;
        this.age = age;
    }


    public Customer(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }

    public String toString(){
        String info = String.format("{ 'name': %s, 'age': %d}", name, age);
        return info;
    }
*/
}
