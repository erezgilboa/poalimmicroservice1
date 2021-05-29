package com.poalim.microusers.servicemanager.personservice;

import com.poalim.microusers.converter.PersonConverter;
import com.poalim.microusers.dao.PersonRepository;
import com.poalim.microusers.entities.Person;
import com.poalim.microusers.viewmodel.PersonVm;
import com.poalim.microusers.viewmodel.VmDeleteResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PersonServiceImpl implements PersonService{

    private HashMap<String,Person> personHashMap = new HashMap<>();
    private PersonRepository personRepository;
    private PersonConverter personConverter;
    private static final Logger logger = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, PersonConverter personConverter) {
        this.personRepository = personRepository;
        this.personConverter = personConverter;
    }

    @PostConstruct
    public void init() {
        //when run real -will use redis instead of map ,map only for limit amount of users
        List<Person> personList = personRepository.findAll();
        for(Person person:personList)
            personHashMap.put(person.getId(),person);
    }

    @Override
    public List<PersonVm> getPersons() {
        List<Person> persons=new ArrayList<>();
        logger.info("get all persons ");
        for (Person s : personHashMap.values())
            persons.add(s);
        return personConverter.convertListFromDB(persons);
    }

    @Override
    public PersonVm getPersonById(String id) {
        logger.info("get person with id: "+id);
        for(Map.Entry<String,Person> entry:personHashMap.entrySet())
        {
            if(entry.getKey().equals(id))
                return personConverter.convertFromDB(entry.getValue());
        }
        logger.warn("cant find person with id: "+id);
        return null;
    }

    @Override
    public PersonVm savePerson(PersonVm personVm) {
        logger.info("save person: "+personVm.toString());
        Person person=personRepository.save(personConverter.convertFromF(personVm));
        personHashMap.put(person.getId(),person);
        return personConverter.convertFromDB(person);
    }

    @Override
    public VmDeleteResult deletePerson(String personVmId) {
        try {
            logger.info("delete person with id : "+personVmId);
            Person person=personHashMap.get(personVmId);
            personRepository.delete(person);
            personHashMap.remove(personVmId);
            return new VmDeleteResult(true,"");
        }
        catch (Exception e)
        {
            logger.error("error to delete person with id : "+personVmId+" error:"+e.toString());
            return new VmDeleteResult(false,e.toString());
        }

    }
}
