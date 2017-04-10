package no.insurance.repository;

import no.insurance.domain.Letter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

/**
 * Created by p on 29/10/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LetterRepositoryTest {

    @Autowired
    private LetterRepository _letterRepository;

    @Test
    public void testFindAll() {
        List<Letter> letters = _letterRepository.findAll();
        assertThat(letters.size(), is(greaterThanOrEqualTo(0)));
    }

    @Test
    public void test_located_LetterService(){
        /*
        //_letterRepository.findAll();
        _letterRepository.saveAndFlush(letter);
        _letterRepository.findOne(id);
        _letterRepository.saveAndFlush(existingLetter);
        _letterRepository.delete(existingLetter);
        */
    }
}
