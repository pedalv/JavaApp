package no.insurance.Service;

import no.insurance.domain.Letter;
import no.insurance.helper.Insurance;
import no.insurance.helper.State;
import no.insurance.repository.LetterRepository;
import no.insurance.service.LetterService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by p on 29/10/2016.
 */
public class LetterServiceTest {
    private Letter expectedLetter;
    private List<Letter> expectedLetters;
    private Long userId1;

    @InjectMocks
    private LetterService _letterServiceMock;

    @Mock
    private LetterRepository _letterRepositoryMock;

    @Before
    public void setUp() throws Exception {
        expectedLetters = new ArrayList<Letter>();
        userId1 = 1L;
        expectedLetter = new Letter(1L, userId1, Insurance.CAR.getValue(), "product got for my car", State.SEND.getValue(), 3450.5);
        expectedLetters.add(expectedLetter);

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testList() throws Exception {
        //MOCHITO
        when(_letterRepositoryMock.findAll()).thenReturn(expectedLetters);

        List<Letter> actualLetters = _letterServiceMock.list();

        assertNotNull(actualLetters);
        assertEquals(actualLetters.toArray().length,1);

        //verify if method was call
        verify(_letterRepositoryMock).findAll();

        assertEquals( expectedLetters.get(0).getId().longValue(), actualLetters.get(0).getId().longValue() );

        //Hamcrest
        assertThat(expectedLetters.get(0).getId(), is(actualLetters.get(0).getId()));
    }

    @Test
    public void testCreate() throws Exception {
        Letter letterCreate = new Letter(userId1, Insurance.THING.getValue(), "product got for my thing", State.ACTIVE.getValue(), 7999.5);

        //MOCHITO
        when(_letterRepositoryMock.save(letterCreate)).thenReturn(letterCreate);

        Letter created = _letterServiceMock.create(letterCreate);
        assertNotNull(created);

        //verify if method was call
        verify(_letterRepositoryMock).save(letterCreate);

        assertEquals(created.toString(),letterCreate.toString());
    }

    @Test
    public void testGet() throws Exception {
        Letter lettergetOne = new Letter(1L, userId1, Insurance.THING.getValue(), "product got for my thing", State.ACTIVE.getValue(), 7999.5);

        //MOCHITO
        when(_letterRepositoryMock.findOne(1L)).thenReturn(lettergetOne);

        Letter getActual = _letterServiceMock.get(1L);
        assertNotNull(getActual);

        //verify if method was call
        verify(_letterRepositoryMock).findOne(1L);
    }

    @Test
    public void testUpdate() throws Exception {

        Letter letterfind = new Letter(1L, userId1, Insurance.THING.getValue(), "product got for my thing", State.ACTIVE.getValue(), 7999.5);
        Letter letterChange = new Letter(1L, userId1, Insurance.THING.getValue(), "product got for my thing", State.ACTIVE.getValue(), 0.5);

        //MOCHITO
        when(_letterRepositoryMock.findOne(1L)).thenReturn(letterfind);
        when(_letterRepositoryMock.save(letterChange)).thenReturn(letterChange);

        _letterServiceMock.update(1L, letterChange);

        //verify if method was call
        verify(_letterRepositoryMock).findOne(1L);
        verify(_letterRepositoryMock).save(letterfind);

        assertEquals(letterfind.getPrice(),letterChange.getPrice());
        assertNotNull(letterfind);

    }

    @Test
    public void testDelete() throws Exception {

        Letter letterdelete = new Letter(1L, userId1, Insurance.THING.getValue(), "product got for my thing", State.ACTIVE.getValue(), 7999.5);

        //MOCHITO
        when(_letterRepositoryMock.findOne(1L)).thenReturn(letterdelete);


        Letter LetterUpdated = _letterServiceMock.delete(1L);

        //verify if method was call
        verify(_letterRepositoryMock).findOne(1L);



    }
}
