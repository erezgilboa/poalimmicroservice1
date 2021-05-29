package com.poalim.microusers.filter;

import com.poalim.microusers.viewmodel.PersonVm;

import java.util.List;

public class OrCriteria implements Criteria {
    private Criteria criteria;
    private Criteria otherCriteria;

    public OrCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<PersonVm> meetCriteria(List<PersonVm> persons) {
        List<PersonVm> firstCriteriaItems = criteria.meetCriteria(persons);
        List<PersonVm> otherCriteriaItems = otherCriteria.meetCriteria(persons);

        for (PersonVm person : otherCriteriaItems) {
            if (!firstCriteriaItems.contains(person)) {
                firstCriteriaItems.add(person);
            }
        }
        return firstCriteriaItems;
    }
}
