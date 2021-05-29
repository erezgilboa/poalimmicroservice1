package com.poalim.microusers.controller;

import com.poalim.microusers.filter.*;
import com.poalim.microusers.servicemanager.personservice.PersonService;
import com.poalim.microusers.utils.ResultWithSuccess;
import com.poalim.microusers.viewmodel.FindCreteria;
import com.poalim.microusers.viewmodel.PersonVm;
import com.poalim.microusers.viewmodel.VmDeleteResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(AddressConstants.personEndPoint)
public class UserController {
    @Autowired
    private PersonService personService;

    @Autowired
    private PersonValidation personValidation;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(method = RequestMethod.POST, value = AddressConstants.saveOrUpdate)
    public ResponseEntity<PersonVm> saveOrUpdate(@RequestBody PersonVm entity) {
        ResultWithSuccess<String> resultWithSuccess = personValidation.validateSavePerson(entity);
        if (resultWithSuccess.isSuccess()) {
            PersonVm saved = personService.savePerson(entity);
            return new ResponseEntity<>(saved, HttpStatus.OK);
        }
        logger.error("cant save error validation:" + resultWithSuccess.getResult());
        PersonVm personVm = new PersonVm();
        personVm.setSaveResult(resultWithSuccess);
        return new ResponseEntity<>(personVm, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = AddressConstants.delete)
    public ResponseEntity<VmDeleteResult> delete(@RequestBody String id) {
        VmDeleteResult vmDeleteResult = personService.deletePerson(id);
        return new ResponseEntity<>(vmDeleteResult, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = AddressConstants.findALL)
    public ResponseEntity<List<PersonVm>> findAll() {
        List<PersonVm> all = personService.getPersons();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = AddressConstants.findById)
    public ResponseEntity<PersonVm> findById(@RequestBody String id) {
        PersonVm personVm = personService.getPersonById(id);
        return new ResponseEntity<>(personVm, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = AddressConstants.findByPrefix)
    public ResponseEntity<List<PersonVm>> findByPrefix(@RequestBody  FindCreteria findCreteria) {
        List<PersonVm> all = personService.getPersons();
        List<PersonVm> filters = filterUserStartWithOr(all, findCreteria);
        return new ResponseEntity<>(filters, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = AddressConstants.findFatPeopleInIsrael)
    public ResponseEntity<List<PersonVm>> findFatPeopleInIsrael() {
        List<PersonVm> all = personService.getPersons();
        Criteria fat = new CriteriaOverWeightPerson();
        Criteria fromIsrael = new CriteriaPersonFromIsrael();
        AndCriteria andCriteria = new AndCriteria(fat, fromIsrael);
        List<PersonVm> filters = andCriteria.meetCriteria(all);
        return new ResponseEntity<>(filters, HttpStatus.OK);
    }

    private List<PersonVm> filterUserStartWithOr(List<PersonVm> personVms, FindCreteria findCreteria) {

        List<PersonVm> filterList = new ArrayList<>();
        CreteriaPersonNameStartWith creteriaPersonNameStartWith = new CreteriaPersonNameStartWith();
        for (String start : findCreteria.getNameStartWith()) {
            List<PersonVm> clonedList = clonePersonList(personVms);
            filterList.addAll(creteriaPersonNameStartWith.meetCriteria(clonedList, start));

        }
        return filterList;
    }

    private List<PersonVm> clonePersonList(List<PersonVm> personVms) {
        List<PersonVm> clonedList = new ArrayList<>();
        for (PersonVm personVm : personVms) {
            PersonVm personVm1 = personVm.clone();
            clonedList.add(personVm1);
        }
        return clonedList;
    }


}
