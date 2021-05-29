package com.poalim.microusers.servicemanager.personservice;

import com.poalim.microusers.viewmodel.PersonVm;
import com.poalim.microusers.viewmodel.VmDeleteResult;

import java.util.List;

public interface PersonService {

    List<PersonVm> getPersons();

    PersonVm getPersonById(String id);

    PersonVm savePerson(PersonVm groupVm);

    VmDeleteResult deletePerson(String personVmId);
}
