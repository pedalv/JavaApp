package no.book.chapter2DesignPatternsandPrinciples.implementingfunctionalinterfaceswithlambdas;

public class FindMatchingAnimals {

    private static void print(Animal animal, CheckTrait trait) {
        if(trait.test(animal))
            System.out.println(animal);
    }

    /*
    For illustrative purposes, the lambda expression chosen for this program is quite simple:
        a -> a.canHop();
    This expression means that Java should call a method with an Animal parameter that
        returns a boolean value that’s the result of a.canHop().
    We know all this because we wrote the code.
    But how does Java know?
    Java relies on context when figuring out what lambda expressions mean.
    We are passing this lambda as the second parameter of the print() method.
    That method expects a CheckTrait as the second parameter.
    Since we are passing a lambda instead, Java treats CheckTrait
        as a functional interface
        and tries to map it to the single abstract method:
            boolean test(Animal a);
    Since this interface’s method takes an Animal,
        it means the lambda parameter has to be an Animal.
    And since that interface’s method returns a boolean,
        we know that the lambda returns a boolean.

    Note:
    Recall that lambda expressions rely on the notion of deferred execution.
    Deferred execution means that code is specified now but runs later.
    In this case, later is when the print() method calls it.
    Even though the execution is deferred, the compiler will still validate
        that the code syntax is properly formed.
     */
    public static void main(String[] args) {
        print(new Animal("fish", false, true), a -> a.canHop());
        print(new Animal("kangaroo", true, false), a -> a.canHop());
    }

}

/*
Understanding Lambda Syntax
The syntax of lambda expressions is tricky because many parts are optional.
These two lines are equivalent and do the exact same thing:

    Line 1: a -> a.canHop()
    Line 2: (Animal a) -> { return a.canHop(); }

Let’s look at what is going on here.
The left side of the arrow operator -> indicates the input parameters for the lambda expression.
It can be consumed by a functional interface whose abstract method has the same number of parameters
    and compatible data types.
The right side is referred to as the body of the lambda expression.
It can be consumed by a functional interface whose abstract method returns a compatible data type.
Since the syntax of these two expressions is a bit different, let’s look at them more closely.
The first example, has three parts:
■ We specify a single parameter with the name a .
■ The arrow operator → separates the parameter from the body.
■ The body calls a single method and returns the result of that method.

The second example also has three parts, as shown in Line 2; it’s just more verbose:
■■ We specify a single parameter with the name a and state that the type is Animal,
    wrapping the input parameters in parentheses ().
■■ The arrow operator −> separates the parameter from the body.
■■ The body has one or more lines of code,
        including braces {},
        a semicolon ;,
        and a return statement.


The first difference that you may notice is that Line 2 uses parentheses (), while Line 1 does not.
The parentheses () can be omitted in a lambda expression if there is exactly one input parameter
    and the type is not explicitly stated in the expression.
This means that expressions that have zero or more than one input parameter will still require parentheses.
For example, the following are all valid lambda expressions,
    assuming that there are valid functional interfaces that can consume them:

    () -> new Duck()
    d -> {return d.quack();}
    (Duck d) -> d.quack()
    (Animal a, Duck d) -> d.quack()

The first lambda expression could be used by a functional interface containing a
    method that takes no arguments and returns a Duck object.
The second and third lambda expressions can both be used by a functional interface
    that takes a Duck as input and returns whatever the return type of quack() is.
The last lambda expression can be used by a functional interface that takes
    as input Animal and Duck objects
    and returns whatever the return type of quack() is.

Spotting Invalid Lambdas
Can you figure out why each of the following lambda expressions is invalid and will not
compile when used as an argument to a method?

    Duck d -> d.quack() // DOES NOT COMPILE
    a,d -> d.quack() // DOES NOT COMPILE
    Animal a, Duck d -> d.quack() // DOES NOT COMPILE

They each require parentheses ()!
As we said, parentheses can be omitted only if there is
    exactly one parameter and the data type is not specified.

Next, you see that Line 2 has a pair of statement braces {} around the body of
    the lambda expression.
This allows you to write multiple lines of code in the body of the
    lambda expression, as you might do when working with an if statement or while loop.
What’s tricky here is that when you add braces {}, you must explicitly terminate each
    statement in the body with a semicolon;.

In Line 1, we were able to omit the braces {},
    semi‐colon;,
    and return statement,
    because this is a special shortcut that Java allows for single‐line lambda bodies.
This special shortcut doesn’t work when you have two or more statements.
At least this is consistent with using {} to create blocks of code else where in Java.
When using {} in the body of the lambda expression,
    you must use the return statement if the functional interface method
    that lambda implements returns a value.
Alternatively, a return statement is optional when
    the return type of the method is void.

Let’s look at some more examples:

    () -> true // 0 parameters
    a -> {return a.startsWith("test");} // 1 parameter
    (String a) -> a.startsWith("test") // 1 parameter
    (int x) -> {} // 1 parameter
    (int y) -> {return;} // 1 parameter

The first example takes no arguments and always returns true.
The second and third examples both take a single String value,
    using different syntax to accomplish the same thing.
Notice that in the first two examples we mixed and matched syntax between Line 1
    and Line 2 by having the first example use parentheses ()
    but no braces {}
    and reversing this in the second example.
The last two examples are equivalent because they
    take an integer value
    and do not return anything.

Now let’s look at some lambda expressions that take more than one parameter:

    (a, b) -> a.startsWith("test") // 2 parameters
    (String a, String b) -> a.startsWith("test") // 2 parameters

These examples both take two parameters
    and ignore one of them,
    since there is no rule that says the lambda expression must use all of the input parameters.
Let’s review some additional lambda expressions to see how your grasp of lambda
    syntax is progressing.
Do you see what’s wrong with each of these lambda expressions?

    a, b -> a.startsWith("test") // DOES NOT COMPILE
    c -> return 10; // DOES NOT COMPILE
    a -> { return a.startsWith("test") } // DOES NOT COMPILE

The first lambda needs parentheses () around the parameter list.
Remember that the parentheses are optional only when there is one parameter
    and it doesn’t have a type declared.
The second line uses the return keyword without using braces {}.
The last line is missing the semicolon after the return statement.

The following rewritten lambda expressions are each valid:

    (a, b) -> a.startsWith("test")
    c -> { return 10; }
    a -> { return a.startsWith("test"); }

As mentioned, the data types for the input parameters of a lambda expression are optional.
When one parameter has a data type listed, though, all parameters must provide a data type.
The following lambda expressions are each invalid for this reason:

    (int y, z) -> {int x=1; return y+10; } // DOES NOT COMPILE
    (String s, z) -> { return s.length()+z; } // DOES NOT COMPILE
    (a, Animal b, c) -> a.getName() // DOES NOT COMPILE

If we add or remove all of the data types, then these lambda expressions do compile.
For example, the following rewritten lambda expressions are each valid:

    (y, z) -> {int x=1; return y+10; }
    (String s, int z) -> { return s.length()+z; }
    (a, b, c) -> a.getName()

There is one more issue you might see with lambdas.
We’ve been defining an argument list in our lambda expressions.
Since Java doesn’t allow us to re‐declare a local variable, the following is an issue:

    (a, b) -> { int a = 0; return 5;} // DOES NOT COMPILE

We tried to re‐declare a, which is not allowed.
By contrast, the following line is permitted because it uses a different variable name:

    (a, b) -> { int c = 0; return 5;}




 */