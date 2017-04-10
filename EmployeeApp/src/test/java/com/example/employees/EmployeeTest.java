package com.example.employees;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by p on 08/09/2016.
 */
public class EmployeeTest {

    private Employee em;

    @Before
    public void setUp() throws Exception {
        em = new Employee(
                "pedro alves",
                "alves",
                "08-09-2016",
                "system developer",
                "IT-Klinikk",
                "pedro.alves@it-klinikk.no",
                10L);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetId() throws Exception {
        assertEquals(10l,em.getId());
    }

    @Test
    public void testSetId() throws Exception {
        em.setId(20L);
        assertEquals(20L,em.getId());
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("pedro alves",em.getName());
    }

    @Test
    public void testSetName() throws Exception {
        em.setName("pa");
        assertEquals("pa",em.getName());
    }

    @Test
    public void testToString() throws Exception {
        Employee expected = new Employee(
                "pedro alves",
                "alves",
                "08-09-2016",
                "system developer",
                "IT-Klinikk",
                "pedro.alves@it-klinikk.no",
                10L);

        assertEquals(expected.toString(), em.toString());
    }
}