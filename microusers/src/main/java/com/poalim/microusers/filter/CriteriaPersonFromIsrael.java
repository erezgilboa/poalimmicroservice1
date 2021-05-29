package com.poalim.microusers.filter;

import com.poalim.microusers.enums.State;
import com.poalim.microusers.viewmodel.PersonVm;

import java.util.List;
import java.util.stream.Collectors;

public class CriteriaPersonFromIsrael implements Criteria {

    @Override
    public List<PersonVm> meetCriteria(List<PersonVm> persons) {
        List<PersonVm> result = persons.stream()
                .filter(PersonVm -> State.Israel.equals(PersonVm.getAddressVm().getState()))
                .collect(Collectors.toList());
        return result;
    }
}
