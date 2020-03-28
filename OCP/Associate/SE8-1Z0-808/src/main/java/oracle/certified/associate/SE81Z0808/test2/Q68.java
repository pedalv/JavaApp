package oracle.certified.associate.SE81Z0808.test2;

/**
 * Created by p on 31/05/2015.
 */
public class Q68 {

    public String title;
    public int id;

    public Q68() {}
    public Q68(String title, int id){
       this.title = title;
        this.id = id;
    }

    public static void main(String ... args){
        Q68 [] pappers = {
                 new Q68("T1", 1),
                new Q68("T2", 2),
                new Q68("T3", 3)
        };

        Q68 c  = new Q68();
        System.out.println(pappers);
        System.out.println(pappers[1]);
        System.out.println(pappers[1].id);
        System.out.println(new Q68());
        System.out.println(c);
        System.out.println(c.getClass());
        System.out.println(c.toString());




    }




}
