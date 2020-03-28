package oracle.certified.professional.SE81Z0809.book.AssessmentTest.q19;

import javax.xml.validation.Schema;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExempleResultSet {

    public static void viewTable(Connection con, String dbName)
            throws SQLException {

        Statement stmt = null;

        String query =
                "select COF_NAME, SUP_ID, PRICE, " +
                        "SALES, TOTAL " +
                        "from " + dbName + ".COFFEES";

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);


            rs.absolute(-1);
            rs.absolute(0);
            rs.absolute(1);
            rs.beforeFirst();
            rs.first();
            rs.next();


            while (rs.next()) {
                String coffeeName = rs.getString("COF_NAME");
                int supplierID = rs.getInt("SUP_ID");
                float price = rs.getFloat("PRICE");
                int sales = rs.getInt("SALES");
                int total = rs.getInt("TOTAL");
                System.out.println(coffeeName + "\t" + supplierID +
                        "\t" + price + "\t" + sales +
                        "\t" + total);
            }
        } catch (SQLException e ) {
            //JDBCTutorialUtilities.printSQLException(e);
        } finally {
            if (stmt != null) { stmt.close(); }
        }
    }

}

/*
Which of the following position a ResultSet cursor to a location immediately before the first row?
(Choose all that apply.)

    A. rs.absolute(-1)
B. rs.absolute(0)
    C. rs.absolute(1)
D. rs.beforeFirst()
    E. rs.first()
    F. rs.next()

Answer
B
D

On a scrollable ResultSet,
    the absolute() method positions the cursor.
    -1 means the last row.
    1 means the first row.
    0 means before the first row.
    Therefore, choice B is correct.

There is also a method beforeFirst() that is equivalent,
    making choice D correct as well.

For more information, see Chapter 10.
 */