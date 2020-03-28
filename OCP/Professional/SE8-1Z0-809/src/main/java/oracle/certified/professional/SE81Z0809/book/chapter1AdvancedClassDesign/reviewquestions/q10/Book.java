package oracle.certified.professional.SE81Z0809.book.chapter1AdvancedClassDesign.reviewquestions.q10;

public class Book {

    private int pageNumber = 939283928;
    //private String pageString = "JHJHJHJHJHJHJ";

    private class BookReader {
        public int getPage() {
            return pageNumber;
        }
    }


    public static void main(String ... args) {
        new Book().new BookReader().getPage();

        //System.out.println(new Book().new BookReader().getPage());
    }

}

/*
The following code appears in a file named Book.java. What is the result of compiling the
source file?

    A. The code compiles successfully, and one bytecode file is generated: Book.class.
    B. The code compiles successfully, and two bytecode files are generated: Book.class and BookReader.class.
C. The code compiles successfully, and two bytecode files are generated: Book.class and Book$BookReader.class.
    D. A compiler error occurs on line 3.
    E. A compiler error occurs on line 5.

ANSWER
C
Book$BookReader.class
Book.class

med main
same

med main + create object
Book$1.class
Book$BookReader.class
Book.class

C.
The code compiles fine.
A member inner class is allowed to be private, and it is
    allowed to refer to instance variables from the outer class.
Two .class files are generated.
Book.class matches the name of the outer class.
The inner class does not compile to BookReader.class.
That would introduce the possibility of a naming conflict.
Book$BookReader.class is correct because it shows the scope of the class is limited to Book.
You don’t need to know that $ is the syntax,
    but you do need to know the number of classes
    and that BookReader is not a top-level class.

 */