package oracle.certified.associate.SE81Z0803.test6;

/**
 * Created by pedro alves on 25/05/15.
 */
public class Q26 {

    public static void main(String ... args){
        Manager m = new Manager();
    }

}


class Employee {
    static int i = 10;
    {
        i = 15;
        System.out.print(" Employee " + i);
    }
    static {System.out.print(" Employee static " + i);}


}

class Manager extends Employee {
    static {
        i = 45;
        System.out.print(" Manager static ");
    }
    {
        i = 30;
        System.out.print(" Manager " + i);
    }
}
/*

Although there is more to it that the following sequence, for the purpose of exam, this is all you need to know:

1. Static blocks of the base class (only once, in the order they appear in the class).

2. Static blocks of the class.

3. Non-static blocks of the base class.

4. Constructor of the base class.

5. Non-static blocks of the class.

6. Constructor of the class.

7. Derived class's static or non-static blocks are not executed if that class is not being used.
(For example, in this question class Owner is not being used.)

 */