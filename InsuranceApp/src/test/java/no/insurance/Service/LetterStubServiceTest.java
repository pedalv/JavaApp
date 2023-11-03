package no.insurance.Service;

import no.insurance.domain.Letter;
import no.insurance.helper.Insurance;
import no.insurance.helper.State;
import no.insurance.service.LetterStubService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by p on 29/10/2016.
 */
public class LetterStubServiceTest {
    private Letter expectedLetter;
    private List<Letter> expectedLetters;
    private Long userId1;

    @InjectMocks
    private LetterStubService _letterSubServiceMock;

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

        List<Letter> actualLetters = _letterSubServiceMock.list();

        assertNotNull(actualLetters);
        assertEquals(expectedLetters.toArray().length,1);

        // data is static
        assertEquals(actualLetters.toArray().length,3);

        assertEquals( expectedLetters.get(0).getId().longValue(), actualLetters.get(0).getId().longValue() );
    }

    @Test
    public void testCreate() throws Exception {

        Letter letterCreate = new Letter(userId1, Insurance.CAR.getValue(), "product got for my car", State.SEND.getValue(), 3450.5);
        _letterSubServiceMock.create(letterCreate);

        List<Letter> actualLetters = _letterSubServiceMock.list();
        assertNotNull(actualLetters);
        assertEquals(actualLetters.toArray().length,4);
    }

    @Test
    public void testGet() throws Exception {
        Letter actualLetter = _letterSubServiceMock.get(1L);
        assertNotNull(actualLetter);
    }

    @Test
    public void testUpdate() throws Exception {
        Letter actualLetter = _letterSubServiceMock.get(3L);
        actualLetter.setPrice(799.0);
        Letter expectedLetter = _letterSubServiceMock.update(3L, actualLetter);

        // data is static
        assertEquals(expectedLetter.getPrice().doubleValue(),799.0,0.5);
    }

    @Test
    public void testDelete() throws Exception {
        List<Letter> actualLetters = _letterSubServiceMock.list();
        assertNotNull(actualLetters);
        assertEquals(actualLetters.toArray().length,4);

        _letterSubServiceMock.delete(4L);
        actualLetters = _letterSubServiceMock.list();
        assertNotNull(actualLetters);
        assertEquals(actualLetters.toArray().length,3);
    }
}
