package no.the.core.platform.collections.queues.c_stacks;

import no.the.core.platform.collections.model.Enquiry;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

import static java.lang.Integer.parseInt;

public class d 
{

    /*
    1
    -
    3
    +
    2
    +
    4
    */

    public int evalute(final String input)
    {
        //Stack is deprecated so we have a new collection Deque to do the same job
        final Deque<String> stack = new ArrayDeque<>();
        //for compare with the new collection Deque
        //private Queue<Enquiry> enquiries = new ArrayDeque<>();

        final String[] tokens = input.split(" ");
        for (String token : tokens)
        {
            stack.add(token);
        }

        while (stack.size() > 1)
        {
            final int left = parseInt(stack.pop());
            final String operator = stack.pop();
            final int right = parseInt(stack.pop());

            int result = 0;
            switch (operator)
            {
                case "+":
                    result = left + right;
                    break;

                case "-":
                    result = left - right;
                    break;
            }

            stack.push(String.valueOf(result));
        }

        return parseInt(stack.pop());
    }
}
