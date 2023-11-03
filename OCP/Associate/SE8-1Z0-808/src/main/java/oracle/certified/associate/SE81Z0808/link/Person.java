package oracle.certified.associate.SE81Z0808.link;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by p on 26/03/2017.
 */
public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public Sex getGender() {
        return gender;
    }


    public String getEmailAddress() {
        return emailAddress;
    }

    public int getAge() {
        if(birthday != null)
            return LocalDate.now().getYear() -  birthday.getYear();

        return -1;
    }

    public void printPerson() {

        System.out.println(
                "Name: " + name +
                "\nAge: " + getAge() +
                "\nGender:" + gender +
                "\nemailAddress: " + emailAddress
        );

    }

    public static List<Person> createRoster() {

        List<Person> persons = new ArrayList<>();
        Person p = new Person();
        p.name = "Name";
        p.birthday = LocalDate.of(1977,9,3);
        p.gender = Sex.MALE;
        p.emailAddress = "a@zz.no";

        persons.add(p);

        return persons;

    }

}
