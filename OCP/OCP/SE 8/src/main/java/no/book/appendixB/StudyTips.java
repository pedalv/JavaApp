package no.book.appendixB;

public class StudyTips {


    protected static String defaultedRegards() {
        return "Hei M";
    }

    public static void main (String ... args) {

        System.out.println(defaultedRegards());

        ApendixBSample();

        trackingVariableChanges();

        trackingStringorArrayIndices();

    }

    private static void trackingStringorArrayIndices() {
        String mammal = "DOLPHIN";
        String modified = mammal.substring(2,mammal.indexOf('I'));
        modified += "x" + mammal.substring(4);
        System.out.println(modified);
    }

    private static void trackingVariableChanges() {
        int x = 0;
        int y = 10;
        while (x < y) {
            System.out.println("<><>");
            for(int i=2; i<5; i++, x++) {
                x++;
                System.out.println("—");
            }
        }
        System.out.println(x+","+y);
    }

    private static void ApendixBSample() {
        //float value = 102.0; // Error:(21, 23) java: incompatible types: possible lossy conversion from double to float
        float value = 102.0f;
        float value1 = 102;
        float value2 = (int)102.0;
        //float value3 = 1f * 0.0; // Error:(23, 27) java: incompatible types: possible lossy conversion from double to float
        float value4 = 1f * (short)0.0;
        //float value5 = 1f * (boolean)0; // Error:(25, 38) java: incompatible types: int cannot be converted to boolean
    }

}
