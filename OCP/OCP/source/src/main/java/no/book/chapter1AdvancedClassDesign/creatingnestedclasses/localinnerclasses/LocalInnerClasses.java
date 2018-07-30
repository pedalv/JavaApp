package no.book.chapter1AdvancedClassDesign.creatingnestedclasses.localinnerclasses;

/*
Local Inner Classes
A local inner class is a nested class defined within a method.
Like local variables, a local inner class declaration does not exist until the method is invoked,
    and it goes out of scope when the method returns.
This means that you can create instances only from within the method.
Those instances can still be returned from the method.
This is just how local variables work.
Local inner classes have the following properties:
■ They do not have an access specifier.
■ They cannot be declared static and cannot declare static fields or methods.
■ They have access to all fields and methods of the enclosing class.
■ They do not have access to local variables of a method unless those variables are final or effectively final.
More on this shortly.


Inner Classes as Event Handlers
Writing graphical user interface code isn’t on the exam.
Nonetheless, it is a very common use of inner classes,
    so we’ll give you a taste of it here:

JButton button = new JButton("red");
button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // handle the button click
    }
});

This technique gives the event handler access to the instance variables in the class with which it goes.
It works well for simple event handling.
You should be aware that inner classes go against some fundamental concepts,
    such as reuse of classes and high cohesion (discussed in the next chapter).
Therefore, make sure that inner classes make sense before you use them in your code.
 */
public class LocalInnerClasses {
}
