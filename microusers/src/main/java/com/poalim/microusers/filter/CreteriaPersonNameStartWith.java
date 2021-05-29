package com.poalim.microusers.filter;

import com.poalim.microusers.viewmodel.PersonVm;

import java.util.List;
import java.util.stream.Collectors;

public class CreteriaPersonNameStartWith {

    public List<PersonVm> meetCriteria(List<PersonVm> persons, String startName) {
        List<PersonVm> result = persons.stream()
                .filter(person -> person.getName().startsWith(startName))
                .collect(Collectors.toList());
        return result;
    }
}
