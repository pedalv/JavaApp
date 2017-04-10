package no.das.boot.controller;

import no.das.boot.model.Shipwreck;
import no.das.boot.repository.ShipwreckRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by p on 14/09/2016.
 */
public class ShipwreckControllerTest {

    @InjectMocks
    private ShipwreckController sc;

    @Mock
    private ShipwreckRepository shipwreckRepository;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testList() throws Exception {

    }

    @Test
    public void testCreate() throws Exception {

    }

    @Test
    public void testGet() throws Exception {

        //MOCHITO

        Shipwreck sw = new Shipwreck();
        sw.setId(1l);
        when(shipwreckRepository.findOne(1l)).thenReturn(sw);

        Shipwreck wreck = sc.get(1L);

        //verify if method was call
        verify(shipwreckRepository).findOne(1l);

        assertEquals( 1L, wreck.getId().longValue() );

        //Hamcrest
        assertThat(wreck.getId(), is(1l));
    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }
}