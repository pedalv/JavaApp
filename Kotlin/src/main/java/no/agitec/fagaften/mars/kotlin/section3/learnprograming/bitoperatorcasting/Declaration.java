package no.agitec.fagaften.mars.kotlin.section3.learnprograming.bitoperatorcasting;

import no.agitec.fagaften.mars.kotlin.section3.learnprograming.equality.Employee;
import no.agitec.fagaften.mars.kotlin.section3.learnprograming.equality.Employeej;

public class Declaration {


    public static void main(String ... args) {


        int x = 0x00101101;
        int y = 0x11011011;
        int a = x | y;
        int b = x & y;
        int c = x ^ y;


        Employeej employeeOne = new Employeej("Mary", 1);
        Employeej employeeFour = new Employeej("John", 2);

        Object something = employeeFour;
        if (something instanceof  Employee) {
            //val newEmployee = something as Employee
            Employeej somethingj = (Employeej) employeeOne;
            System.out.println(somethingj.getName());
        }

    }


}
