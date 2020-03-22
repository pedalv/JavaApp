package no.book.chapter2DesignPatternsandPrinciples.designinganinterface;

import java.util.List;

/*
Mock Objects
You might wonder how a developer using the interface can build their code without
   access to a class that implements the interface.
The developer using the interface can create a temporary mock object,
   sometimes referred to as dummy code, which simulates
   the real object that implements the interface with a simple implementation.
The mock object does not need to be very complex, with one line per abstract method,
   for example, as it only serves as a placeholder for the real implementation.
This allows the developer using the interface to compile, run, and test their code.
For example, imagine that you were working on a racing application with the code that
   calculates the winners handled by a different team.
Both your team and the other team agreed on a RaceManager interface,
   as shown in the following code, with your team using the interface
   and the other team implementing it:
*/
public class RealWorldScenario {
}

class Animal {}
class Tortoise extends Animal {}
class Hare extends Animal {}
interface RaceManager {
    public Animal getWinner(List<Animal> animals);
}

/*
The good news is that your team has finished its part of the project first.
The bad news is that the other team has nothing for you to test with.
While waiting for the other team to finish,
    you can create a mock version of the RaceManager class,
    as shown in the following sample code:
 */

class DummyRaceManager implements RaceManager {
    public Animal getWinner(List<Animal> animals) {
        return animals==null || animals.size()==0 ? null: animals.get(0);
    }
}

/*
The code isn’t particularly intelligent; after all it just returns the first item in the list,
    but it is useful for testing purposes because it allows your team to execute your code
    while the other team finishes their implementation.
You could also write a version that always returns Tortoise or Hare.
The goal is just to give you something temporary that you can work with and that allows your code to compile,
    regardless of whether it works exactly as expected.
After all, the full implementation of getWinner() could be
    hundreds of lines long and based on very complex business rules.
 */
