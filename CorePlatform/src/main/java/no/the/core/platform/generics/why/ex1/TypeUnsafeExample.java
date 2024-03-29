package no.the.core.platform.generics.why.ex1;

public class TypeUnsafeExample
{
    public static void main(String[] args)
    {
        CircularBuffer buffer = new CircularBuffer(10);

        buffer.offer("a");
        buffer.offer("bc");
        buffer.offer("d");

        // ClassCastException
        buffer.offer(1);

        String value = concatenate(buffer);
        System.out.println(value);
    }

    private static String concatenate(CircularBuffer buffer)
    {
        StringBuilder result = new StringBuilder();

        String value;
        while ((value = (String) buffer.poll()) != null)
        {
            result.append(value);
        }

        return result.toString();
    }
}
