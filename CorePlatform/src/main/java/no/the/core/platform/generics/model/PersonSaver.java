package no.the.core.platform.generics.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class PersonSaver
{
    private final RandomAccessFile file;

    public PersonSaver(final File file) throws FileNotFoundException
    {
        this.file = new RandomAccessFile(file, "rw");
    }

    public void save(Person person) throws IOException
    {
        file.writeUTF(person.getClass().getName());
        file.writeUTF(person.getName());
        file.writeInt(person.getAge());
    }

    //public <T extends Person>  void saveAll(final List<T> people) throws IOException
    // it is more cleaner the next way
    // T is use for declare a class and restrict it
    // ? is use for parameter on a method
    public void saveAll(final List<? extends Person> people) throws IOException
    {
        for (Person person : people)
        {
            save(person);
        }
    }

    public void saveAll(final Person[] people) throws IOException
    {
        for (Person person : people)
        {
            save(person);
        }
    }
}
