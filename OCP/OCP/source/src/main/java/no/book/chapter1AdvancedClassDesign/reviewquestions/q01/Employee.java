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

 */