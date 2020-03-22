package no.book.chapter1AdvancedClassDesign.reviewquestions.q01;

public class Employee {
    public int employeeId;
    public String firstName, lastName;
    public int yearStarted;

    @Override
    public int hashCode() {
        return employeeId;
    }

    public boolean equals(Employee e) {
        return this.employeeId == e.employeeId;
    }

    public static void main(String[] args) {
        Employee one = new Employee();
        one.employeeId = 101;

        Employee two = new Employee();
        two.employeeId = 101;

        if (one.equals(two)) System.out.println("Success"); //101 == 101
        else System.out.println("Failure");
    }
}

/*
What is the result of the following code?

A. Success
    B. Failure
    C. The hashCode() method fails to compile.
    D. The equals() method fails to compile.
    E. Another line of code fails to compile.
    F. A runtime exception is thrown.

ANSWER
A
Based on the equals() method in the code, objects are equal if they have the same employeeId.
The hashCode() method correctly overrides the one from Object.
The equals() method is an overload of the one from Object and not an override.
It would be better to pass Object since an override would be better to use here.
It is odd to override hashCode() and not equals().

 */