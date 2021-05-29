package com.poalim.microusers.filter;

import com.poalim.microusers.utils.FieldConstants;
import com.poalim.microusers.viewmodel.PersonVm;

import java.util.List;
import java.util.stream.Collectors;

public class CriteriaOverWeightPerson implements Criteria {
    @Override
    public List<PersonVm> meetCriteria(List<PersonVm> persons) {
        Double midWeight = (FieldConstants.maxWeight + FieldConstants.minWeight) / 2;
        List<PersonVm> result = persons.stream()
                .filter(person -> person.getWeight() != null && person.getWeight() > midWeight)
                .collect(Collectors.toList());
        return result;
    }
}
