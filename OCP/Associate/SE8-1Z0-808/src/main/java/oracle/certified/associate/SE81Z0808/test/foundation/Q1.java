package oracle.certified.associate.SE81Z0808.test.foundation;

/**
 * Created by p on 04/06/2015.
 */
public class Q1 {

    //static {if(true) throw new NullPointerException();}
    //Exception in thread "main" java.lang.ExceptionInInitializerError

    //static {throw new NullPointerException();}
    // Error:(10, 5) java: initializer must be able to complete normally


    public static void main(String ... args) {
        boolean b = true;

        if(b);
        else
            ;

        switch(2){
        }

        final int i = 2;
        final int j = 2;

        switch(2) {
            case i: break;
            //case j: break;//Error:(30, 13) java: duplicate case label
        }

        final long l = 10;
        int ii = (int) l;

        do{

        }while(false);

       System.out.println(new Boolean("true") == Boolean.parseBoolean("true"));

        System.out.println(new Boolean("true") == new Boolean("true"));

        int i3 = 10;
        char c = (char) i;

        switch(i){
            case 'a':break;
        }

        int _i = 0;
        int $iii = 2;


        String: for(;;){
            break String;
        }

        //for(int i = 0;; ){}//Error:(55, 17) java: variable i is already defined in method main(java.lang.String...)


        String String = "";
        String: for( int w=0; w<10; w++){
          for(int z = 0; z<10; z++){
              if(w + z > 10) break String;

          }
            System.out.println("hello");
        }

         for(;;) {

        }


    }


}



