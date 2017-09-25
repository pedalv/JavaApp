package no.the.core.platform.generics.why.ex2;

import no.the.core.platform.generics.why.ex3.GenericCircularBuffer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCircularBufferTest {

    private GenericCircularBuffer<Integer> buffer = new GenericCircularBuffer<>(2);

    @Test
    public void shouldOfferPollableElement()
    {
        assertTrue(buffer.offer(1));

        assertEquals(Integer.valueOf(1), buffer.poll());
    }

    @Test
    public void shouldNotOfferWhenBufferIsFull()
    {
        assertTrue(buffer.offer(1));
        assertTrue(buffer.offer(2));
        assertFalse(buffer.offer(3));
    }

    @Test
    public void shouldNotPollWhenBufferIsEmpty()
    {
        assertNull(buffer.poll());
    }

    @Test
    public void shouldRecycleBuffer()
    {
        assertTrue(buffer.offer(1));
        assertTrue(buffer.offer(2));
        assertEquals(Integer.valueOf(1), buffer.poll());
        assertTrue(buffer.offer(3));
        assertEquals(Integer.valueOf(2), buffer.poll());
        assertEquals(Integer.valueOf(3), buffer.poll());
    }

}