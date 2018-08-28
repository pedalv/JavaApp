package no.book.chapter1AdvancedClassDesign.assegmentTest.q02;

public abstract class Message { //Line 1
    public String recipient;

    public abstract /*final*/ void sendMessage(); // Line 3

    public static void main(String[] args) {
        Message m = new TextMessage();
        m.recipient = "1234567890";
        m.sendMessage(); // Line 7
    }

    static class TextMessage extends Message {

        public final void sendMessage() {
            System.out.println("Text message to " + recipient);
        }
    }
}

/*
Question 2
A. Text message to null.
B. Text message to 1234567890.
C. A compiler error occurs on line 1.
D. A compiler error occurs on line 3.
E. A compiler error occurs on line 7.
F. A compiler error occurs on another line.

Answer
D
The code does not compile because a method is not allowed to be both abstract and final.

If final were removed, the answer would be B.

An abstract class may contain an abstract method.
A static nested class may extend other classes.
For more information, see Chapter 1.
 */