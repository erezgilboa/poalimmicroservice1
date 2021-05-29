package com.poalim.microusers.filter;

import com.poalim.microusers.entities.Person;
import com.poalim.microusers.viewmodel.PersonVm;

import java.util.List;

public interface Criteria {
    public List<PersonVm> meetCriteria(List<PersonVm> persons);
}
