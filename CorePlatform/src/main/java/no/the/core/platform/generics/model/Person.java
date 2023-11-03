package no.the.core.platform.generics.model;

import java.util.Comparator;
import java.util.Objects;

import static java.util.Comparator.comparing;

public class Person
{
    private final String name;
    private final int age;

    /* Java 7 */
    public static final Comparator<Person> BY_AGE1
            = new Comparator<Person>()
    {
        public int compare(final Person p1, final Person p2)
        {
            return Integer.compare(p1.getAge(), p2.getAge());
        }
    };


    /* Java 8 */
    public static final Comparator<Person> BY_AGE2
            = comparing(Person::getAge);



    public Person(String name, int age)
    {
        Objects.requireNonNull(name);

        this.name = name;
        this.age = age;
    }

    public int getAge()
    {
        return age;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return age == person.age
            && name.equals(person.name);
    }

    @Override
    public int hashCode()
    {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString()
    {
        return "Person{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
    }
}

