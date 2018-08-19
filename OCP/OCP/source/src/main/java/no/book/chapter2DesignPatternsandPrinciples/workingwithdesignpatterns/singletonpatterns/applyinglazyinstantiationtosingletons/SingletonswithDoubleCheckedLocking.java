package no.book.chapter2DesignPatternsandPrinciples.workingwithdesignpatterns.singletonpatterns.applyinglazyinstantiationtosingletons;

/*

 */
public class SingletonswithDoubleCheckedLocking {

    private static volatile VisitorTicketTracker instance;

    public static VisitorTicketTracker getInstance() {
        if(instance == null) {
            synchronized(VisitorTicketTracker.class) {
                if(instance == null) {
                    instance = new VisitorTicketTracker();
                }
            }
        }
        return instance;
    }

}
