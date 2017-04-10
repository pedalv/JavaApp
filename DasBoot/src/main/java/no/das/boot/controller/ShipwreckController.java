package no.das.boot.controller;

import no.das.boot.model.Shipwreck;
import no.das.boot.repository.ShipwreckRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by p on 13/09/2016.
 */
@RestController
@RequestMapping("api/v1/")
public class ShipwreckController {

    @Autowired
    private ShipwreckRepository _shipwreckRepository;

    @RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
    public List<Shipwreck> list() {
        return _shipwreckRepository.findAll();
        //return ShipwreckStub.list();
    }

    @RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
    public Shipwreck create(@RequestBody Shipwreck shipwreck) {
        return _shipwreckRepository.saveAndFlush(shipwreck);
        //return ShipwreckStub.create(shipwreck);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
    public Shipwreck get(@PathVariable Long id) {
        return _shipwreckRepository.findOne(id);
        //return ShipwreckStub.get(id);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
    public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck) {
        Shipwreck existingShipwreck = _shipwreckRepository.findOne(id);
        BeanUtils.copyProperties(shipwreck, existingShipwreck);
        return _shipwreckRepository.saveAndFlush(existingShipwreck);
        //return ShipwreckStub.update(id, shipwreck);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
    public Shipwreck delete(@PathVariable Long id) {
        Shipwreck existingShipwreck = _shipwreckRepository.findOne(id);
        _shipwreckRepository.delete(existingShipwreck);
        return existingShipwreck;
        //return ShipwreckStub.delete(id);

        //NOTE: return void is possible also
    }

}
