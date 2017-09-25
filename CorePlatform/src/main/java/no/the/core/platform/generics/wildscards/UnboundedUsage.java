package no.the.core.platform.generics.wildscards;

import no.the.core.platform.generics.model.Person;

import java.util.ArrayList;
import java.util.List;

public class UnboundedUsage
{
    public static void main(String[] args) throws ClassNotFoundException
    {
        // - Unbounded: List<?>
        // eks:
        // final Class<?> personClass = Class.forName(className);
        // final Class<? extends Object> personClass = Class.forName(className);
        // is use to get

        //List<Object> objects = new ArrayList<>();
        List<? super Object> objects = new ArrayList<>();
        // is use to put
        objects.add(new Object());
        objects.add(new Person("Don Draper", 89));
        System.out.println(objects);

        // Its only safe to add null to a List<?>
        List<?> wildcards = new ArrayList<>();
        wildcards.add(null);
        System.out.println(wildcards);
    }

}


/*
    RESUME
    - T is use for declare a class and restrict it
    - ? is use for parameter on a method
    - put: loadAll - <? super Person> - parameters
    - get: saveAll - <? extends Person> - parameters
    - <?>: to get type information for everything
    - <? extends Object>: to get type information that is parent of a Object
    - <? super Person>: to set/put type information that is a person or parent of a person: person, employ, partner
    - <object>: to set/put/get type information that is object and parent of Object => arrays
    - UpperBounded: List<? extends cls> - get
    - Lower Bounded: List<? super cls> - set/put
    - Unbounded: List<?>
 */