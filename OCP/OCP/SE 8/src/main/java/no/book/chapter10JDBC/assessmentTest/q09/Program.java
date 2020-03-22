package no.book.chapter10JDBC.assessmentTest.q09;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

    public void stmt(Connection conn, int a) throws SQLException {
        // PARM 2
        Statement stmt = conn.createStatement(a, ResultSet.CONCUR_READ_ONLY );
        stmt = conn.createStatement(a, ResultSet.CONCUR_UPDATABLE );


        // PARM 1
        stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE );
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );


    }

    /**
     * Creates a <code>Statement</code> object that will generate
     * <code>ResultSet</code> objects with the given type and concurrency.
     * This method is the same as the <code>createStatement</code> method
     * above, but it allows the default result set
     * type and concurrency to be overridden.
     * The holdability of the created result sets can be determined by
     * calling {@link #getHoldability}.
     *
     * @param resultSetType a result set type; one of
     *        <code>ResultSet.TYPE_FORWARD_ONLY</code>,
     *        <code>ResultSet.TYPE_SCROLL_INSENSITIVE</code>, or
     *        <code>ResultSet.TYPE_SCROLL_SENSITIVE</code>
     * @param resultSetConcurrency a concurrency type; one of
     *        <code>ResultSet.CONCUR_READ_ONLY</code> or
     *        <code>ResultSet.CONCUR_UPDATABLE</code>
     * @return a new <code>Statement</code> object that will generate
     *         <code>ResultSet</code> objects with the given type and
     *         concurrency
     * @exception SQLException if a database access error occurs, this
     * method is called on a closed connection
     *         or the given parameters are not <code>ResultSet</code>
     *         constants indicating type and concurrency
     * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
     * this method or this method is not supported for the specified result
     * set type and result set concurrency.
     * @since 1.2
     */
    //Statement createStatement(int resultSetType, int resultSetConcurrency)
            //hrows SQLException;

}

/*

 stmt = conn.createStatement(a, ResultSet.CONCUR_READ_ONLY );
 stmt = conn.createStatement(a, ResultSet.CONCUR_UPDATABLE );

Which of the following can fill in the blank? (Choose all that apply.)

A. ResultSet.CONCUR_READ_ONLY
    B. ResultSet.CONCUR_INSERTABLE
C. ResultSet.CONCUR_UPDATABLE
    D. ResultSet.TYPE_FORWARD_ONLY
    E. ResultSet.TYPE_SCROLL_INSENSITIVE
    F. ResultSet.TYPE_SCROLL_SENSITIVE

Answer
A
C

The first parameter is the ResultSet type.
The second parameter is the ResultSet concurrency mode.
Choices D, E, and F are incorrect because they represent the first parameter.
Choice B is incorrect because it is not a constant in JDBC.
Choices A and C are correct.
For more information, see Chapter 10.

 */