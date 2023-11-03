package oracle.certified.associate.SE81Z0803.test6.last;

/**
 * Created by pedro alves on 23/05/15.
 */
public class Q67 {

    public void testRefs(String str, StringBuilder sb){
        str = str + sb.toString();
        sb.append(str);
        str = null;
        sb = null;
    }

    public static void main(String [] args){
        String s = "aaa";
        StringBuilder sb = new StringBuilder("bbb");
        new Q67().testRefs(s, sb);
        System.out.println("s="+s+" sb="+sb);
    }

}
