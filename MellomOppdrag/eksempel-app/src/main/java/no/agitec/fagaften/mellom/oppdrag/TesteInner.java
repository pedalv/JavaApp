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
        new Inner_Demo().print();
    }

    public static void main(String... args) {
        new TesteInner();
        System.out.println("End");
    }

}
