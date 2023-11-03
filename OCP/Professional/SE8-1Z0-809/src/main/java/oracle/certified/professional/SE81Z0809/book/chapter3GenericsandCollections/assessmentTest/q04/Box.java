package oracle.certified.professional.SE81Z0809.book.chapter3GenericsandCollections.assessmentTest.q04;

public class Box<T> {
    T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public static void main(String[] args) {
        Box<String> one = new Box<String>("a string"); // Line 11
        Box<Integer> two = new Box<>(123);  // Line 12
        System.out.print(one.getValue());
        System.out.print(two.getValue());
    }
}

/*
Question 4
A. Compiler error on line 1.
B. Compiler error on line 2.
C. Compiler error on line 11.
D. Compiler error on line 12.
E. a string123
F. An exception is thrown.


Answer
E.
This class is a proper use of generics.
Box uses a generic type named T.
On line 11, the generic type is String.
On line 12 the generic type is Integer. Line 12 also uses the diamond operator.
See Chapter 3 for more information.
 */