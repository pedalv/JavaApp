package oracle.certified.associate.SE81Z0808.test2;

/**
 * Created by p on 11/06/2015.
 */
public class Q15 {

    public void initData(String[] arr){
        int ind = 0;
        for(String str : arr){
            str.concat(str+" "+ind);
            ind++;
        }
    }

    public void printData(String [] arr){
        for(String str : arr){
            System.out.println(str);
        }
    }

    public static void main(String [] args){
        Q15 ot = new Q15();
        String [] arr = new String [2];
        ot.initData(arr);
        ot.printData(arr);
    }


}



