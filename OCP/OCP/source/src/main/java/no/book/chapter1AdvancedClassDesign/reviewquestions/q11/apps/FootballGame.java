package no.book.chapter1AdvancedClassDesign.reviewquestions.q11.apps;

// INSERT CODE HERE
/*
Error:java: cannot find symbol
  symbol:   variable TEAM_SIZE
  location: class no.book.chapter1AdvancedClassDesign.reviewquestions.q11.apps.FootballGame
 */
//import static no.book.chapter1AdvancedClassDesign.reviewquestions.q11.sports.Football.TEAM_SIZE;
import static no.book.chapter1AdvancedClassDesign.reviewquestions.q11.sports.Football.*;
/*
OKAY
 */


//import no.book.chapter1AdvancedClassDesign.reviewquestions.q11.sports.Football;
/*
Error: java: cannot find symbol
  symbol:   variable TEAM_SIZE
  location: class no.book.chapter1AdvancedClassDesign.reviewquestions.q11.apps.FootballGame
 */

//import static no.book.chapter1AdvancedClassDesign.reviewquestions.q11.sports.*;
/*
Error: java: cannot find symbol
  symbol:   class sports
  location: package no.book.chapter1AdvancedClassDesign.reviewquestions.q11
Error: java: cannot find symbol
  symbol:   variable TEAM_SIZE
  location: class no.book.chapter1AdvancedClassDesign.reviewquestions.q11.apps.FootballGame
 */

//import static no.book.chapter1AdvancedClassDesign.reviewquestions.q11.sports.Football;
/*
Error: java: cannot find symbol
  symbol:   class sports
  location: package no.book.chapter1AdvancedClassDesign.reviewquestions.q11
Error: java: static import only from classes and interfaces
Error: java: cannot find symbol
  symbol:   variable TEAM_SIZE
  location: class no.book.chapter1AdvancedClassDesign.reviewquestions.q11.apps.FootballGame
*/


public class FootballGame {
    public int getTeamSize() { return TEAM_SIZE; }
}

/*
Which of the following statements can be inserted to make FootballGame compile?

            A. import my.sports.Football;
        B. import static my.sports.*;
        C. import static my.sports.Football;
D. import static my.sports.Football.*;
    E. static import my.sports.*;
    F. static import my.sports.Football;
    G. static import my.sports.Football.*;


D.
FootballGame is trying to refer to a static variable in another class.
It needs a static import to do so.
The correct syntax is import static and not static import.
B is incorrect because * does not import classes in a package.
C is incorrect because it does not refer to a static member.

 */