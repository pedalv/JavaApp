package oracle.certified.associate.SE81Z0803.test6.last;

/**
 * Created by pedro alves on 24/05/15.
 */
public class Q55 {

    public static void main(String ... args){
        int [] arr ={1,2,3,4,5,6};
        int counter = 0;
        for(int value: arr){
            counter+=1;
            if(counter >=2){
                System.out.println("break"+counter);
                break;

            } else {
                System.out.println("continue"+counter);
                continue;
            }
            //System.out.println("end"+counter);

        }
        System.out.println("out");
    }


    //Q: Using a break in a while loop causes the loop to break
    // the current iteration and start the next iteration of the loop.
    // A: false
    //The break statement is to break out of any loop completely.
    // So the current iteration and any other remaining iterations
    // of the loop will not execute.
    //Control is transferred to the first statement after the loop.
}
