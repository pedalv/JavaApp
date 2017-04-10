package no.insurance.service;

import no.insurance.domain.Letter;
import no.insurance.repository.LetterRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by p on 29/10/2016.
 */
@RestController
@RequestMapping("api/v1/")
public class LetterService {
    @Autowired
    private LetterRepository _letterRepository;


    @RequestMapping(value = "letter", method = RequestMethod.GET)
    public List<Letter> list() {

        return _letterRepository.findAll();
    }

    @RequestMapping(value = "letter", method = RequestMethod.POST)
    public Letter create(@RequestBody Letter letter) {

        return _letterRepository.save(letter);
    }

    @RequestMapping(value = "letter/{id}", method = RequestMethod.GET)
    public Letter get(@PathVariable Long id) {

        return _letterRepository.findOne(id);
    }

    @RequestMapping(value = "letter/{id}", method = RequestMethod.PUT)
    public Letter update(@PathVariable Long id, @RequestBody Letter letter) {

        Letter existingLetter = _letterRepository.findOne(id);
        BeanUtils.copyProperties(letter, existingLetter);
        return _letterRepository.save(existingLetter);

    }

    @RequestMapping(value = "letter/{id}", method = RequestMethod.DELETE)
    public Letter delete(@PathVariable Long id) {

        Letter existingLetter = _letterRepository.findOne(id);
        _letterRepository.delete(existingLetter);
        return existingLetter;
    }

}
