package oracle.certified.associate.SE81Z0803.test4;

/**
 * Created by pedro alves on 22/03/15.
 */
public class Q89 {

    /*
    Throwable
        Exception
            RuntimeException
                IndexOutOfBoundsException
                    StringIndexOutOfBoundsException
    */


    public static void main(String ... args){
        try{
            System.out.println("012345".charAt(6)) ;
        } catch(StringIndexOutOfBoundsException e){

            System.out.println(
                "Throwable\n" +
                "   Exception\n" +
                "       RuntimeException\n" +
                "           IndexOutOfBoundsException\n" +
                "               StringIndexOutOfBoundsException\n"
            );

        }




    }



}



    /**
     * Returns the <code>char</code> value at the
     * specified index. An index ranges from <code>0</code> to
     * <code>length() - 1</code>. The first <code>char</code> value of the sequence
     * is at index <code>0</code>, the next at index <code>1</code>,
     * and so on, as for array indexing.
     *
     * <p>If the <code>char</code> value specified by the index is a
     * <a href="Character.html#unicode">surrogate</a>, the surrogate
     * value is returned.
     *
     * @param      index   the index of the <code>char</code> value.
     * @return     the <code>char</code> value at the specified index of this string.
     *             The first <code>char</code> value is at index <code>0</code>.
     * @exception  IndexOutOfBoundsException  if the <code>index</code>
     *             argument is negative or not less than the length of this
     *             string.
     */
/*
    public char charAt(int index) {
        if ((index < 0) || (index >= value.length)) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return value[index];
    }
*/
