package no.book.chapter1AdvancedClassDesign.accessmodifiers.cat;

/*
The line with cat.name compiles in all four classes because any code can access public members.

The line with cat.id compiles only in BigCat because only code in the same class can access private members.

The line with cat.hasPaws compiles only in BigCat and CatAdmirer because only code
    in the same package can access code with default access.

Finally, the line with cat.hasFur also compiles only in BigCat and CatAdmirer.
protected allows subclasses and code in the same package to access members.

Lynx is a tricky one.
Since the code is being accessed via the variable rather than by inheritance, it does not
    benefit from protected.
However, if the code in main was Lynx cat = new Lynx();, Lynx would be able
    to access cat.hasFur using protected access because it would be seen as a subclass.
 */
public class BigCat {

    public String name = "cat";
    protected boolean hasFur = true;
    boolean hasPaws = true; //default
    private int id;

}
