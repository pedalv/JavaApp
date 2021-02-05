package no.agitec.fagaften.mellom.oppdrag;

public class TesteInner {

    class Inner_Demo {
        public void print() {
            if(TesteInner.this.temp) {
                System.out.println("This is the print method of the inner class");
            }
        }
    }

    Boolean temp = true;

    public TesteInner(){
        try {
            new Inner_Demo().print();
        } catch (Exception e) {
            //
        } finally {
            System.out.println("finaly");
        }
    }

    public static void main(String... args) {
        new TesteInner();
    }

}


    /*

        //https://stackoverflow.com/questions/27086377/get-previous-and-next-row-from-rows-selected-with-where-conditions

        SELECT a.name, b.name
        FROM   Language a
        WHERE  ID IN(SELECT ID + 1
                     FROM   Language b
                     ORDER BY a.salaru desc) -- will fetch next rows
                AND a.Salary > b.Salary	-- compare salary
        order by a.salary desc
        ;

     */
