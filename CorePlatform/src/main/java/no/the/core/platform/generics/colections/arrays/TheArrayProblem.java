package no.the.core.platform.generics.colections.arrays;

import no.the.core.platform.generics.model.Person;

import java.util.Arrays;

/*
    1. add elm: copy array for add new person
    2. show: need use Arrays.toString
    3. contains: not available
 */
public class TheArrayProblem
{
    public static void main(String[] args)
    {
        Person donDraper = new Person("Don Draper", 89);
        Person peggyOlson = new Person("Peggy Olson", 65);

        Person[] madMen = { donDraper, peggyOlson };

        System.out.println(Arrays.toString(madMen));

        madMen = add(new Person("Bert Cooper", 100), madMen);

        System.out.println(Arrays.toString(madMen));

        madMen = add(peggyOlson, madMen);

        System.out.println(Arrays.toString(madMen));
    }

    private static Person[] add(Person person, Person[] array)
    {
        int length = array.length;
        Person[] newArray = Arrays.copyOf(array, length + 1);
        newArray[length] = person;
        return newArray;
    }
}
