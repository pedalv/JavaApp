package no.insurance.service;

import no.insurance.Stub.LetterStub;
import no.insurance.domain.Letter;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by p on 29/10/2016.
 */
@RestController
@RequestMapping("api/v1/")
public class LetterStubService {
    @RequestMapping(value = "letterstub", method = RequestMethod.GET)
    public List<Letter> list() {

        return LetterStub.list();
    }

    @RequestMapping(value = "letterstub", method = RequestMethod.POST)
    public Letter create(@RequestBody Letter letter) {

        return LetterStub.create(letter);
    }

    @RequestMapping(value = "letterstub/{id}", method = RequestMethod.GET)
    public Letter get(@PathVariable Long id) {

        return LetterStub.get(id);
    }

    @RequestMapping(value = "letterstub/{id}", method = RequestMethod.PUT)
    public Letter update(@PathVariable Long id, @RequestBody Letter letter) {

        Letter existingLetter = LetterStub.get(id);
        BeanUtils.copyProperties(letter, existingLetter);
        return LetterStub.update(id, existingLetter);

    }

    @RequestMapping(value = "letterstub/{id}", method = RequestMethod.DELETE)
    public Letter delete(@PathVariable Long id) {

        Letter existingLetter = LetterStub.get(id);
        LetterStub.delete(id);
        return existingLetter;

    }
}
