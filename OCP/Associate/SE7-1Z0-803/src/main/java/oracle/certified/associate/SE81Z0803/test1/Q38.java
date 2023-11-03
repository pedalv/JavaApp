package oracle.certified.associate.SE81Z0803.test1;

/**
 * Created by pedro alves on 24/05/15.
 */
public class Q38 {

    int x = 5;
    int getX() {return x;}

    public static void main(String args[]) throws Exception{
        Q38 tc = new Q38();
        tc.looper();
        System.out.println(tc.x);
    }

    private void looper() {
        //int x = 0;
        while( (x = getX() ) != 0 ){
            for(int m = 2; m>=0; m--){
                x=m;
            }
        }
    }

}
