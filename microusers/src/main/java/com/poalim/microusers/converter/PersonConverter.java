package com.poalim.microusers.converter;

import com.poalim.microusers.entities.Address;
import com.poalim.microusers.entities.Person;
import com.poalim.microusers.viewmodel.AddressVm;
import com.poalim.microusers.viewmodel.PersonVm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonConverter implements EntityConverter<PersonVm, Person> {

    @Autowired
    private EntityConverter<AddressVm, Address> addressEntityConverter;


    @Override
    public Person convertFromF(PersonVm personVm) {
        Person person = new Person();
        person.setAge(personVm.getAge());
        person.setGender(personVm.getGender());
        person.setHeight(personVm.getHeight());
        person.setWeight(personVm.getWeight());
        person.setName(personVm.getName());
        person.setAddress(addressEntityConverter.convertFromF(personVm.getAddressVm()));
        return person;

    }

    @Override
    public PersonVm convertFromDB(Person person) {
        PersonVm personVm = new PersonVm();
        personVm.setAge(person.getAge());
        personVm.setGender(person.getGender());
        personVm.setHeight(person.getHeight());
        personVm.setWeight(person.getWeight());
        personVm.setId(person.getId());
        personVm.setName(person.getName());
        personVm.setAddressVm(addressEntityConverter.convertFromDB(person.getAddress()));
        return personVm;
    }

    @Override
    public List<Person> convertListFromF(List<PersonVm> personVmList) {
        if (personVmList == null)
            return null;
        List<Person> personList = new ArrayList<>();
        for (PersonVm personVm : personVmList)
            personList.add(convertFromF(personVm));
        return personList;
    }

    @Override
    public List<PersonVm> convertListFromDB(List<Person> personList) {
        if (personList == null)
            return null;
        List<PersonVm> personVmList = new ArrayList<>();
        for (Person person : personList)
            personVmList.add(convertFromDB(person));
        return personVmList;
    }
}
