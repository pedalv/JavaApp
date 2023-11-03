package no.the.core.platform.collections.queues.b_priority_queues;

import no.the.core.platform.collections.model.Category;
import no.the.core.platform.collections.model.Customer;
import no.the.core.platform.collections.model.Enquiry;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import static java.util.Comparator.comparing;

public class PriorityHelpDeskJava8
{
    /*
    private static final Comparator<Enquiry> BY_CATEGORY = new Comparator<Enquiry>()
    {
        public int compare(final Enquiry o1, final Enquiry o2)
        {
            return o1.getCategory().compareTo(o2.getCategory());
        }
    }; // Java 7
    */

    private static final Comparator<Enquiry> BY_CATEGORY = comparing(Enquiry::getCategory);

    //priority by category: OUT [Jill, Mary, Jack]
    private Queue<Enquiry> enquiries = new PriorityQueue<>(BY_CATEGORY);

    //no priority: OUT [Jack, Jill, Mary]
    //private Queue<Enquiry> enquiries = new ArrayDeque<>();

    public boolean enquire(final Customer customer, final Category type)
    {
        return enquiries.offer(new Enquiry(customer, type));
    }

    public void processAllEnquires()
    {
        Enquiry enquiry;
        while ((enquiry = enquiries.poll()) != null)
        {
            enquiry.getCustomer().reply("Have you tried turning it off and on again?");
        }
    }

    public static void main(String[] args)
    {
        PriorityHelpDeskJava8 helpDesk = new PriorityHelpDeskJava8();

        helpDesk.enquire(Customer.JACK, Category.PHONE);
        helpDesk.enquire(Customer.JILL, Category.PRINTER);
        helpDesk.enquire(Customer.MARY, Category.COMPUTER);

        helpDesk.processAllEnquires();
    }
}
