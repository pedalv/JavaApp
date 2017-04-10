package no.insurance.repository;

import no.insurance.domain.User;
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
public class UserRepositoryTest {

    @Autowired
    private UserRepository _userRepository;

    @Test
    public void testFindAll() {
        List<User> letters = _userRepository.findAll();
        assertThat(letters.size(), is(greaterThanOrEqualTo(0)));
    }

    @Test
    public void test_located_UserService(){
        /*
        //_userRepository.findAll();
        _userRepository.saveAndFlush(letter);
        _userRepository.findOne(id);
        _userRepository.saveAndFlush(existingLetter);
        _userRepository.delete(existingLetter);
        */
    }
}
