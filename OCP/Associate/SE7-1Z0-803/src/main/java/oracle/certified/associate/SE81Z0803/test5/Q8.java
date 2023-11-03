package oracle.certified.associate.SE81Z0803.test5;

/**
 * Created by pedro alves on 15/03/15.
 */
public class Q8 {

    public static void main(String ... args){
        char c;
        int i;
        final int ifinal = 1;
        c='a';
        i=c;
        /*
        A char value can ALWAYS be assigned to an int variable,
        since the int type is wider than the char type.
         */
        i++;
        c=(char)i;
        /*
        It will compile if you cast it to (char) because it is
        trying to assign an int to a char. Although the value
        of i can be held by the char but since "i" is not a constant
        but a variable, implicit narrowing will not occur
         */
        c=ifinal;//final works without cast
        c++;
    }
    /*
    Here is the ruke in JLS:
    A narrowing primitive conversion may be used if all of te following conditions are satisfied:
    - the expression is a constant expression of type int
    - the type of the variable is byte, short, or char
    - the value of the expression (which is know at compile time, because it is a constant
    expression) is representable in the type of the variable
    -- note tha narrowing conversion does not apply to long or double so, char ch=30L;
    will fail although 30 is representable by a char.
     */

}
