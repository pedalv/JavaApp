package no.insurance.service;

import no.insurance.domain.User;
import no.insurance.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by p on 29/10/2016.
 */
@RestController
@RequestMapping("api/v1/")
public class UserService {

    @Autowired
    private UserRepository _userRepository;


    @RequestMapping(value = "user", method = RequestMethod.GET)
    public List<User> list() {

        return _userRepository.findAll();
    }

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public User create(@RequestBody User user) {

        return _userRepository.save(user);
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public User get(@PathVariable Long id) {

        return _userRepository.findOne(id);
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.PUT)
    public User update(@PathVariable Long id, @RequestBody User user) {

        User existingUser = _userRepository.findOne(id);
        BeanUtils.copyProperties(user, existingUser);
        return _userRepository.save(existingUser);

    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public User delete(@PathVariable Long id) {

        User existingUser = _userRepository.findOne(id);
        _userRepository.delete(existingUser);
        return existingUser;
    }
}
